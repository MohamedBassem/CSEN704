class Course < ActiveRecord::Base


  belongs_to :owner, :foreign_key => 'owner_id', :class_name => 'User'
  has_many :questions, :inverse_of => :course
  has_many :course_subscriptions, :inverse_of => :course
  has_many :users
  has_many :announcements, inverse_of: :course

  validates :name, :presence => true, :length => {in: 1..100}


  def ask_to_subscribe(user)
    @subscritpion = CourseSubscription.new
    @subscritpion.user = user
    @subscritpion.course = self
    @subscritpion.accepted = 0
    @subscritpion.save
  end

  def accept_subscription(user)
    @sub = CourseSubscription.find_by(user: user, course: self)
    @sub.accepted = 1
    @sub.save
  end

end
