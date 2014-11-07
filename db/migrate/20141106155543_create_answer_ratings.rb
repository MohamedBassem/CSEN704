class CreateAnswerRatings < ActiveRecord::Migration
  def change
    create_table :answer_ratings do |t|
      t.string :rating
      t.integer :answer_id
      t.integer :creator_id

      t.timestamps
    end
  end
end
