class Api::AnnouncementsController < Api::ApplicationController

  def rating
  end

  def report
  end

  def reminder
  end

  def index
    @announcements = Course.find(params[:course_id]).announcements.all
  end

  def create
  end

  def show
  end

end
