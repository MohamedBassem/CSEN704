class Course < ActiveRecord::Base

  has_many :announcements, inverse_of: :course
  has_many :questions

end
