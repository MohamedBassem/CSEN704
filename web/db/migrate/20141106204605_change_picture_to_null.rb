class ChangePictureToNull < ActiveRecord::Migration
  def change
    change_column :users, :picture, :string, :null => true
  end
end
