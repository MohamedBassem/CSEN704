class AnswerRating < Rating

  belongs_to :answer, inverse_of: :ratings

end
