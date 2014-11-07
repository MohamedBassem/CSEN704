class Course < ActiveRecord::Base


  belongs_to :owner, :foreign_key => 'owner_id', :class_name => 'User'
  has_many :questions
  has_many :subscribed_users, :foreign_key => 'user_id', :through => :course_subscription, :condition => "accepted = 1"
  has_many :announcements, inverse_of: :course





end
