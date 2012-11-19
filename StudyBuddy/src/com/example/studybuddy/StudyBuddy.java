package com.example.studybuddy;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


//PARSE USER PARSE USER PARSE USER
public class StudyBuddy extends Activity {

	private static String logtag = "StudyBuddy";//for use as the tag when logging 
	//Splash stuff
	protected Dialog mSplashDialog;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_study_buddy);

		Intent intent=getIntent();
		String[] myStrings=intent.getStringArrayExtra("strings");
		TextView cname=(TextView)findViewById(R.id.classTextName);
		if(myStrings[0].isEmpty())
			cname.setText("DEFAULT");
		else
			cname.setText(myStrings[0]);
		
		Button buttonFind = (Button)findViewById(R.id.buttonFind);        
		buttonFind.setOnClickListener(startListener); // Register the onClick listener with the implementation above

		Button buttonForum = (Button)findViewById(R.id.buttonForum);        
		buttonForum.setOnClickListener(stopListener); // Register the onClick listener with the implementation above

		Button buttonNotes = (Button)findViewById(R.id.buttonNotes);        
		buttonNotes.setOnClickListener(notesListener); // Register the onClick listener with the implementation above
	}


	//Create an anonymous implementation of OnClickListener
	private OnClickListener startListener = new OnClickListener() {
		public void onClick(View v) {
			Log.d(logtag,"onClick() called - start button");              
			//Toast.makeText(StudyBuddy.this, "The Find button was clicked.", Toast.LENGTH_LONG).show();
			Intent i=new Intent(StudyBuddy.this,FindClassmates.class);
			startActivity(i);
			Log.d(logtag,"onClick() ended - start button");
		}
	};

	// Create an anonymous implementation of OnClickListener
	private OnClickListener stopListener = new OnClickListener() {
		public void onClick(View v) {
			Log.d(logtag,"onClick() called - stop button"); 
			Toast.makeText(StudyBuddy.this, "The Forum button was clicked.", Toast.LENGTH_LONG).show();
			Log.d(logtag,"onClick() ended - stop button");
		} 
	};

	// Create an anonymous implementation of OnClickListener
	private OnClickListener notesListener = new OnClickListener() {
		public void onClick(View v) {
			Log.d(logtag,"onClick() called - stop button"); 
			Toast.makeText(StudyBuddy.this, "The Notes button was clicked.", Toast.LENGTH_LONG).show();
			Log.d(logtag,"onClick() ended - stop button");
		} 
	};

	/*
	@Override
	protected void onStart() {//activity is started and visible to the user
		Log.d(logtag,"onStart() called");
		super.onStart();  
	}
	@Override
	protected void onResume() {//activity was resumed and is visible again
		Log.d(logtag,"onResume() called");
		super.onResume();

	}
	
	
	@Override
	protected void onPause() { //device goes to sleep or another activity appears
		Log.d(logtag,"onPause() called");//another activity is currently running (or user has pressed Home)
		super.onPause();

	}
	@Override
	protected void onStop() { //the activity is not visible anymore
		Log.d(logtag,"onStop() called");
		super.onStop();

	}
	@Override
	protected void onDestroy() {//android has killed this activity
		Log.d(logtag,"onDestroy() called");
		super.onDestroy();
	}

	*/

	
}