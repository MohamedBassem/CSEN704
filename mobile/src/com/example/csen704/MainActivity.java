package com.example.csen704;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.csen704.tools.CourseWrapper;
import com.example.csen704.tools.SidebarListAdapter;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction().add(R.id.container, new MainFragment()).commit();
		}

		getCourses();
	}

	public void getCourses(){
		CourseWrapper[] courses = new CourseWrapper[6];
		courses[0] = new CourseWrapper("Home", -1);
		for(int i=0;i<5;i++){
			courses[i+1] = new CourseWrapper("Course " + i, i);
		}
		final SidebarListAdapter adapter = new SidebarListAdapter(this, courses);
		ListView listview = (ListView) findViewById(R.id.left_drawer);
	    listview.setAdapter(adapter);

	    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

	      @Override
	      public void onItemClick(AdapterView<?> parent, final View view,
	          int position, long id) {
	    	  Bundle bundle = new Bundle();
	    	  CourseWrapper course = (CourseWrapper) parent.getItemAtPosition(position);
	    	  if(course.id != -1){
		    	  bundle.putInt("courseId", course.id );
		    	  switchFragment(CourseFragment.class, bundle);
	    	  }else{
	    		  switchFragment(MainFragment.class, bundle);
	    	  }
	    	  DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
	    	  mDrawerLayout.closeDrawers();
	      }

	    });
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
		}else if(id == R.id.action_logout){
			SharedPreferences sessionIDPrefs = getSharedPreferences(
					Config.SETTING, 0);
			SharedPreferences.Editor prefsEditor = sessionIDPrefs.edit();
			prefsEditor.remove(Config.SESSION_ID);
			prefsEditor.remove(Config.USER_ID);
			prefsEditor.remove(Config.USERNAME);
			prefsEditor.commit();
			startActivity(new Intent(this, LoginActivity.class));
			finish();
		}
		return super.onOptionsItemSelected(item);
	}

	public <T> void switchFragment(Class<T> fragment, Bundle bundle){
		Fragment f = null;
		if( fragment == CourseFragment.class){
			f = new CourseFragment();
		}else if(fragment == MainFragment.class){
			f = new MainFragment();
		}
		f.setArguments(bundle);
		replaceContentFragment(f);
	}

	public void replaceContentFragment(Fragment fragment){
		getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
	}

}
