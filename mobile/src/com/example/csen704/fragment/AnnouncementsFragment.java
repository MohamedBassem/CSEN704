package com.example.csen704.fragment;

import com.example.csen704.R;
import com.example.csen704.activity.CreateAnnouncementActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AnnouncementsFragment extends Fragment {

	View rootView;
	int courseId;

	public AnnouncementsFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_announcements, container,
				false);
		Bundle bundle = getArguments();
		if (bundle != null) {
			courseId = bundle.getInt("courseId", -1);
		} else {
			courseId = -1;
		}
		if (courseId != -1) {
			rootView.findViewById(R.id.create_announcment_button)
					.setVisibility(View.VISIBLE);
			rootView.findViewById(R.id.create_announcment_button)
					.setOnClickListener(new View.OnClickListener() {

						@Override
						public void onClick(View arg0) {
							Intent intent = new Intent(getActivity()
									.getBaseContext(),
									CreateAnnouncementActivity.class);
							intent.putExtra("courseId", courseId);
							startActivity(intent);
						}
					});
		}
		renderAnnouncements();
		return rootView;
	}

	public void renderAnnouncements() {
		FragmentTransaction transaction = getActivity()
				.getSupportFragmentManager().beginTransaction();
		for (int i = 0; i < 10; i++) {
			transaction.add(R.id.announcements_container,
					new AnnouncementFragment());
		}
		transaction.commit();
	}

}
