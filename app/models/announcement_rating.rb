class AnnouncementRating < Rating

  belongs_to :announcement, inverse_of: :ratings

end
