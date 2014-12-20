Rails.application.routes.draw do

  namespace :api, defaults: { format: :json } do

    resources :sessions, only: ["create", "destroy"]


    resources :courses, only: ["create", "show", "index"] do
      member do
        post 'subscribe'
        post 'invite'
      end
      resources :announcements, only: ["create", "show", "index"] do
        member do
          post 'rating'
          post 'report'
          post 'reminder'
        end
      end
      resources :questions, only: ["create", "show", "index"] do
        member do
          post 'rating'
          post 'tag'
        end
        resources :answers, only: ["create", "show", "index"] do
          post 'rating'
        end
      end
      resources :materials, only: ["create", "show", "index"]
      resources :users, only: ["index"]
    end

    resources :users, only: ["create", "index", "show"] do
      member do
        get 'reminders'
        get 'courses'
        get 'announcements'
        get 'questions'
        get 'followings'
        post 'follow'
        post 'notification_flag'
        get 'notification_flag'
        get 'tagged_questions'
      end
    end
  end

  get '/test' => 'application#test'

end
