class ChangeFollowerToUserId < ActiveRecord::Migration
  def change
    rename_column :followships, :follower_id, :user_id
  end
end
