class QuestionRating < Rating

  belongs_to :question, inverse_of: :ratings

end
