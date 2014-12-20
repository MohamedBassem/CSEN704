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
    @question = Course.find(params[:course_id]).questions.create(body: params[:body], creator_id: current_user.id)
  end

  def show
  end

end
