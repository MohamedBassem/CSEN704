class AnswerRating < Rating

  belongs_to :answer, :foreign_key => 'answer_id', inverse_of: :ratings
  belongs_to :user, :foreign_key => 'rater_id', inverse_of: :ratings

  validate :answer, presence: true
  validate :user, presence: true

  def user
    user
  end

  def answer
    answer
  end
end
