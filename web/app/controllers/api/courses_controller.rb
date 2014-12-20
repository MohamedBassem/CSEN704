class Api::CoursesController < Api::ApplicationController

  before_action :autheticate_user!

  def subscribe
    course = Course.find(params[:id])
    current_user.ask_to_follow course
    render text: ""
  end

  def invite
  end

  def index
    @courses = Course.all
  end

  def create
    @course = current_user.create_course(name: params[:name], course_code: params[:course_code], description: params[:description])
  end

  def show
    @course = Course.find(params[:id])
  end

end
