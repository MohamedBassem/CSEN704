package com.example.csen704;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AnnouncementsFragment extends Fragment {

	View rootView;
	
	public AnnouncementsFragment() {
	
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_announcements, container,
				false);
		renderAnnouncements();
		return rootView;
	}
	
	public void renderAnnouncements() {
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		for (int i = 0; i < 10; i++) {
			transaction.add(R.id.announcements_container, new AnnouncementFragment());
		}
		transaction.commit();
	}
	
}
