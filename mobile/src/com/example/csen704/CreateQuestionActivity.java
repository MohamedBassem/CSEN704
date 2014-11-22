package com.example.csen704;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateQuestionActivity extends Activity {

	EditText questionTitleEdit;
	EditText questionInfoEdit;
	Activity activity = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_question);
		questionTitleEdit = (EditText) findViewById(R.id.question_title_edit);
		questionInfoEdit = (EditText) findViewById(R.id.question_info_edit);
		findViewById(R.id.createQuestion).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(questionTitleEdit.getText().equals(""))
					Toast.makeText(activity, "Please enter a valid question title.", Toast.LENGTH_LONG).show();
				else if(questionInfoEdit.getText().equals(""))
					Toast.makeText(activity, "Please enter a valid question.", Toast.LENGTH_LONG).show();
				else
					activity.finish();
			}  
				
		});
		findViewById(R.id.cancelQuestion).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
					activity.finish();
			}  
				
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_course, menu);
		return true;
	}

}
