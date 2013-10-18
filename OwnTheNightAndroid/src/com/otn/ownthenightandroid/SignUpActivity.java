package com.otn.ownthenightandroid;




import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SignUpActivity extends Activity {
	
	EditText firstname;
	EditText lastname;
	EditText password;
	EditText email;
	RadioButton genderFemale;
	RadioButton genderMale;
	String firstnametxt;
	String lastnametxt;
	String passwordtxt;
	String emailtxt;
	String gender;
	String usernametxt;
	
	public void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		 firstname = (EditText) findViewById(R.id.firstName);
		 lastname = (EditText) findViewById(R.id.lastName);
		 password = (EditText) findViewById(R.id.password);
		 email = (EditText) findViewById(R.id.email);
		 genderFemale = (RadioButton) findViewById(R.id.radioFemale);
		 genderMale = (RadioButton) findViewById(R.id.radioMale);
		
		
		
		}
	
	public void signUpClicked(View arg0)
	{
		firstnametxt = firstname.getText().toString();
		lastnametxt = lastname.getText().toString();
		passwordtxt = password.getText().toString();
		emailtxt = email.getText().toString();
		usernametxt = email.getText().toString();
			 	if(genderFemale.isChecked())
			 	{
			 		gender = "Female";
			 	}
			 	else
			 	{
			 		gender = "Male";
			 	}
			 	ParseUser user = new ParseUser();
			 	user.setUsername(emailtxt
			 			);
				user.setEmail(emailtxt);
				user.setPassword(passwordtxt);
				user.put("firstName", firstnametxt);
				user.put("lastName", lastnametxt);
				
				user.put("gender", gender);
				
				user.signUpInBackground(new SignUpCallback() {
					
					@Override
					public void done(ParseException e) {
						
						// TODO Auto-generated method stub
						if(e == null){
							ParseUser.logInInBackground(usernametxt,
					                passwordtxt,
					                new LogInCallback(){

										@Override
										public void done(ParseUser user, ParseException e) {
											// TODO Auto-generated method stub
											
											if (user != null) {
												Intent intent2 = new Intent(SignUpActivity.this,HelpActivity.class);
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
						else
						{
							e.printStackTrace();
							Toast.makeText(getApplicationContext(),
									"Sign up Error", Toast.LENGTH_LONG)
									.show();
						}
					}
				});
				
				
	}
}
