package com.example.csen704;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RemindersFragment extends Fragment{

	View rootView;
	
	String texts[] = {"Android milesstone two with social login", "Arduino milestone1, geting all the sensors up and running without connecting all of them together w ay kalam f ay betengan"};
	
	public RemindersFragment() {
	
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_reminders, container,
				false);
		
		renderReminders();
		return rootView;
	}
	
	public void renderReminders() {
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		for (int i = 5; i > 0; i--) {
			transaction.add(R.id.first_column, ReminderFragment.createInstance(i*2, texts[((int)(Math.random()*10)) % 2]));
			transaction.add(R.id.second_column, ReminderFragment.createInstance(i*2, texts[((int)(Math.random()*10)) % 2]));
		}
		transaction.commit();
	}
	
	
}
