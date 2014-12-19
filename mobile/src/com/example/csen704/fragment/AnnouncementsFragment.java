package com.example.csen704.fragment;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import com.example.csen704.R;
import com.example.csen704.base.BasePrivateActivity;
import com.example.csen704.model.Announcement;
import com.example.csen704.util.ApiRouter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AnnouncementsFragment extends Fragment {

	View rootView;
	long courseId;
	List<Announcement> announcements;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_announcements, container,
				false);

		Bundle bundle = getArguments();
		if(bundle != null){
			courseId = bundle.getLong("courseId", -1) ;
		}else{
			courseId = -1;
		}

		announcements = new ArrayList<Announcement>();
		renderAnnouncements();
		load();
		return rootView;
	}

	public void renderAnnouncements() {
		FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
		for (Announcement announcement : announcements) {
			transaction.add(R.id.announcements_container, new AnnouncementFragment(announcement));
		}
		transaction.commit();
	}
	
	public void load() {
		String token = ((BasePrivateActivity) getActivity()).getCurrentUser().getToken();
		ApiRouter.withToken(token).getCourseAnnouncements(courseId, new Callback<List<Announcement>>() {
			
			@Override
			public void success(List<Announcement> list, Response res) {
				announcements = list;
				renderAnnouncements();
				
			}
			
			@Override
			public void failure(RetrofitError error) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
