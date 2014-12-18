package com.example.csen704.activity;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.csen704.R;
import com.example.csen704.base.BaseActivity;
import com.example.csen704.base.BasePrivateActivity;
import com.example.csen704.util.ApiRouter;
import com.example.csen704.util.PrivateApiInterceptor;

public class CreateCourseActivity extends BasePrivateActivity {

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
				else
					ApiRouter.withToken(getCurrentUser().getToken()).create_course(courseNameEdit.getText().toString(),
							courseCodeEdit.getText().toString(), new Callback<Object>() {
						
						@Override
						public void success(Object obj, Response res) {
							activity.finish();
							
						}
						
						@Override
						public void failure(RetrofitError error) {
							Toast.makeText(activity, error.getMessage(), Toast.LENGTH_LONG).show();
						}
					});
			}

		});


		findViewById(R.id.cancelCourse).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
			
					activity.finish();	
			}

		});

	}


}
