package com.example.csen704.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.csen704.R;

public class CourseEntryFragment extends Fragment {

	View rootView;

	public CourseEntryFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_course_entry, container,
				false);
		return rootView;
	}



}
