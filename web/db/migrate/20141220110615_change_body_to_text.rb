class ChangeBodyToText < ActiveRecord::Migration
  def change
    change_column(:announcements, :body, :text)
  end
end
