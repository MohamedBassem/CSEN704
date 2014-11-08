class AddIndexToCourseSubscription < ActiveRecord::Migration
  def change
    add_index :course_subscriptions, [:course_id, :user_id]
  end
end
