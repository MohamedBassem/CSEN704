class Api::SessionsController < Api::ApplicationController
  

  def create
    @user = User.authenticate(params[:email], params[:password])
    if @user == nil
      render text: "", status: :unauthorized
    end 
  end

  def destory
  
  end

protected

 


  

end
