package com.example.csen704.fragment;

import com.example.csen704.R;
import com.example.csen704.activity.QuestionActivity;
import com.example.csen704.model.Question;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.TextView;

public class QuestionFragment extends Fragment{

	View rootView;
	Question question;

	public QuestionFragment(Question question) {
		this.question = question;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_question, container,
				false);

		setRedictionListeners();
		render();
		return rootView;
	}

	public void setRedictionListeners() {
		TextView text = (TextView) rootView.findViewById(R.id.question_title);
		text.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), QuestionActivity.class);
				QuestionActivity.question = question;
				startActivity(intent);
			}
		});
	}
	
	public void render() {
		TextView username = (TextView) rootView.findViewById(R.id.question_info);
		TextView body = (TextView) rootView.findViewById(R.id.question_title);
		username.setText(question.getUsername());
		body.setText(question.getBody());
		
	}

}
