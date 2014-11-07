class Material < ActiveRecord::Base
  belongs_to :uploader, :foreign_key => 'uploader_id', class_name: 'User'
  belongs_to :course, :foreign_key => 'course_id'

  validate :uploader, presence: true
  validate :course, presence: true
  validate :storage_path, presence: true

  def storage_path
    self.storage_path
  end

  def uploader
    uploader
  end

  def course
    course
  end
  
end
