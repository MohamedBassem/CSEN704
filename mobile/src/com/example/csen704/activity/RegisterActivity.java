package com.example.csen704.activity;

import com.example.csen704.R;
import com.example.csen704.R.id;
import com.example.csen704.R.layout;
import com.example.csen704.R.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends Activity {
	EditText name;
	EditText mail;
	EditText password;
	EditText birthday;
	Activity activity = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		name = (EditText) findViewById(R.id.user_name_edit);
		mail = (EditText) findViewById(R.id.user_mail_edit);
		password = (EditText) findViewById(R.id.user_password_edit);
		birthday = (EditText) findViewById(R.id.user_birhtday_edit);
		findViewById(R.id.cancelSignup).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				activity.finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
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
}
