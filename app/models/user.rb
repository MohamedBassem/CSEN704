class User < ActiveRecord::Base

  has_many :announcements, inverse_of: :user
end
