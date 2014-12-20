package com.example.csen704.activity;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;

import com.example.csen704.R;
import com.example.csen704.R.id;
import com.example.csen704.R.layout;
import com.example.csen704.R.menu;
import com.example.csen704.base.BaseActivity;
import com.example.csen704.model.Course;
import com.example.csen704.model.User;
import com.example.csen704.util.ApiRouter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProfileActivity extends BaseActivity {
	TextView name;
	Button follow;
	ArrayList<String> courses;
	LinearLayout subscribedCourses;
	public static User user;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		name = (TextView) findViewById(R.id.user_name);
		follow = (Button) findViewById(R.id.follow_button);
		subscribedCourses = (LinearLayout) findViewById(R.id.subscribed_courses);
		follow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		name.setText(user.getName());
		inhabitateCourses();
	}

	private void inhabitateCourses() {
		courses = new ArrayList<String>();
		final BaseActivity self = this;
		ApiRouter.withToken(user.getToken()).getCourses(
				user.getId(), new Callback<List<Course>>() {
					@Override
					public void failure(RetrofitError error) {
						// TODO Auto-generated method stub

					}

					@Override
					public void success(List<Course> list,
							retrofit.client.Response response) {
						 if (list.size() != 0)
						 findViewById(R.id.courses_list_header).setVisibility(
						 View.VISIBLE);
						
						for (int i = 0; i < list.size(); i++) {
							courses.add(list.get(i).getCourseCode() + " - " + list.get(i).getName());
							for (String course : courses) {
								 TextView courseView = new TextView(self);
								 courseView.setText(course);
								 courseView.setPadding(
								 (int) getResources().getDimension(R.dimen.padding_medium),
								 0, 0,
								 0);
								 subscribedCourses.addView(courseView);
							}
						}
					}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile, menu);
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
}
