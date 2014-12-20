class Api::UsersController < Api::ApplicationController
  
  def index
    @users = User.all
  end

  def show
    @user = User.find(params[:user_id])
  end

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

  def questions
    @questions = current_user.questions.all
  end

  def announcements
    @announcements = current_user.announcements.all
  end

  def follow
    Followship.create(follower_id: current_user.id, folloing_id: params[:following_id])
    render text: ""
  end

  def followings
    @users = current_user.users.all
  end

end
