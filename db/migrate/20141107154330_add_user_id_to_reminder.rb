class AddUserIdToReminder < ActiveRecord::Migration
  def change
     add_column :reminders, :user_id, :int
  end
end
