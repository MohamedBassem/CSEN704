package com.example.csen704.fragment;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import com.example.csen704.R;

import com.example.csen704.base.BasePrivateActivity;
import com.example.csen704.model.Course;
import com.example.csen704.util.ApiRouter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CourseInfoFragment extends Fragment {
	TextView courseName;
	TextView courseCode;
	TextView courseDescription;
	Course course;
	long courseId;
	View rootView;
	boolean loadFlag;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_course_info, container,
				false);
		courseName = (TextView) rootView.findViewById(R.id.course_name);
		courseCode = (TextView) rootView.findViewById(R.id.course_code);
		courseDescription = (TextView) rootView.findViewById(R.id.course_description);
		courseId = getArguments().getLong("courseId");
		course = new Course();
		inhabitateViews();
		load();
		return rootView;
	}

	public void inhabitateViews() {
		
		courseName.setText(course.getName());
		courseCode.setText(course.getCourseCode());
		courseDescription.setText(course.getDescription());
	}
	

	public void load() {
		if (loadFlag) {
			return;
		}
		loadFlag = true;
		String token = ((BasePrivateActivity) getActivity()).getCurrentUser().getToken();
		ApiRouter.withToken(token).getCourseInfo(courseId, new Callback<Course>() {
			
			@Override
			public void success(Course cors, Response res) {
				course = cors;
				inhabitateViews();
				loadFlag = false;
			}
			
			@Override
			public void failure(RetrofitError error) {
				loadFlag = false;
			}
		});
	}
}
