package com.otn.ownthenightandroid;



import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText username;
	EditText password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		username = (EditText) findViewById(R.id.username);
		password = (EditText) findViewById(R.id.password);
		return true;
	}
	public void registerClicked(View v)
    {
    Intent intent = new Intent(this,SignUpActivity.class);
    startActivity(intent);
    }
	
	public void logIn(View v)
	{
		String usernametxt = username.getText().toString();
		String passwordtxt = password.getText().toString();
		ParseUser.logInInBackground(usernametxt,
                passwordtxt,
                new LogInCallback(){

					@Override
					public void done(ParseUser user, ParseException e) {
						// TODO Auto-generated method stub
						
						if (user != null) {
							Intent intent2 = new Intent(MainActivity.this,HelpActivity.class);
			                 startActivity(intent2);
			                        Toast.makeText(getApplicationContext(),
			                                "Successfully Logged in",
			                                Toast.LENGTH_LONG).show();
			                        finish();	// If user exist and authenticated, send user to home.class
						   
						 	
				
							//finish();
						} else {
							Toast.makeText(
									getApplicationContext(),
									"No such user exist, please signup",
									Toast.LENGTH_LONG).show();
						}
					}});
	}

}
