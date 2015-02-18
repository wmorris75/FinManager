package com.example.budgetInputLaunch;

import com.example.budgetman.R;
import com.example.budgetman.R.layout;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class Income extends Activity {
	static private final String TAG = "Lab-Intents";
	static private final int RESULT_CODE = 1;

	private EditText incomeInput;
	BudgetItemList incomeTotal;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.budget_sum_item);
		
		// Get a reference to the EditText field
		incomeInput = (EditText) findViewById(R.id.salary_value);

		// Declare and setup "Enter" button
		Button save = (Button) findViewById(R.id.save);
		save.setOnClickListener(new OnClickListener() {

			// Call enterClicked() when pressed

			@Override
			public void onClick(View v) {

				enterClicked();
			
			}
		});
	}

		private void enterClicked() {

			Log.i(TAG,"Entered enterClicked()");
			
			// TODO - Save user provided input from the EditText field
			String incomeValue = incomeInput.getText().toString();
			
			String income = incomeInput.getText().toString();
			
			Log.i(TAG, "summary data being passed");		
			// TODO - Create a new intent and save the input from the EditText field as an extra
			Intent intent = new Intent ();
			intent.putExtra("incomeValue", incomeValue);
			setResult(RESULT_OK, intent);
			
			
//			Intent newIntent = new Intent();
//
//			Log.i(TAG, "Entered Change income");
//			newIntent.putExtra("incomeStated", income);
//			
//			
//			// TODO - Set Activity's result with result code RESULT_OK
//			setResult(RESULT_OK, newIntent);
			// TODO - Finish the Activity
			finish();
		
	}

}
