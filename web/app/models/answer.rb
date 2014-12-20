class Answer < ActiveRecord::Base
  belongs_to :user, :foreign_key => 'user_id'
  belongs_to :question, :foreign_key => 'question_id'
  has_many :ratings, class_name: "AnswerRating" ,inverse_of: :answer
  
  validates :user, presence: true
  validates :question, presence: true

  def rating
    self.ratings.each do |rating|
      sum += rating;
    end
    average = sum/ratings.size
  end

  def username
    user.name
  end

end
