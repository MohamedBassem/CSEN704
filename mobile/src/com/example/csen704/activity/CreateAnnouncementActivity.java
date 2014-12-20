package com.example.csen704.activity;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import com.example.csen704.R;
import com.example.csen704.R.array;
import com.example.csen704.R.id;
import com.example.csen704.R.layout;
import com.example.csen704.R.menu;
import com.example.csen704.base.BasePrivateActivity;
import com.example.csen704.model.Announcement;
import com.example.csen704.util.ApiRouter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class CreateAnnouncementActivity extends BasePrivateActivity implements
		OnItemSelectedListener {

	private String choice;
	EditText body;
	EditText deadline;
	Activity activity = this;
	long courseId;
	boolean createFlag;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_announcement);
		
		courseId = getIntent().getLongExtra("courseId", -1);
//		Spinner spinner = (Spinner) this.findViewById(R.id.announcement_type);
//		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
//				this.getBaseContext(), R.array.type_array,
//				android.R.layout.simple_spinner_item);
		body = (EditText) this.findViewById(R.id.announcement_body_edit);
//		deadline = (EditText) this
//				.findViewById(R.id.announcement_deadline_edit);
//		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//		spinner.setAdapter(adapter);
//		spinner.setOnItemSelectedListener(this);
		findViewById(R.id.cancelAnnouncement).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				activity.finish();
			}
		});
		
		findViewById(R.id.createAnnouncement).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if (createFlag) {
					return;
				}
				createFlag = true;
				String token = getCurrentUser().getToken();
				ApiRouter.withToken(token).createCourseAnnouncement(courseId, body.getText().toString(), new Callback<Announcement>() {
					
					@Override
					public void success(Announcement arg0, Response arg1) {
						createFlag = false;
						activity.finish();
					}
					
					@Override
					public void failure(RetrofitError error) {
						createFlag = false;
						Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG);
					}
				});
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_announcement, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		choice = parent.getItemAtPosition(position).toString();
		if (parent.getItemAtPosition(position).toString().equals("Deadline"))
			deadline.setVisibility(View.VISIBLE);
		else
			deadline.setVisibility(View.GONE);

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}

}
