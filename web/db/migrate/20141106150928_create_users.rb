class CreateUsers < ActiveRecord::Migration
  def change
    create_table :users do |t|
      t.string :name, null: false
      t.string :password
      t.string :email, null: false
      t.string :picture, null: false

      t.timestamps
    end

    add_index :users, :email, unique: true
  end
end
