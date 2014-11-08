class CompletingCourseInvitation < ActiveRecord::Migration
  def change
    add_column :course_invitations, :invitation_hash , :string, null:false
    add_column :course_invitations, :expired, :boolean, default: false
  end
end
