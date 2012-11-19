package com.example.studybuddy;


import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;

import com.parse.ParseUser;

public class ViewClasses extends Activity 
{
	//test
	 public void onCreate(Bundle savedInstanceState) 
	 {
	        super.onCreate(savedInstanceState);
	        // setting default screen to login.xml
	        setContentView(R.layout.view_classes);
	        
	        final ParseUser currentUser=ParseUser.getCurrentUser();

	        
	        for(int i=0; i<0; i++)
	        {
	        	//Trying to dynamically allocate buttons
	        	Button newclass=new Button(this);
	        	newclass.setText("Test");
	        	
	        }
	        List<Object> enrolled=currentUser.getList("courses");
	        
	        LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayout1);
	         Button[] buttonCourse=new Button[enrolled.size()];
	        if(enrolled.isEmpty())
	        {
	        	System.out.println("ERROR");
	        }
	        
	        else
	        {
	        	for(int i=0;i<enrolled.size();i++)
	        	{
	        		System.out.println(enrolled.get(i));
	        		final String tempname=enrolled.get(i).toString().substring(2,enrolled.get(i).toString().length()-2).toUpperCase();
	        		buttonCourse[i]=new Button(this);
	        		buttonCourse[i].setText(tempname);
	        		buttonCourse[i].setId(i);
	        		buttonCourse[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
	        		buttonCourse[i].setOnClickListener(new View.OnClickListener() 
	    	        {

	    	            public void onClick(View v)
	    	            {
	    	                // Switching to Register screen
	    	                Intent i = new Intent(getApplicationContext(), StudyBuddy.class);
	    	                String[]myStrings=new String[1];
	    	                myStrings[0]=tempname;
	    	                i.putExtra("strings",myStrings);
	    	                startActivity(i);
	    	            }
	    	        });
	        		ll.addView(buttonCourse[i]);
	        	}
	        }
	        
	        
	        Button addClass = (Button)findViewById(R.id.addNewClass);        
	        addClass.setOnClickListener(new View.OnClickListener() 
	        {

	            public void onClick(View v)
	            {
	                // Switching to Register screen
	                Intent i = new Intent(getApplicationContext(), AddClass.class);
	                startActivity(i);
	            }
	        });
	 }
	 
	  public void onClick(View v) {
	        Toast toast;
	        Log.w("ANDROID DYNAMIC VIEWS:", "View Id: " + v.getId());
	        switch (v.getId()) {
	        case 1:
	            toast = Toast.makeText(this, "Clicked on my dynamically added button!", Toast.LENGTH_LONG);
	            toast.setGravity(Gravity.TOP, 25, 400);
	            toast.show();
	            break;
	            // More buttons go here (if any) ...
	 
	        }
	    }
}
