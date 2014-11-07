class Announcement < ActiveRecord::Base

  belongs_to :user, inverse_of: :announcements, foreign_key: :creator_id
  belongs_to :course, inverse_of: :announcements

  validates :course, :body, :type , presence: true
  validates :type, inclusion: { in: [ "deadline", "general" ] }
  validates :deadline, presence: true, if: :deadline?

  scope :of_course, ->(course) { where course: course }
  scope :of_user, ->(user) { where user: user }

  def deadline?
    type == "deadline"
  end

  def general?
    type == "general"
  end

  def automated?
    user.nil?
  end

  def creator
    user
  end

  def deadline_passed?
    DateTime.now.to_date > deadline
  end


end
