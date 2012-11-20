package com.example.studybuddy;

import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

//ADD TO ADD CLASS
//TEST COMMENT FOR COMMIT
//THIS IS A TEST
//Test 2
//pioiuggf
//TEst
public class AddClass extends Activity{

	 public void onCreate(Bundle savedInstanceState) 
	 {
	        super.onCreate(savedInstanceState);
	        // setting default screen to login.xml
	        setContentView(R.layout.add_class);


	        final ParseUser currentUser=ParseUser.getCurrentUser();

	        Button buttonNewClass =(Button) findViewById(R.id.btnAddClass);
	        buttonNewClass.setOnClickListener(new View.OnClickListener() {

				public void onClick(View v) {
	        		EditText classname=(EditText) findViewById(R.id.courseName);
	        		EditText coursenum=(EditText) findViewById(R.id.courseNumber);
	        		String sclassname=classname.getText().toString();
	        		String sclassnum=coursenum.getText().toString();

	        		if(sclassname.isEmpty() || sclassnum.isEmpty())
	        		{
	        			System.out.println("STUPID");
	        		}
	        		else
	        		{
	        			sclassname.toUpperCase();
	        			String course=sclassname+sclassnum;
	        			
	        			System.out.println(course);
	        			System.out.println(currentUser.getUsername());
	        			
	        			currentUser.add("courses",Arrays.asList(course));
	        			currentUser.saveInBackground();
	        		}
				}
			});



	  }


}
