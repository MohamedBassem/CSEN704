class AddNotificationFlag < ActiveRecord::Migration
  def change
     add_column :users, :notification_enabled, :tinyint
  end
end
