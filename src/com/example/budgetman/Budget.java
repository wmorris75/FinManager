package com.example.budgetman;
import com.example.budgetInputLaunch.BudgetItemList;
import java.util.ArrayList;
import java.util.List;

import com.example.budgetInputLaunch.AddNewToBudgetLaunch;
import com.example.budgetInputLaunch.BudgetProjection;
import com.example.budgetInputLaunch.DiscretionaryExpense;
import com.example.budgetInputLaunch.HelpInBudgetLaunch;
import com.example.budgetInputLaunch.Income;
import com.example.budgetInputLaunch.LogExpense;
import com.example.budgetInputLaunch.PrimaryExpense;


//import course.labs.intentslab.ActivityLoaderActivity;
//import course.labs.intentslab.ExplicitlyLoadedActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Budget extends Activity implements AdapterView.OnItemClickListener, OnClickListener{
	static private final String TAG = "BudgetMan";
		  
	  private ListView itemListView;
	  private Button addItemToList;
	  private BudgetAdapter mAdapter;
	  
	  static private final int GET_TEXT_REQUEST_CODE = 1;
	  private TextView incomeAmount;
  
	  //use this instance to change values in listview
	  BudgetItemList inputInListview;
	  
	  private  List<BudgetItemList> itemList;
	  
	  private String[] items = { "Income", "Primary Expenses", "Discretionary Expenses",
			"Real Time Expenses", "Budget Projections", "Help" };	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.budget_layout);
		
		log("Initializing List");
		initViews();    
		
		incomeAmount = (TextView) findViewById(R.id.income_amount);
		
        itemList = new ArrayList<BudgetItemList>();
        mAdapter = new BudgetAdapter(this, itemList);
        
        log("Setting Adapter");
        itemListView.setAdapter(mAdapter);
        log("Adding Default Items to List");
        for (int i=0; i < items.length; i++){
	        itemList.add(new BudgetItemList(items[i], "$0"));	        
	        mAdapter.notifyDataSetChanged();
        }
	}	
	
	  private void initViews() {  
          itemListView = (ListView) findViewById(R.id.listView2);  
          addItemToList = (Button) findViewById(R.id.add_category);  
          addItemToList.setOnClickListener((OnClickListener) this); 
          itemListView.setOnItemClickListener(this);
         
     } 
	  
	  private void addItemsToList() {		  	
	         itemList.add(new BudgetItemList("New Category", "$0"));	 
	         mAdapter.notifyDataSetChanged();	    	
	     }
	
	  @Override  
	     public void onClick(View v) {  
	         // switch (v.getId()) {  
	         // case R.id.addItemToList:  
	              addItemsToList();  
	           //   break;  
	         // }  
	     }
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		position = parent.getPositionForView(view);

		log("Start Intent for each Activity");

		// Launch activity for each item in listview		
		switch (position) {
		case 0:
			Log.i(TAG,"Entered Income");
			Intent intent = new Intent(Budget.this, Income.class);
			startActivityForResult(intent, GET_TEXT_REQUEST_CODE);
			break;
		case 1:
			startActivity(new Intent(this, PrimaryExpense.class));
			break;
		case 2:
			startActivity(new Intent(this, DiscretionaryExpense.class));
			break;
		case 3:
			startActivity(new Intent(this, LogExpense.class));
			break;
		case 4:
			startActivity(new Intent(this, BudgetProjection.class));
			break;
		case 5:
			startActivity(new Intent(this, AddNewToBudgetLaunch.class));
			break;
		case 6:
			startActivity(new Intent(this, HelpInBudgetLaunch.class));
			break;
		default:
			(Toast.makeText(getApplicationContext(), "nothing",
					Toast.LENGTH_LONG)).show();
		}

	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		Log.i(TAG, "Entered onActivityResult()");
		
		// TODO - Process the result only if this method received both a
		// RESULT_OK result code and a recognized request code
		// If so, update the Textview showing the user-entered text.
		if(requestCode == GET_TEXT_REQUEST_CODE ){ 
			if(resultCode == RESULT_OK){
				String message = data.getStringExtra("incomeValue");				
				incomeAmount.setText(message);  //textview instance
			
//				Log.i(TAG, "Entered Income to include it");
				String income = data.getStringExtra("incomeStated");
//				itemList.add(new BudgetItemList(items[0], income));				
				//mAdapter.notifyDataSetChanged();
		
			}
		}

	}

	// Method for logging/debugging
	private void log(String msg) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Log.i(TAG, msg);
	}

}
