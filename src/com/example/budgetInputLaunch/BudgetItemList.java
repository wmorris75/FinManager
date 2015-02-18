package com.example.budgetInputLaunch;
import android.content.Intent;
import android.widget.TextView;

import com.example.budgetInputLaunch.*;


public class BudgetItemList{
	  private String itemInList;
	  private String itemAmountInList;
	  private final static String INCOME_AMOUNT = "income";
	  private String mIncome;
	  TextView textView;
	 	 	  
	public BudgetItemList(String itemInList, String itemAmountInList) {
		super();
		this.itemInList = itemInList;
		this.itemAmountInList = itemAmountInList;
	}
	
	public BudgetItemList (String changedItemAmount){
		this.itemAmountInList = changedItemAmount;		
	}
	
   public BudgetItemList(Intent intent) {
		// TODO Auto-generated constructor stub
	    mIncome = intent.getStringExtra(BudgetItemList.INCOME_AMOUNT);	   
	}

public String getItemAmount() {
	   return itemAmountInList;
   }
   
   public String getItemInList() {
	   return itemInList;
   }
   
   public TextView setTextView(TextView newView){
    	this.textView = newView;
    	return textView;
    }
  
}
