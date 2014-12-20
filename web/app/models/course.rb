class Course < ActiveRecord::Base


  belongs_to :owner, :foreign_key => 'owner_id', :class_name => 'User'
  has_many :questions, :inverse_of => :course
  has_many :course_subscriptions, :inverse_of => :course
  has_many :subscribed_users, :foreign_key => 'user_id', :through => :course_subscription
  has_many :announcements, inverse_of: :course
  has_many :materials, inverse_of: :course
  validates :name, :presence => true, :length => {in: 1..100}

  def ask_to_subscribe(user)
    subscritpion = CourseSubscription.new
    subscritpion.user = user
    subscritpion.course = self
    subscritpion.accepted = 0
    self.course_subscriptions << @subscritpion
    subscritpion.save
  end

  def add_material(user)
    self.materials.create(user: user)
  end

  def add_question(dict)
    self.questions.create!(dict)
  end

  def accept_subscription(user)
    subscription = CourseSubscription.find_by(user: user, course: self)
    subscription.accept if subscritpion
  end

end
