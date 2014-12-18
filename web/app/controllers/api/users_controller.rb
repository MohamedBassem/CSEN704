class Api::UsersController < Api::ApplicationController

  def index
  end

  def reminders
  end

  def courses
    @courses = current_user.subscribing_courses.all
  end

end
