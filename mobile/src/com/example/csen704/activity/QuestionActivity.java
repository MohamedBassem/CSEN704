package com.example.csen704.activity;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.csen704.R;
import com.example.csen704.base.BaseActivity;
import com.example.csen704.fragment.AnswerFragment;
import com.example.csen704.model.Answer;
import com.example.csen704.model.Question;
import com.example.csen704.model.User;
import com.example.csen704.util.ApiRouter;

public class QuestionActivity extends BaseActivity {

	public static Question question;
	List<Answer> answers;
	FragmentTransaction transaction;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		transaction = getFragmentManager().beginTransaction();
		
		answers = new ArrayList<Answer>();
		loadAnswers();
		renderAnswers();
		renderQuestion();
		bind();
	}


	private void bind() {
		Button addAnswer = (Button) findViewById(R.id.add_answer_button);
		final EditText answerBody = (EditText) findViewById(R.id.add_answer);
		addAnswer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				ApiRouter.withToken(getCurrentUser().getToken()).createAnswer(1, question.getId(), answerBody.getText().toString(),
						getCurrentUser().getId(), new Callback<Answer>() {

							@Override
							public void failure(RetrofitError arg0) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void success(Answer ans, Response res) {
								transaction = getFragmentManager().beginTransaction();
								transaction.add(R.id.answers, new AnswerFragment(ans));
								transaction.commit();
								
							}
						});
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.question, menu);
		

		return true;
	}

	
	private void loadAnswers() {
		User user = getCurrentUser();
		ApiRouter.withToken(user.getToken()).getAnswers(1, question.getId(), new Callback<List<Answer>>() {
			
			@Override
			public void success(List<Answer> list, Response res) {
				answers = list;
				renderAnswers();
			}
			
			@Override
			public void failure(RetrofitError arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	public void renderQuestion() {
		TextView asker = (TextView) findViewById(R.id.question_info);
		TextView questionView = (TextView) findViewById(R.id.question_title);
		asker.setText(question.getUsername());
		questionView.setText(question.getBody());
	}

	
	public void renderAnswers() {
		transaction = getFragmentManager().beginTransaction();
		for (Answer answer : answers)
			transaction.add(R.id.answers, new AnswerFragment(answer));
		transaction.commit();
	}

}
