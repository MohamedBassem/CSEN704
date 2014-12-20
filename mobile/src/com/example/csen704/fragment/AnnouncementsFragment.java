package com.example.csen704.fragment;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import com.example.csen704.R;
import com.example.csen704.base.BasePrivateActivity;
import com.example.csen704.model.Announcement;
import com.example.csen704.model.User;
import com.example.csen704.util.ApiRouter;
import com.example.csen704.activity.CreateAnnouncementActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.csen704.R;
import com.example.csen704.activity.CreateAnnouncementActivity;
import com.example.csen704.base.BasePrivateActivity;
import com.example.csen704.model.Announcement;
import com.example.csen704.util.ApiRouter;

public class AnnouncementsFragment extends Fragment {

	View rootView;
	long courseId;
	List<Announcement> announcements;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_announcements, container,
				false);
		Log.e("AMBALEH", "gowa el annoucenments");
		
		Bundle bundle = getArguments();
		if (bundle != null) {
			courseId = bundle.getLong("courseId", -1);
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
		announcements = new ArrayList<Announcement>();
		renderAnnouncements();
		if (courseId == -1) {
			loadUserAnnoucements();
		} else {
			load();			
		}
		return rootView;
	}

	private void loadUserAnnoucements() {
		User user = ((BasePrivateActivity) getActivity()).getCurrentUser();
		ApiRouter.withToken(user.getToken()).getUserAnnoucenemnts(user.getId(), new Callback<List<Announcement>>() {

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
