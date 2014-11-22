package com.example.csen704;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.TextView;

public class CourseInfo extends Fragment {
	TextView courseName;
	TextView courseCode;
	TextView courseDescription;
	View rootView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_course_info, container,
				false);
		courseName = (TextView) rootView.findViewById(R.id.course_name);
		courseCode = (TextView) rootView.findViewById(R.id.course_code);
		courseDescription = (TextView) rootView.findViewById(R.id.course_description);
		
		inhabitateViews();
		return rootView;
	}
	
	public void inhabitateViews() {
		String name = "Advanced Computer Lab";
		String code = "CSEN 704";
		String description = "The main purpose of the course is to introduce the students " +
				"to the tools and technologies that are commonly used in multimedia authoring." +
				" Along with hands on practice of: developing rich internet applications and media streaming.";
		courseName.setText(name);
		courseCode.setText(code);
		courseDescription.setText(description);
	}
}
