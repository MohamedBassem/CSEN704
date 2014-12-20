package com.example.csen704;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.csen704.util.ApiRouter;

public class RegisterActivity extends Activity{
	EditText name;
	EditText mail;
	EditText password;
	EditText birthday;
	Button signup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		name = (EditText) findViewById(R.id.user_name_edit);
		mail = (EditText) findViewById(R.id.user_mail_edit);
		password = (EditText) findViewById(R.id.user_password_edit);
		signup = (Button) findViewById(R.id.signup);
		signup.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	Log.e("test","test");
		    	ApiRouter.withoutToken().register(mail.getText().toString(), name.getText().toString(), password.getText().toString(), new Callback<Response>() {

					@Override
					public void failure(RetrofitError error) {
						Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();

					}

					@Override
					public void success(Response arg0, Response arg1) {
						Toast.makeText(getApplicationContext(), "Registered!", Toast.LENGTH_SHORT).show();
					}
				});
		    }
		});

		findViewById(R.id.cancelSignup).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
//		signup.setOnClickListener(this);
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
