class Api::AnswersController < Api::ApplicationController

  def rating
  end

  def index
    @answers = Question.find(params[:question_id]).answers.all
  end

  def create
    @answer = Question.find(params[:question_id]).answers.create(body: params[:body], user_id: params[:user_id])

  end

  def show
 
  end

end
