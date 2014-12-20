package com.example.csen704.activity;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import com.example.csen704.R;
import com.example.csen704.R.id;
import com.example.csen704.R.layout;
import com.example.csen704.R.menu;
import com.example.csen704.base.BasePrivateActivity;
import com.example.csen704.model.User;
import com.example.csen704.util.ApiRouter;
import com.facebook.widget.UserSettingsFragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FriendsActivity extends BasePrivateActivity {

	LinearLayout layout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_friends);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.friends, menu);
		layout = (LinearLayout) findViewById(R.id.friends_list);
		load();
		return true;
	}

	private void load() {
		final Activity self = this;
		ApiRouter.withToken(getCurrentUser().getToken()).getFollowers(getCurrentUser().getId(), new Callback<List<User>>() {
			
			@Override
			public void success(List<User> users, Response arg1) {
				for (User user : users) {
				TextView txt = new TextView(self);
				txt.setText(user.getName());
				layout.addView(txt);
				}
			}
			
			@Override
			public void failure(RetrofitError arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
