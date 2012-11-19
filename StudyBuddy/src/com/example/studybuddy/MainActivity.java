package com.example.studybuddy;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity
{

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button buttonClass = (Button)findViewById(R.id.classes);        
		buttonClass.setOnClickListener(classListener); // Register the onClick listener with the implementation above

		Button buttonSettings = (Button)findViewById(R.id.settings);        
		buttonSettings.setOnClickListener(settingsListener); // Register the onClick listener with the implementation above

	}

	//Create an anonymous implementation of OnClickListener
		private OnClickListener classListener = new OnClickListener() {
			public void onClick(View v) {
				//Toast.makeText(StudyBuddy.this, "The Find button was clicked.", Toast.LENGTH_LONG).show();
		    	  Intent i = new Intent(getApplicationContext(), ViewClasses.class); //Need to write classes class
				startActivity(i);
			}
		};


		//Create an anonymous implementation of OnClickListener
			private OnClickListener settingsListener = new OnClickListener() {
				public void onClick(View v) {
					//Toast.makeText(StudyBuddy.this, "The Find button was clicked.", Toast.LENGTH_LONG).show();
			    	  Intent i = new Intent(getApplicationContext(), SettingsActivity.class);
					startActivity(i);
				}
			};
	/*
	Location location;
	private static LocationManager locationManager;
	private double latval,lonval;
	String provider;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		boolean enabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

		// Check if enabled and if not send user to the GPS settings
		if (!enabled) {
		  Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
		  startActivity(intent);
		} 
		getlocation();

    }
    
    public void getlocation()
    {
    	Criteria criteria = new Criteria();
		provider = locationManager.getBestProvider(criteria, false);
		location = locationManager.getLastKnownLocation(provider);

		//test
		latval = location.getLatitude();
		lonval = location.getLongitude();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*/
			
			 
}