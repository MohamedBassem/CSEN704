package com.example.csen704.fragment;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.csen704.R;
import com.example.csen704.base.BaseActivity;
import com.example.csen704.util.ApiRouter;

public class CourseEntryFragment extends Fragment implements View.OnClickListener {

	View rootView;
	Button subscribeButton;
	long courseId;

	public CourseEntryFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_course_entry, container,
				false);
		Bundle args = getArguments();
		((TextView)rootView.findViewById(R.id.course_name)).setText(args.getString("course_name"));
		subscribeButton = ((Button)rootView.findViewById(R.id.subscribe_course));
		subscribeButton.setOnClickListener(this);
		boolean subscribed = args.getBoolean("subscribed");
		courseId = args.getLong("course_id");
		if(subscribed){
			subscribeButton.setEnabled(false);;
		}
		return rootView;
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.subscribe_course){
			String token = ((BaseActivity) getActivity()).getCurrentUser().getToken();
			ApiRouter.withToken(token).subscribeCourse(courseId, new Callback<Response>() {

				@Override
				public void success(Response response, Response _response) {
					subscribeButton.setEnabled(false);
				}

				@Override
				public void failure(RetrofitError error) {
				}

			});
		}

	}



}
