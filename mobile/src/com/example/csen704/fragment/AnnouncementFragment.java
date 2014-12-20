package com.example.csen704.fragment;

import com.example.csen704.R;
import com.example.csen704.model.Announcement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AnnouncementFragment extends Fragment {

	View rootView;
	Announcement annoucement;
	
	public AnnouncementFragment(Announcement annoucement) {
		this.annoucement = annoucement;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_announcement, container,
				false);
		
		render();
		return rootView;
	}
	
	public void render() {
		TextView annoucementTitle = (TextView) rootView.findViewById(R.id.announcement_title);
		TextView announcementDate = (TextView) rootView.findViewById(R.id.announcement_date);
		
		annoucementTitle.setText(annoucement.getBody());
//		announcementDate.setText(annoucement.getCreatedAt().toString());
	
	}

}
