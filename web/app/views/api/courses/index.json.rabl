collection @courses.all, :object_root => false
attribute :id, :name, :course_code
node(:subscribed) { |course| @current_user.subscribed_in?(course) }
