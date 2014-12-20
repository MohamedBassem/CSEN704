class AddTagToQuestion < ActiveRecord::Migration
  def change
     add_column :questions, :tagged_id, :integer, default: 0
  end
end
