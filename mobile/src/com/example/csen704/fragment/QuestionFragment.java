package com.example.csen704.fragment;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.csen704.R;
import com.example.csen704.activity.QuestionActivity;
import com.example.csen704.base.BaseActivity;
import com.example.csen704.model.Question;
import com.example.csen704.util.ApiRouter;


@SuppressLint("ValidFragment")
public class QuestionFragment extends Fragment{

	View rootView;
	Question question;


	public QuestionFragment(){}

	public QuestionFragment(Question question) {
		this.question = question;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_question, container,
				false);

		setRedictionListeners();
		render();
		return rootView;
	}

	public void setRedictionListeners() {
		TextView text = (TextView) rootView.findViewById(R.id.question_title);
		text.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), QuestionActivity.class);
				QuestionActivity.question = question;
				startActivity(intent);
			}
		});

		rootView.findViewById(R.id.upvote).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
					String token = ((BaseActivity) getActivity()).getCurrentUser().getToken();
					ApiRouter.withToken(token).rateQuestion(question.getCourseId(), question.getId(), 1, new Callback<Response>() {

					@Override
					public void success(Response response, Response _response) {
						Toast.makeText(getActivity().getApplicationContext(), "Upvoted", Toast.LENGTH_SHORT).show();
					}

					@Override
					public void failure(RetrofitError error) {
					}
				});
			}
		});
	}

	public void render() {
		TextView username = (TextView) rootView.findViewById(R.id.question_info);
		TextView body = (TextView) rootView.findViewById(R.id.question_title);
		username.setText(question.getUsername());
		body.setText(question.getBody());

	}

}
