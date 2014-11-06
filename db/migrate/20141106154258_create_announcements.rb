class CreateAnnouncements < ActiveRecord::Migration
  def change
    create_table :announcements do |t|
      t.string :type
      t.string :body
      t.string :deadline
      t.integer :course_id
      t.integer :creator_id

      t.timestamps
    end
  end
end
