
package com.example.csen704.fragment;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.csen704.R;
import com.example.csen704.base.BasePrivateActivity;
import com.example.csen704.model.Question;
import com.example.csen704.model.User;
import com.example.csen704.util.ApiRouter;

public class QuestionStreamFragment extends Fragment {

	View rootView;
	long courseId;
	boolean loadFlag;
	List<Question> questions;
	FragmentTransaction transaction;

	public QuestionStreamFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_question_stream, container,
				false);
		Bundle bundle = getArguments();
		if(bundle != null){
			courseId = bundle.getLong("courseId", -1) ;
		}else{
			courseId = -1;
		}

		if(courseId == -1){
			rootView.findViewById(R.id.add_question_box).setVisibility(View.GONE);
		}

		Button askButton = (Button) rootView.findViewById(R.id.add_question_button);
		final EditText question = (EditText) rootView.findViewById(R.id.add_question);
		transaction = getActivity().getSupportFragmentManager().beginTransaction();
		askButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				askQuestion(question.getText().toString());

			}

		});

		if (courseId == -1) {
			loadUserQuestions();
		} else {
			load();
		}

		return rootView;
	}

	private void askQuestion(String body) {
		String email = ((EditText) rootView.findViewById(R.id.add_tag)).getText().toString();
		String token = ((BasePrivateActivity) getActivity()).getCurrentUser().getToken();
		ApiRouter.withToken(token).createCourseQuestion(courseId, body, email, new Callback<Question>() {

			@Override
			public void failure(RetrofitError error) {
				// TODO Auto-generated method stub

			}

			@Override
			public void success(Question question, Response res) {
				transaction = getActivity().getSupportFragmentManager().beginTransaction();
				transaction.add(R.id.questions_container, new QuestionFragment(question));
				transaction.commit();


			}
		});
	}

	public void renderStream() {

		for (Question question : questions)
			transaction.add(R.id.questions_container, new QuestionFragment(question));
		transaction.commit();
	}


	private void loadUserQuestions() {
		if (loadFlag) {
			return;
		}
		loadFlag = true;
		User user = ((BasePrivateActivity) getActivity()).getCurrentUser();
		ApiRouter.withToken(user.getToken()).getUserQuestions(user.getId(), new Callback<List<Question>>() {

			@Override
			public void success(List<Question> list, Response res) {
				loadFlag = false;
				questions = list;
				Log.e("test", list.get(0).getCourseId()+"");
				renderStream();
			}

			@Override
			public void failure(RetrofitError error) {
				// TODO Auto-generated method stub
				loadFlag = false;
			}
		});

	}

	public void load() {
		if (loadFlag) {
			return;
		}
		loadFlag = true;
		Log.v("7asan", "ASDADADADADA");
		String token = ((BasePrivateActivity) getActivity()).getCurrentUser().getToken();
		ApiRouter.withToken(token).getCourseQuestions(courseId, new Callback<List<Question>>() {

			@Override
			public void success(List<Question> list, Response res) {
				loadFlag = false;
				questions = list;
				renderStream();
			}

			@Override
			public void failure(RetrofitError error) {
				// TODO Auto-generated method stub
				loadFlag = false;
			}
		});
	}

}




