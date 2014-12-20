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
    @announcement = Course.find(params[:course_id]).announcements.create(announcement_type: "general", body: params[:announcement_body], creator_id: current_user.id)
  end

  def show
  end

end
