class Api::CoursesController < Api::ApplicationController

  def subscribe
  
  end

  def unsubscribe
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
