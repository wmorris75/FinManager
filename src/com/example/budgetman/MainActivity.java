package com.example.budgetman;

import java.util.ArrayList;
import java.util.List;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity  {
	
	static private final String TAG = "BudgetMan";
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		
		//Declare and setup "Budget" button
		Button budget = (Button)findViewById(R.id.budget_button);
        budget = (Button)findViewById(R.id.budget_button);
        budget.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			//Launching intent for starting Budget Activity	
				
			log("Entered start Budget Activity");	
			Intent intent = new Intent(MainActivity.this, Budget.class);
			startActivity(intent);
			
			}
			
			
			
		});
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	//Method for debugging
			private void log(String msg) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Log.i(TAG, msg);
			}
	
	
}
