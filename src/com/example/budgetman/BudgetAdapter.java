package com.example.budgetman;
import com.example.budgetInputLaunch.*;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BudgetAdapter extends BaseAdapter {

	 private Activity mContext; 
     public List<BudgetItemList> myList;     
     private LayoutInflater mLayoutInflater = null; 
     private TextView textView;
     
     public BudgetAdapter(Activity context, List<BudgetItemList>list){
   	  mContext = context;  
         myList = list;  
         mLayoutInflater = (LayoutInflater) mContext  
                   .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
     }

     @Override  
     public int getCount() {  
          return myList.size();  
     }  
     @Override  
     public Object getItem(int pos) {  
          return myList.get(pos);  
     }  
     @Override  
     public long getItemId(int position) {  
          return position;  
     }  

       
     
     @Override
     public View getView(int position, View convertView, ViewGroup parent){
   	  View view = convertView;
   	  BudgetViewHolder viewHolder;
   	  if(convertView == null){
   		  LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
   		  view = inflater.inflate(R.layout.budget_view, parent, false);
   		  viewHolder = new BudgetViewHolder(view);   		  
   		  view.setTag(viewHolder);
   	  }else {
   		  viewHolder = (BudgetViewHolder)view.getTag(); 
   	  }
   	  
   	  BudgetItemList temp = myList.get(position); 
   	  
   	  viewHolder.item.setText(temp.getItemInList());
   	  viewHolder.itemAmount.setText(temp.getItemAmount());
   	     	  
//   	viewHolder.item.setText(temp.itemInList);
//   	viewHolder.itemAmount.setText(temp.itemAmountInList);
   	  
   	  return view;
     }
}

class BudgetViewHolder {  
    public TextView item, itemAmount;  
    public BudgetViewHolder(View base) {  
         item = (TextView) base.findViewById(R.id.item);  
        itemAmount =  (TextView) base.findViewById(R.id.itemAmount);
    }    
  
}

//class BudgetItemList{
//	  String itemInList;
//	  String itemAmountInList;	
//	  
//	public BudgetItemList(String itemInList, String itemAmountInList) {
//		super();
//		this.itemInList = itemInList;
//		this.itemAmountInList = itemAmountInList;
//	}
//}