class CourseSubscription < ActiveRecord::Base

  belongs_to :user
  belongs_to :course

  validate :user, :course, :presence => true

  def accept
    self.update accepted: 1
  end

end
