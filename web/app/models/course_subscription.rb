class CourseSubscription < ActiveRecord::Base

  belongs_to :user
  belongs_to :course

  validate :user, :course, :presence => true
  before_save :default_values


  def default_values
    self.accepted ||= 1
  end

  def accept
    self.update accepted: 1
  end

end
