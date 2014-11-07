class Course < ActiveRecord::Base

  belongs_to :owner, :foreign_key => 'owner_id', :class_name => 'User'
  has_many :questions
  has_many :subscribers, :through => :course_subscription, :condition => "accepted = 1"
  has_many :announcements
  has_many :reminders, :through => :announcements





end
