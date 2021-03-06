class Question < ActiveRecord::Base

  belongs_to :creator, :foreign_key => 'creator_id', class_name: 'User'
  belongs_to :course, :foreign_key => 'course_id'
  has_many :answers, inverse_of: :question
  has_many :ratings, class_name: "QuestionRating" ,inverse_of: :question

  validates :creator, presence: true
  validates :course, presence: true

  def rating
    sum = 0
    self.ratings.each do |rating|
      sum += rating;
    end
    if ratings.size !=0 then
      average = sum / ratings.size
    end
  end

  def username
    creator.name
  end

end
