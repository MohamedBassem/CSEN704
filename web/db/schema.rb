# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20141220104329) do

  create_table "announcement_reports", force: true do |t|
    t.string   "announcement_id"
    t.string   "body"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "announcements", force: true do |t|
    t.string   "announcement_type"
    t.string   "body"
    t.date     "deadline"
    t.integer  "course_id",         null: false
    t.integer  "creator_id"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  add_index "announcements", ["course_id"], name: "index_announcements_on_course_id", using: :btree
  add_index "announcements", ["creator_id"], name: "index_announcements_on_creator_id", using: :btree

  create_table "answers", force: true do |t|
    t.string   "body"
    t.integer  "question_id"
    t.integer  "user_id"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "course_invitations", force: true do |t|
    t.integer  "inviter_id"
    t.integer  "course_id"
    t.integer  "invited_id"
    t.datetime "created_at"
    t.datetime "updated_at"
    t.string   "invitation_hash",                 null: false
    t.boolean  "expired",         default: false
  end

  create_table "course_subscriptions", force: true do |t|
    t.integer  "user_id"
    t.integer  "course_id"
    t.integer  "accepted"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  add_index "course_subscriptions", ["course_id", "user_id"], name: "index_course_subscriptions_on_course_id_and_user_id", using: :btree

  create_table "courses", force: true do |t|
    t.string   "name"
    t.string   "description"
    t.string   "course_code"
    t.integer  "owner_id"
    t.datetime "created_at"
    t.datetime "updated_at"
    t.string   "fetch_link"
  end

  create_table "materials", force: true do |t|
    t.string   "course_id"
    t.string   "user_id"
    t.string   "path"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "questions", force: true do |t|
    t.string   "body"
    t.string   "course_id"
    t.string   "creator_id"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "questions_tags", id: false, force: true do |t|
    t.integer "question_id"
    t.integer "tag_id"
  end

  create_table "ratings", force: true do |t|
    t.integer  "creator_id"
    t.integer  "rating"
    t.string   "type"
    t.integer  "question_id"
    t.integer  "answer_id"
    t.integer  "announcement_id"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "reminders", force: true do |t|
    t.integer  "creator_id"
    t.integer  "annoucment_id"
    t.datetime "created_at"
    t.datetime "updated_at"
    t.integer  "user_id"
    t.date     "deadline"
  end

  create_table "sessions", force: true do |t|
    t.string   "session"
    t.integer  "user_id"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "tags", force: true do |t|
    t.string "body", limit: 30
  end

  create_table "users", force: true do |t|
    t.string   "name",                               null: false
    t.string   "encrypted_password"
    t.string   "email",                              null: false
    t.string   "picture"
    t.datetime "created_at"
    t.datetime "updated_at"
    t.boolean  "verified",           default: false
    t.string   "verification_code"
    t.string   "facebook_token"
    t.string   "token"
  end

  add_index "users", ["email"], name: "index_users_on_email", unique: true, using: :btree

end
