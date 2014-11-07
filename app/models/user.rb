class User < ActiveRecord::Base

	has_many :owned_courses, :foreign_key => 'owner_id', :class_name => 'Course'

	attr_accessor :password

	validates :name, :email, :presence => true
	validates :email, :uniqueness => true
	validates :email, :format => { with: /\A([^@\s]+)@((?:[-a-z0-9]+\.)+[a-z]{2,})\z/i }
	validates :password, :length => {in: 6..30}

	before_save :encrypt_password

	def self.authenticate email, password
		if email.present? && password.present?
			if user = User.find_by(email: email)
				
				if user.is_valid_password(password)
					user
				end 
			end
		end
	end

	def is_valid_password(password)
		self.encrypted_password == Digest::MD5.hexdigest(password)
	end 

	def encrypt_password
		self.encrypted_password = Digest::MD5.hexdigest(@password)
	end

end
