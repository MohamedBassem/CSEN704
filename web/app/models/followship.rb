class Followship < ActiveRecord::Base

  belongs_to :user
  belongs_to :following, :class_name => "User", :foreign_key => "folloing_id"
end
