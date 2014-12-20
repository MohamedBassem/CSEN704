package com.example.csen704.fragment;

import com.example.csen704.R;
import com.example.csen704.model.Answer;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AnswerFragment extends Fragment {

	View rootView;
	Answer answer;

	public AnswerFragment(Answer answer) {
		this.answer = answer;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_answer, container,
				false);
		
		render();
		return rootView;
	}
	
	public void render() {
		TextView answerer = (TextView) rootView.findViewById(R.id.question_info);
		TextView answerView = (TextView)  rootView.findViewById(R.id.question_title);
		answerer.setText(answer.getUsername());
		answerView.setText(answer.getBody());
	}
	
}
