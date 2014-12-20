class AddFetchLink < ActiveRecord::Migration
  def change
    add_column :courses, :fetch_link, :string
  end
end
