package com.example.csen704;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

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
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		for (int i = 0; i < 10; i++)
			transaction.add(R.id.questions_container, new QuestionFragment());
		transaction.commit();
	}
	
}