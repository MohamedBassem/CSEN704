class CreateAnnouncementReports < ActiveRecord::Migration
  def change
    create_table :announcement_reports do |t|
      t.string :announcement_id
      t.string :body

      t.timestamps
    end
  end
end
