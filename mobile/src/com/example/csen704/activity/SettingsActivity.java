package com.example.csen704.activity;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.csen704.R;
import com.example.csen704.base.BaseActivity;
import com.example.csen704.model.Settings;
import com.example.csen704.util.ApiRouter;

public class SettingsActivity extends BaseActivity {

	CheckBox checkbox;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		CheckBox checkbox;

		public PlaceholderFragment() {
		}

		private void load() {
			String token = ((BaseActivity) getActivity()).getCurrentUser().getToken();
			ApiRouter.withToken(token).getNotificationFlag(((BaseActivity) getActivity()).getCurrentUser().getId(), new Callback<Settings>() {
				@Override
				public void failure(RetrofitError error) {
				}

				@Override
				public void success(Settings settings, Response arg1) {
					checkbox.setChecked(settings.getNotificationEnabled() == 1);
				}
			});
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_settings,
					container, false);
			checkbox = (CheckBox) rootView.findViewById(R.id.notification_enabled);
			checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					String token = ((BaseActivity) getActivity()).getCurrentUser().getToken();
					ApiRouter.withToken(token).setNotificationFlag(((BaseActivity) getActivity()).getCurrentUser().getId(), isChecked, new Callback<Response>() {
						@Override
						public void failure(RetrofitError error) {
						}

						@Override
						public void success(Response arg0, Response arg1) {
							Toast.makeText(getActivity().getApplicationContext(), "Settings updated!", Toast.LENGTH_SHORT).show();
						}
					});
				}
			});

			load();
			return rootView;
		}
	}

}
