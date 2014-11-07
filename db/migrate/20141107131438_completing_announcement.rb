class CompletingAnnouncement < ActiveRecord::Migration
  def change
    add_index :announcements, :creator_id
    add_index :announcements, :course_id
    change_column_null :announcements, :course_id, false
    change_column_null :announcements, :type, :string, false
    change_column :announcements, :deadline, :date
  end
end
