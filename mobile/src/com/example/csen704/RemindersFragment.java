package com.example.csen704;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RemindersFragment extends Fragment{

	View rootView;
	int courseId;

	String texts[] = {"Android milesstone two with social login", "Arduino milestone1, geting all the sensors up and running without connecting all of them together w ay kalam f ay betengan"};

	public RemindersFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_reminders, container,
				false);
//		courseId = getArguments().getInt("courseId", -1);
		renderReminders();
		return rootView;
	}

	public void renderReminders() {
		FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
		for (int i = 5; i > 0; i--) {
			transaction.add(R.id.first_column, ReminderFragment.createInstance(i*2, texts[((int)(Math.random()*10)) % 2]));
			transaction.add(R.id.second_column, ReminderFragment.createInstance(i*2, texts[((int)(Math.random()*10)) % 2]));
		}
		transaction.commit();
	}


}
