package com.example.studybuddy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.widget.Toast;

public class SettingsActivity extends PreferenceActivity implements OnSharedPreferenceChangeListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.layout.activity_setting);

		LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

		if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
			Toast.makeText(this, "GPS is Enabled in your devide", Toast.LENGTH_SHORT).show();
		}else{
			showGPSDisabledAlertToUser();
		}

	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
	prefs.registerOnSharedPreferenceChangeListener(this);
}

	//Checks if GPS is enabled and if not makes user enable it
private void showGPSDisabledAlertToUser(){
	AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
	alertDialogBuilder.setMessage("GPS is disabled in your device. Would you like to enable it?")
	.setCancelable(false)
	.setPositiveButton("Goto Settings Page To Enable GPS",
			new DialogInterface.OnClickListener(){
		public void onClick(DialogInterface dialog, int id){
			Intent callGPSSettingIntent = new Intent(
					android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
			startActivity(callGPSSettingIntent);
		}
	});
	alertDialogBuilder.setNegativeButton("Cancel",
			new DialogInterface.OnClickListener(){
		public void onClick(DialogInterface dialog, int id){
			dialog.cancel();
		}
	});
	AlertDialog alert = alertDialogBuilder.create();
	alert.show();
}




@Override
public boolean onCreateOptionsMenu(Menu menu) {
	//   getMenuInflater().inflate(R.menu.activity_setting, menu);
	return true;
}


public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
	setResult(1, null);

}
}