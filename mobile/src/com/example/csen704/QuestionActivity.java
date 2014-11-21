package com.example.csen704;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.view.Menu;

public class QuestionActivity extends Activity {

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
