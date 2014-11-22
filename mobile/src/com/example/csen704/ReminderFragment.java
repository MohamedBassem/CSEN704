package com.example.csen704;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ReminderFragment extends Fragment{

	View rootView;

	public ReminderFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_reminder, container,
				false);
		setBackgroundColor();
		return rootView;
	}


	public void setBackgroundColor() {
		int backgroundColor = 0;
		int color = getArguments().getInt("color");
		;
		if (color >= 7) {
			backgroundColor = R.color.red;
		} else if (color >= 4) {
			backgroundColor = R.color.orange;
		} else {
			backgroundColor = R.color.green;
		}
		rootView.setBackgroundColor(getResources().getColor(backgroundColor));
		((TextView) rootView.findViewById(R.id.reminder_text)).setText(getArguments().getString("text"));
	}

	public static ReminderFragment createInstance(int color, String text) {
		ReminderFragment fragment = new ReminderFragment();
		Bundle bundle = new Bundle();
		bundle.putInt("color", color);
		bundle.putString("text", text);
		fragment.setArguments(bundle);
		return fragment;
	}


}
