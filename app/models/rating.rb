class Rating < ActiveRecord::Base

  belongs_to :user, foreign_key: :creator_id
  validates :rating, :inclusion => 1..5
  validates :type, presence: true
  validates :announcement, presence: true, if: :announcement_rating?
  validates :question, presence: true, if: :question_rating?
  validates :answer, presence: true, if: :answer_rating?

  def question_rating?
    self.type == "QuestionRating"
  end

  def answer_rating?
    self.type == "AnswerRating"
  end

  def announcement_rating?
    self.type == "AnnouncementRating"
  end

end
