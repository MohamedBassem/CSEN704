class QuestionRating < Rating

  belongs_to :question, :foreign_key => 'question_id', inverse_of: :ratings
  belongs_to :user, :foreign_key => 'creator_id', inverse_of: :ratings

  validate :question, presence: true
  validate :user, presence: true

end
