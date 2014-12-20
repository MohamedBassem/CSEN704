package com.example.csen704.fragment;

import java.util.Arrays;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.csen704.R;
import com.example.csen704.activity.Config;
import com.example.csen704.activity.MainActivity;
import com.example.csen704.base.BaseActivity;
import com.example.csen704.model.User;
import com.example.csen704.util.ApiRouter;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;
import com.facebook.widget.LoginButton.UserInfoChangedCallback;

public class FacebookFragment extends Fragment {

	private static final String TAG = "MainFragment";
	private UiLifecycleHelper uiHelper;
	LoginButton authButton;
	String username;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.facebook, container, false);
		authButton = (LoginButton) view.findViewById(R.id.authButton);
		authButton.setFragment(this);
		authButton.setReadPermissions(Arrays.asList("user_likes", "user_status", "user_friends", "user_birthday"));

		return view;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		uiHelper = new UiLifecycleHelper(getActivity(), callback);
		uiHelper.onCreate(savedInstanceState);
	}

	@Override
	public void onResume() {
		super.onResume();
		Session session = Session.getActiveSession();
		if (session != null && (session.isOpened() || session.isClosed())) {
			onSessionStateChange(session, session.getState(), null);
		}

		uiHelper.onResume();
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		uiHelper.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onPause() {
		super.onPause();
		uiHelper.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		uiHelper.onDestroy();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		uiHelper.onSaveInstanceState(outState);
	}

	private void onSessionStateChange(final Session session, SessionState state,
			Exception exception) {
		if (state.isOpened()) {

			authButton
					.setUserInfoChangedCallback(new UserInfoChangedCallback() {
						@Override
						public void onUserInfoFetched(GraphUser user) {
							if (user != null) {
								username = user.getName();
								ApiRouter.withoutToken().login(username, session.getAccessToken(), new Callback<User>() {

									@Override
									public void failure(RetrofitError error) {

									}

									@Override
									public void success(User user, Response res) {
										((BaseActivity) getActivity()).setCurrentUser(user);
										SharedPreferences sessionIDPrefs = getActivity().getSharedPreferences(
												Config.SETTING, 0);

										SharedPreferences.Editor prefsEditor = sessionIDPrefs.edit();
										prefsEditor.putString(Config.SESSION_ID,"7amada");
										prefsEditor.putInt(Config.USER_ID, 1);
										prefsEditor.putString(Config.USERNAME,username);
										prefsEditor.putBoolean(Config.LOGGED_IN_FB,true);
										prefsEditor.commit();

										startActivity(new Intent(getActivity(), MainActivity.class));
										getActivity().finish();
									}
								});


							}
							else
								username = "";
						}
					});

		} else if (state.isClosed()) {
			Log.i(TAG, "Logged out...");
		}
	}

	private Session.StatusCallback callback = new Session.StatusCallback() {
		@Override
		public void call(Session session, SessionState state,
				Exception exception) {
			onSessionStateChange(session, state, exception);
		}
	};

}
