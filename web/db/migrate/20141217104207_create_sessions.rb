class CreateSessions < ActiveRecord::Migration
  def change
    create_table :sessions do |t|
      t.string :session
      t.integer :user_id

      t.timestamps
    end
  end
end
