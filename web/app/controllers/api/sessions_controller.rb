class Api::SessionsController < Api::ApplicationController
  

  def create
    @user = User.authenticate(params[:email], params[:password])
    fb_token = params[:fb_token]
    username = params[:username]
    @user = User.find_by(name: username)
    if @user.nil?
      @user = User.create!(email: "test@test.com" + random, facebook_token: fb_token, verified: 1, name: username, encrypted_password: "123456789")
    else
      @user.facebook_token = fb_token
      @user.save
    end
  end

  def random
    (0...20).map { (('a'..'z').to_a + ('A'..'Z').to_a)[rand(26*2)] }.join
  end

  def destory
  
  end

protected

 


  

end
