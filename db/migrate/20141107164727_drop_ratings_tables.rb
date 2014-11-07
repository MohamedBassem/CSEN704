class DropRatingsTables < ActiveRecord::Migration
  def change
    drop_table :question_ratings
    drop_table :answer_ratings
    drop_table :announcement_ratings
  end
end
