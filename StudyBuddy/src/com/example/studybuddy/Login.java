package com.example.studybuddy;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

public class Login extends Activity 
{
	protected Dialog mSplashDialog;
	//test
	 public void onCreate(Bundle savedInstanceState) 
	 {
	        super.onCreate(savedInstanceState);
	        // setting default screen to login.xml
	        setContentView(R.layout.login);

			 Parse.initialize(this, "1NWMQfGpBkTcZXfEaltXMiMyn9q9Nfq4A4SwN9kd", "gBTpNWqnHSX9tWdmxAPuOPkd7jMTBTfrrnHZCg9G"); 

			 showSplashScreen();

	        TextView registerScreen = (TextView) findViewById(R.id.link_to_register);
	        Button login =(Button) findViewById(R.id.btnLogin);
	        login.setOnClickListener(new View.OnClickListener() {

				public void onClick(View v) {
	        		EditText username=(EditText) findViewById(R.id.userLogin);
	        		EditText password=(EditText) findViewById(R.id.passwordLogin);
	        		String susername=username.getText().toString();
	        		String spassword=password.getText().toString();
	        		
	        		if(susername.isEmpty() || spassword.isEmpty())
	        		{
	        			System.out.println("STUPID");
	        		}
	        		else
	        		{
	        			ParseUser.logInInBackground(susername, spassword, new LogInCallback() {
	        				  public void done(ParseUser user, ParseException e) {
	        					    if (user != null) {
	        					      // Hooray! The user is logged in.
			        			    	System.out.println("Success");
			        			    	
			        			      

			        			    	  Intent i = new Intent(getApplicationContext(), MainActivity.class);
			        		                startActivity(i);

	        					    } else {
	        					      // Signup failed. Look at the ParseException to see what happened.
	        					    	System.out.println(e.toString());
			        			    	System.out.println("Failure");
	        					    }
	        					  }
	        					});
	        		}
				}
			});
	        // Listening to register new account link
	        registerScreen.setOnClickListener(new View.OnClickListener() 
	        {

	            public void onClick(View v)
	            {
	                // Switching to Register screen
	                Intent i = new Intent(getApplicationContext(), Register.class);
	                startActivity(i);
	            }
	        });


	  }

		protected void showSplashScreen() {
			mSplashDialog = new Dialog(this, R.style.SplashScreen);
			mSplashDialog.setContentView(R.layout.splash);
			mSplashDialog.setCancelable(false);
			mSplashDialog.show();

			// Set Runnable to remove splash screen just in case
			final Handler handler = new Handler();
			handler.postDelayed(new Runnable() {
				// @Override
				public void run() {
					removeSplashScreen();
				}
			}, 3000);   //Edit this number for Splash length
		}
		protected void removeSplashScreen() {
			if (mSplashDialog != null) {
				mSplashDialog.dismiss();
				mSplashDialog = null;
			}
		}//test

}