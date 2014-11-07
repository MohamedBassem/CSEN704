class CourseInvitation < ActiveRecord::Base

  belongs_to :inviter, class_name: "User"
  belongs_to :invited, class_name: "User", inverse_of: :course_invitations
  belongs_to :course

  validates_presence_of :inviter
  validates_presence_of :invited
  validates_presence_of :course

  before_save :set_defaults

  default_scope { where expired: false }


  protected
  def set_defaults
    random_char_pool = ('a'..'z').to_a + ('A'..'Z').to_a + ('0'..'9').to_a
    self.invitation_hash = (0...25).map { random_char_pool.sample }.join
    self.expired = false if expired.nil?
  end

end
