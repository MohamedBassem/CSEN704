class AddDeadlineToReminder < ActiveRecord::Migration
  def change
    add_column :reminders, :deadline, :date
  end
end
