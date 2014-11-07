class CreateAnnouncementRatings < ActiveRecord::Migration
  def change
    create_table :announcement_ratings do |t|
      t.integer :rating
      t.integer :creator_id
      t.integer :announcement_id

      t.timestamps
    end
  end
end
