class Api::SessionsController < Api::ApplicationController
  

  before_action :autheticate_user!, only: [ :destroy ]

  def create
    @user = User.authenticate(params[:email], params[:password])
    if @user == nil
      render text: "", status: :unauthorized
    end 
  end

  def destory
    current_user.token = ""
    current_user.save
    render text: ""
  end

protected

 


  

end
