require 'test_helper'

class UserTest < ActiveSupport::TestCase

  test "User should be created succssfully with valid data" do
    user = User.new name: "test", email: "m@mesho.com", password: "redhat", verified: 1
    user.save
    assert user.valid?, "User is not valid"
    assert User.find_by(email: "m@mesho.com"), "User was not found in the database"
  end

  test "User should not be listed if not verified" do
    user = User.new name: "test", email: "m@mesho.com", password: "redhat", verified: 0
    user.save
    assert_not User.find_by email: "m@mesho.com"
    user.verify
    assert User.find_by email: "m@mesho.com"
  end

  test "User cannot be created with invalid email" do
    user = User.new(name:"t", email:"a@a", password:"redhat", picture:"p")
    assert_not user.valid?, "User created with invalid email a@a"
  end

  test "User cannot be created with password less than 6 chars" do 
    user = User.new(name:"t", email:"a@a.com", password:"reat", picture:"p")
    assert_not user.valid?, "User created with invalid email reat"
  end

  test "User must have a name" do 
    user = User.new(email:"a@a.com", password:"reat", picture:"p")
    assert_not user.valid?, "User created without a name"
  end

  test "User should generate a random verification code on creation" do
    User.create name: "test", email: "m@mesho.com", password: "redhat", verified: 0
    User.create name: "test", email: "m2@mesho.com", password: "redhat", verified: 0
    code1 = User.unverified.find_by(email: "m@mesho.com").verification_code
    assert code1.length > 0, "Code was not generated"
    code2 = User.unverified.find_by(email: "m2@mesho.com").verification_code
    assert_not_equal code1, code2, "The code generated is not random"
  end

  test "User should be able to authenticate" do
    User.create name: "test", email: "m@mesho.com", password: "redhat", verified: 1
    user = User.authenticate "m@mesho.com", "redhat"
    assert_equal user.name, "test"

  end

  test "User should be able to create course" do
    users(:farghal).create_course(name: "CSEN101")
    course = Course.find_by(name: "CSEN101")
    assert course, "Course was not created"


  end

  test "User should be able to create reminder" do
    user = User.create name: "test", email: "m@mesho.com", password: "redhat", verified: 1
    announcement = Announcement.new announcement_type: "deadline", body: "this is an announcement", deadline:  Date.current.tomorrow, course_id: 1, creator_id: 1
    announcement.save
    user.create_reminder(:announcement)
    reminder = Reminder.find_by(id: 1)
    assert reminder, "Reminder was not created"
  end
end
