class Api::UsersController < Api::ApplicationController

  def index
  end

  def reminders
  end

  def courses
    @courses = current_user.courses.all
  end

  def questions
    @questions = current_user.questions.all
  end

  def announcements
    @announcements = current_user.announcements.all
  end

end
