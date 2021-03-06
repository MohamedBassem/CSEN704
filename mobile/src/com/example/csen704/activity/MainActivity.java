package com.example.csen704.activity;

import java.io.IOException;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.csen704.R;
import com.example.csen704.base.BaseActivity;
import com.example.csen704.base.BasePrivateActivity;
import com.example.csen704.fragment.CourseFragment;
import com.example.csen704.fragment.MainFragment;
import com.example.csen704.fragment.ProfileFragment;
import com.example.csen704.model.Course;
import com.example.csen704.tools.CourseWrapper;
import com.example.csen704.tools.SidebarListAdapter;
import com.example.csen704.util.ApiRouter;


public class MainActivity extends BasePrivateActivity {

	private final int HOME_ID = -1;
	private final int CREATE_COURSE_ID = -2;
	private final int PROFILE_ID = -3;

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
		final Activity self = this;
		if (getCurrentUser() == null)
			return;
		ApiRouter.withToken(getCurrentUser().getToken()).getCourses(getCurrentUser().getId(), new Callback<List<Course>>() {

			@Override
			public void failure(RetrofitError error) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void success(List<Course> list, Response res) {
			
				CourseWrapper[] courses = new CourseWrapper[list.size() + 3];
				courses[0] = new CourseWrapper(getSharedPreferences(Config.SETTING, 0).getString(Config.USERNAME, "UNKNOWN"), PROFILE_ID);
				courses[1] = new CourseWrapper("Home", HOME_ID);
				courses[2] = new CourseWrapper("Create Course", CREATE_COURSE_ID);
				for (int i = 0; i < list.size(); i++) {
					courses[i + 3] = new CourseWrapper(list.get(i));
				}
				final SidebarListAdapter adapter = new SidebarListAdapter(self, courses);
				ListView listview = (ListView) findViewById(R.id.left_drawer);
			    listview.setAdapter(adapter);

			    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			      @Override
			      public void onItemClick(AdapterView<?> parent, final View view,
			          int position, long id) {
			    	  Bundle bundle = new Bundle();
			    	  CourseWrapper course = (CourseWrapper) parent.getItemAtPosition(position);
			    	  if(course.id == HOME_ID){
			    		  switchFragment(MainFragment.class, bundle);
			    	  }else if(course.id == CREATE_COURSE_ID){
				    	  startActivity(new Intent(getApplicationContext(),CreateCourseActivity.class));
			    	  }else if(course.id == PROFILE_ID){
			    		  switchFragment(ProfileFragment.class, bundle);
			    	  }else{
			    		  bundle.putLong("courseId", course.id );
				    	  switchFragment(CourseFragment.class, bundle);
			    	  }
			    	  DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
			    	  mDrawerLayout.closeDrawers();
			      }

			    });
				
			}
		});
		
	}

	public <T> void switchFragment(Class<T> fragment, Bundle bundle){
		Fragment f = null;
		if( fragment == CourseFragment.class){
			f = new CourseFragment();
		}else if(fragment == MainFragment.class){
			f = new MainFragment();
		}else if(fragment == ProfileFragment.class){
			f = new ProfileFragment();
		}
		f.setArguments(bundle);
		replaceContentFragment(f);
	}

	public void replaceContentFragment(Fragment fragment){
		getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
	}

}
