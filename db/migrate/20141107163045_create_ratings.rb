class CreateRatings < ActiveRecord::Migration
  def change
    create_table :ratings do |t|
      t.integer :creator_id
      t.integer :rating
      t.string :type
      t.integer :question_id
      t.integer :answer_id
      t.integer :announcement_id

      t.timestamps
    end

  end
end
