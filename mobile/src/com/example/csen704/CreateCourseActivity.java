package com.example.csen704;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateCourseActivity extends Activity {

	EditText courseNameEdit;
	EditText courseCodeEdit;
	EditText courseDescriptionEdit;
	Activity activity = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_course);
		courseNameEdit = (EditText) findViewById(R.id.course_name_edit);
		courseCodeEdit = (EditText) findViewById(R.id.course_code_edit);
		courseDescriptionEdit = (EditText) findViewById(R.id.course_description_edit);
		findViewById(R.id.createCourse).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if(courseNameEdit.getText().toString().equals(""))
					Toast.makeText(activity, "Please enter a valid course name.", Toast.LENGTH_LONG).show();
				else if(courseCodeEdit.getText().toString().equals(""))
					Toast.makeText(activity, "Please enter a valid course code.", Toast.LENGTH_LONG).show();
				else
					activity.finish();
			}

		});
		findViewById(R.id.cancelCourse).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
					activity.finish();
			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

}
