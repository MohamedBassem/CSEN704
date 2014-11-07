class Question < ActiveRecord::Base

  belongs_to :user
  belongs_to :course
  has_many :answers
  has_and_belongs_to_many :tags

  validates_presence_of :user
  validates_presence_of :course

  def get_rating()
    @question_rating = QuestionRating.find(:all, :conditions => {:question_id => self.id})
    @question_rating.each do |rating|
      @sum += rating;
    end
    @average = @sum/@question_rating.size 
  end

end
