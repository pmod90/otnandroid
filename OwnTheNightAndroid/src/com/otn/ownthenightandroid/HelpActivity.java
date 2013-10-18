package com.otn.ownthenightandroid;



import com.parse.ParseUser;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HelpActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.helpactivity);
		ParseUser currentUser = ParseUser.getCurrentUser();
		
	}
	
}
