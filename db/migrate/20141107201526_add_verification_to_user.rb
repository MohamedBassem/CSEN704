class AddVerificationToUser < ActiveRecord::Migration
  def change
    add_column :users, :verified, :integer
    add_column :users, :verification_code, :string
  end
end
