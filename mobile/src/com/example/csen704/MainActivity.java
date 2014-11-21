package com.example.csen704;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {

			getFragmentManager().beginTransaction().add(R.id.container, new AnnouncementsFragment()).commit();

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public <T> void switchFragment(Class<T> fragmet, Bundle bundle){
//		if( fragmet == MainFragment.class){
//
//		}
	}

	public void replaceContentFragment(Fragment fragment){
		getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
	}

}
