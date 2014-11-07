class CreateMaterials < ActiveRecord::Migration
  def change
    create_table :materials do |t|
      t.string :course_id
      t.string :user_id
      t.string :path

      t.timestamps
    end
  end
end
