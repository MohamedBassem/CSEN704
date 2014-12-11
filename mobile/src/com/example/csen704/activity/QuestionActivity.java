package com.example.csen704.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;

import com.example.csen704.R;
import com.example.csen704.base.BaseActivity;
import com.example.csen704.fragment.AnswerFragment;

public class QuestionActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.question, menu);
		renderAnswers();

		return true;
	}

	public void renderAnswers() {
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		for (int i = 0; i < 10; i++)
			transaction.add(R.id.answers, new AnswerFragment());
		transaction.commit();
	}

}
