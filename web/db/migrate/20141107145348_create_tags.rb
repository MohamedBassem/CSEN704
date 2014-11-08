class CreateTags < ActiveRecord::Migration
  def change
    create_table :tags do |t|
      t.string :body, limit: 30
    end

    create_table :questions_tags, id: false do |t|
      t.integer :question_id
      t.integer :tag_id
    end

  end
end
