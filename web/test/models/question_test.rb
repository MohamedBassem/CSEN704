require 'test_helper'

class QuestionTest < ActiveSupport::TestCase
  test "User can get the rating of a question" do 
  user = User.new name: "test", email: "m@mesho.com", password: "redhat", verified: 1
  user.save
  user.create_course(name: "CSEN102")
  course = Course.find_by(name: "CSEN102")
  question = Question.new id: 1, body:"This is a question", course_id: course.id, creator_id: user.id
  questionRating = QuestionRating.new rating: 1, question_id: question.id, creator_id: user.id
  assert_equal question.rating, 1
  end
end
