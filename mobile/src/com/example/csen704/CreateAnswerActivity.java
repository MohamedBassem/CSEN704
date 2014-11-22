package com.example.csen704;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAnswerActivity extends Activity {
	EditText answerTitleEdit;
	EditText answerInfoEdit;
	Activity activity = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_answer);
		answerTitleEdit = (EditText) findViewById(R.id.answer_title_edit);
		answerInfoEdit = (EditText) findViewById(R.id.answer_info_edit);
		findViewById(R.id.createAnswer).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(answerTitleEdit.getText().equals(""))
					Toast.makeText(activity, "Please enter a valid answer title.", Toast.LENGTH_LONG).show();
				else if(answerInfoEdit.getText().equals(""))
					Toast.makeText(activity, "Please enter a valid answer.", Toast.LENGTH_LONG).show();
				else
					activity.finish();
			}  
				
		});
		findViewById(R.id.cancelAnswer).setOnClickListener(new View.OnClickListener() {
			
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
