class Question < ActiveRecord::Base

  belongs_to :creator, :foreign_key => 'creator_id', class_name: 'User'
  belongs_to :course, :foreign_key => 'course_id'
  has_many :answers
  has_and_belongs_to_many :tags
  has_many :ratings, class_name: "QuestionRating" ,inverse_of: :question

  validates :creator, presence: true
  validates :course, presence: true

  def rating
    self.ratings.each do |rating|
      sum += rating;
    end
    average = sum/ratings.size
  end

end
