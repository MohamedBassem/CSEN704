class User < ActiveRecord::Base

	default_scope {where verified: 1}
  has_many :owned_courses, :foreign_key => 'owner_id', :class_name => 'Course'
  has_many :subscribing_courses, :foreign_key => 'course_id', :through => :course_subscription
  has_many :course_invitations, class_name: "CourseInvitation"
  has_many :reminders
  has_many :answers, dependent: :destroy

  attr_accessor :password

  validates :name, :email, :presence => true
  validates :email, :uniqueness => true
  validates :email, :format => { with: /\A([^@\s]+)@((?:[-a-z0-9]+\.)+[a-z]{2,})\z/i }
  validates :password, :length => {in: 6..30}

  before_save :encrypt_password
  before_create :generate_verification_code

  def self.unverified
  	self.unscoped.where(verified: 0)
  end

  def self.authenticate email, password
    if email.present? && password.present?
      if user = User.find_by(email: email)
        if user.valid_password? password
          user
        end
      end
    end
  end

  def valid_password?(password)
    self.encrypted_password == Digest::MD5.hexdigest(password)
  end

  def encrypt_password
    self.encrypted_password = Digest::MD5.hexdigest(@password) if @password
  end

  def create_course(dict)
    self.owned_courses.create(dict)
  end

  def ask_to_follow(course)
  	course.ask_to_subscribe self
  end

  def generate_verification_code
  	code = (0...50).map { (('a'..'z').to_a + ('A'..'Z').to_a)[rand(26*2)] }.join
  	self.verification_code = code
  end

  def verify
  	self.update(verified: 1)
  end


end
