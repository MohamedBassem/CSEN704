class User < ActiveRecord::Base

  has_many :announcements, inverse_of: :user
  has_many :course_invitations, class_name: "CourseInvitation"
end
