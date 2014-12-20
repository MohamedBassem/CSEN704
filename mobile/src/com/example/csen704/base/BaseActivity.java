package com.example.csen704.base;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import com.example.csen704.R;
import com.example.csen704.activity.BrowseCoursesActivity;
import com.example.csen704.activity.FriendsActivity;
import com.example.csen704.activity.LoginActivity;
import com.example.csen704.activity.SettingsActivity;
import com.example.csen704.activity.UesrsActivity;
import com.example.csen704.model.User;

public abstract class BaseActivity extends FragmentActivity {
	private static final String PREF_USER_ID = "PREF_USER_ID";
	private static final String PREF_USER_NAME = "PREF_USER_NAME";
	private static final String PREF_USER_EMAIL = "PREF_USER_EMAIL";
	private static final String PREF_USER_TOKEN = "PREF_USER_TOKEN";

	private User currentUser;
	private int inProgress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
	}

	@Override
	protected void onResume() {
		super.onResume();

		invalidateOptionsMenu();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_browse_courses) {
			startActivity(new Intent(this, BrowseCoursesActivity.class));
		}else if (id == R.id.action_followers) {
			startActivity(new Intent(this, FriendsActivity.class));
		}else if (id == R.id.action_all_users) {
			startActivity(new Intent(this, UesrsActivity.class));
		}else if (id == R.id.action_settings) {
			startActivity(new Intent(this, SettingsActivity.class));
		}else if(id == R.id.action_logout){
			setCurrentUser(null);
			startActivity(new Intent(this, LoginActivity.class));
			finish();
		}
		return super.onOptionsItemSelected(item);
	}

	protected boolean isRefreshable() {
		return true;
	}

	protected void refreshViews() {
	}

	protected void startProgress() {
		setProgressBarIndeterminateVisibility(true);
		inProgress++;
	}

	protected void stopProgress() {
		if (--inProgress == 0) {
			setProgressBarIndeterminateVisibility(false);
		}
	}

	protected void displayError(Exception e) {
		setProgressBarIndeterminateVisibility(false);
		Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT)
				.show();
	}

	protected boolean isLoggedIn() {
		return getCurrentUser() != null;
	}

	public User getCurrentUser() {
		if (currentUser == null) {
			SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

			if (sharedPreferences.contains(PREF_USER_TOKEN)) {
				currentUser = new User();
				currentUser.setId(sharedPreferences.getLong(PREF_USER_ID, 0));
				currentUser.setName(sharedPreferences.getString(PREF_USER_NAME, null));
				currentUser.setEmail(sharedPreferences.getString(PREF_USER_EMAIL, null));
				currentUser.setToken(sharedPreferences.getString(PREF_USER_TOKEN, null));
			}
		}

		return currentUser;
	}

	protected void setCurrentUser(User user) {
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		Editor p = sharedPreferences.edit();

		if ((currentUser = user) != null) {
			p.putLong(PREF_USER_ID, currentUser.getId());
			p.putString(PREF_USER_NAME, currentUser.getName());
			p.putString(PREF_USER_EMAIL, currentUser.getEmail());
			p.putString(PREF_USER_TOKEN, currentUser.getToken());
		}
		else {
			p.clear();
		}

		p.commit();
	}
}
