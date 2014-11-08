class AnnouncementRating < Rating

  belongs_to :announcement, :foreign_key => 'announcement_id', inverse_of: :ratings
  belongs_to :user, :foreign_key => 'creator_id', inverse_of: :ratings

  validate :announcement, presence: true
  validate :user, presence: true

  def announcement
    announcement
  end

  def user
    user
  end
end
