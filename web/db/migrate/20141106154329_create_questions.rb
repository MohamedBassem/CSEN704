class CreateQuestions < ActiveRecord::Migration
  def change
    create_table :questions do |t|
      t.string :body
      t.string :course_id
      t.string :creator_id

      t.timestamps
    end
  end
end
