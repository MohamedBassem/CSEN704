class User < ActiveRecord::Base
  has_many :announcements, inverse_of: :user
  has_many :course_invitations, class_name: "CourseInvitation"
  has_many :questions, dependent: :destroy
  has_many :answers, dependent: :destroy
end
