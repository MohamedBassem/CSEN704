class Tag < ActiveRecord::Base

  validates :body, presence:true
  validates :body, uniqueness:true
  validates :body, length: { maximum: 30 }

  has_and_belongs_to_manny :questions

  scope :of_question, ->(question) { where question: question }

end
