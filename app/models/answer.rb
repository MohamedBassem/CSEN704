class Answer < ActiveRecord::Base
  belongs_to :user
  belongs_to :question
  validates_presence_of :user
  validates_presence_of :question

  def get_rating()
    @answer_rating = AnswerRating.find(:all, :conditions => {:answer_id => self.id})
    @answer_rating.each do |rating|
      @sum += rating;
    end
    @average = @sum/@answer_rating.size 
  end
  
end
