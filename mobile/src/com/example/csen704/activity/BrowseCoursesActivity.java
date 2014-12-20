package com.example.csen704.activity;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;

import com.example.csen704.R;
import com.example.csen704.base.BaseActivity;
import com.example.csen704.fragment.CourseEntryFragment;
import com.example.csen704.model.Course;
import com.example.csen704.util.ApiRouter;

public class BrowseCoursesActivity extends BaseActivity {

	private boolean loadFlag;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_browse_courses);
		load();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

	public void load() {
		if (loadFlag) {
			return;
		}
		loadFlag = true;
		String token = getCurrentUser().getToken();
		ApiRouter.withToken(token).getAllCourses(new Callback<List<Course>>() {

			@Override
			public void success(List<Course> courseList, Response response) {
				FragmentTransaction transaction = getFragmentManager().beginTransaction();
				for(Course course : courseList){
					CourseEntryFragment fragment = new CourseEntryFragment();
					Bundle args = new Bundle();
					transaction.add(R.id.answers, new CourseEntryFragment());
				}
				loadFlag = false;
			}

			@Override
			public void failure(RetrofitError error) {
				loadFlag = false;
			}

		});
	}

}
