class CreateCourses < ActiveRecord::Migration
  def change
    create_table :courses do |t|
      t.string :name
      t.string :description
      t.string :course_code
      t.integer :owner_id

      t.timestamps
    end
  end
end
