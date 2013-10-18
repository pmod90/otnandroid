package com.otn.ownthenightandroid;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;

import com.parse.ParseUser;

import android.app.Application;

public class ParseApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// Add your initialization code here
		Parse.initialize(this, "d3Kk3zXGSWvY3qaISLyzQ8YJdTxOhPWi0weilIXH", "17AHB8gOg2vDDkZBL2KNoydUeycNzhkmnVoaTuim"); 
	
	
		

		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
	    
		// If you would like all objects to be private by default, remove this line.
		defaultACL.setPublicReadAccess(true);
		
		ParseACL.setDefaultACL(defaultACL, true);
	}

}

