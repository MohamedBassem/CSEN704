class Announcement < ActiveRecord::Base

  belongs_to :user, inverse_of: :announcements, foreign_key: :creator_id
  belongs_to :course, inverse_of: :announcements
  has_many :ratings, class_name: "AnnouncementRating" ,inverse_of: :announcement
  has_many :reports, class_name: "AnnouncementReport" ,inverse_of: :announcement
  validates :course, :body, :announcement_type , presence: true
  validates :announcement_type, inclusion: { in: [ "deadline", "general" ] }
  validates :deadline, presence: true, if: :deadline?

  scope :of_course, ->(course) { where course: course }
  scope :of_user, ->(user) { where user: user }

  def deadline?
    announcement_type == "deadline"
  end

  def general?
    announcement_type == "general"
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

  def add_report(dict)
    self.reports.create(dict)
  end

end
