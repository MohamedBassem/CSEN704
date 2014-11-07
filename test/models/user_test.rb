require 'test_helper'

class UserTest < ActiveSupport::TestCase
  test "User should be created and authenticate with valid data" do
    user = User.new(name:"t", email:"a@a.c", password:"redhat", picture:"p")
    assert user.valid?
    user.save
    a = User.authenticate "a@a.c", "redhat"
    assert_equal a.name, "t"
   end

   test "User should be able to create a course" do 

    users(:farghal).owned_courses.create name: "Mesho"

   end

end
