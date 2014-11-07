class AddIndexToCourseSubscription < ActiveRecord::Migration
  def change
    add_index :course_subscription, [:course_id, :user_id]
  end
end
