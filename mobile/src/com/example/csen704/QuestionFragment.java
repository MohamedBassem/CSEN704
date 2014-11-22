package com.example.csen704;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class QuestionFragment extends Fragment{

	View rootView;

	public QuestionFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_question, container,
				false);

		setRedictionListeners();
		return rootView;
	}

	public void setRedictionListeners() {
		TextView text = (TextView) rootView.findViewById(R.id.question_title);
		text.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), QuestionActivity.class);
				startActivity(intent);
			}
		});

	}

}
