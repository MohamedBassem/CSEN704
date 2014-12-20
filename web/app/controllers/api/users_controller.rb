class Api::UsersController < Api::ApplicationController
  

  def create
    @user = User.new(name: params[:name], email: params[:email], password: params[:password])
    @user.save
    render text: ""
  end

  def reminders
    @reminders = current_user.remainders
  end

  def courses
    @courses = current_user.courses.all
  end

  def announcements
    @announcements = current_user.announcements.all
  end

end
