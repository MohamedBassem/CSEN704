class CreateCourseInvitations < ActiveRecord::Migration
  def change
    create_table :course_invitations do |t|
      t.integer :inviter_id
      t.integer :course_id
      t.integer :invited_id

      t.timestamps
    end
  end
end
