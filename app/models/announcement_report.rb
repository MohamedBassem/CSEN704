class AnnouncementReport < ActiveRecord::Base
  belongs_to :announcement, :foreign_key => 'announcement_id'

  validate :announcement, presence: true
  validate :reason, presence: true, :length => {in: 1..300}

  def reason 
    self.reason
  end

  def announcement
    announcement
  end
end
