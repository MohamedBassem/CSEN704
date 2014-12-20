class Api::QuestionsController < Api::ApplicationController

  def rating
    @question = Question.find(params[:id])
    QuestionRating.create!(rating: params[:rating], question: @question, user: current_user)
    render text: ""
  end

  def tag
  end

  def index
    @questions = Course.find(params[:course_id]).questions.all
  end

  def create
    @id = -1
    if params[:email] != nil
      @user = User.find_by(email: params[:email])
      if @user != nil 
        @id = @user.id
      end 
    end
    @question = Course.find(params[:course_id]).questions.create(body: params[:body], creator_id: current_user.id, tagged_id: @id)
  end

  def show
  end

end
