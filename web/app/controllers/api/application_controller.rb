class Api::ApplicationController < ActionController::Base
  # Prevent CSRF attacks by raising an exception.
  # For APIs, you may want to use :null_session instead.
  protect_from_forgery with: :exception
  skip_before_filter  :verify_authenticity_token
  respond_to :json

  def current_user
    @current_user ||= User.find_by(token: request.headers[:authorization])
  end

  def autheticate_user!
    if current_user ==  nil
      render status: :unauthorized
    end 
  end

  def test
    render :text => DateTime.now.to_date
  end
end
