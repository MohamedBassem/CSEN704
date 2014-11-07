class CreateReminders < ActiveRecord::Migration
  def change
    create_table :reminders do |t|
      t.integer :creator_id
      t.integer :annoucment_id

      t.timestamps
    end
  end
end
