package com.example.studybuddy;


import java.util.Arrays;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

@TargetApi(9) //There has to be a better way then this

public class Register extends Activity {

	 public void onCreate(Bundle savedInstanceState)
	 {
	        super.onCreate(savedInstanceState);
	        // Set View to register.xml
	        setContentView(R.layout.register);


	         final ParseUser user=new ParseUser();

	        TextView loginScreen = (TextView) findViewById(R.id.link_to_login);
	        Button signup = (Button) findViewById(R.id.btnRegister);

	        signup.setOnClickListener(new View.OnClickListener() {

	        	public void onClick(View arg0){
	        		//Creates ParseUser based on account
	        		//Right now I beleive duplicate names are not cool, need to check Parse for that
	        		EditText name=(EditText) findViewById(R.id.reg_fullname);
	        		EditText email=(EditText) findViewById(R.id.reg_email);
	        		EditText password=(EditText) findViewById(R.id.reg_password);
	        		String sname=name.getText().toString();
	        		String semail=email.getText().toString();
	        		String spassword=password.getText().toString();
	        		if(sname.isEmpty() || semail.isEmpty() || spassword.isEmpty())
	        		{
	        			System.out.println("STUPID");
	        		}
	        		else
	        		{

	        			user.setUsername(name.getText().toString());
		        		user.setPassword(password.getText().toString());
		        		user.setEmail(email.getText().toString());
		        		System.out.println("About to signup");
		        		user.signUpInBackground(new SignUpCallback() {
		        			  public void done(ParseException e) {
		        			    if (e == null) {
		        			      // Hooray! Let them use the app now.
		        			    	System.out.println("Success");
		        			    	user.put("courses", "default");
		        			    	finish();
		        			    } else {
		        			      // Sign up didn't succeed. Look at the ParseException
		        			      // to figure out what went wrong
		        			    	System.out.println(e.toString());
		        			    	System.out.println("Failure");
		        			    }
		        			  }
		        			});
	        		}

	        	}
	        });

	        // Listening to Login Screen link
	        loginScreen.setOnClickListener(new View.OnClickListener() {

	            public void onClick(View arg0) {
	                                // Closing registration screen
	                // Switching to Login Screen/closing register screen
	                finish();
	            }
	        });
	    }
	}