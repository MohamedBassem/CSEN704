package com.example.csen704;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class QuestionStreamFragment extends Fragment{

	View rootView;

	public QuestionStreamFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_question_stream, container,
				false);

		loadStream();

		return rootView;
	}

	public void loadStream() {
		FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
		for (int i = 0; i < 10; i++)
			transaction.add(R.id.questions_container, new QuestionFragment());
		transaction.commit();
	}

}
