class Reminder < ActiveRecord::Base
  belongs_to :user, :foreign_key => 'user_id'
  belongs_to :announcemet, :foreign_key => 'announcemet_id'

  validate :user, presence: true
  validate :announcemet, presence: true
  validate :body, presence: true, :length => {in: 1..300}

  def user
    user
  end

  def announcement
    announcement
  end

  def body
    self.body
  end

end
