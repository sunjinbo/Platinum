package com.android.Platinum;

import java.util.Calendar;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;


import android.widget.Spinner;

public class AccountAddDialog extends Dialog{
	Context mContext;
	Calendar mCalendar;
	public AccountAddDialog(Context context){
		super(context);
		mContext = context;
	}
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);

		setContentView(R.layout.account_adddialog);

		setTitle("Account");
		
		mCalendar = Calendar.getInstance();
		
		
		// 初始化账户下拉列表
		String[] accountData = {"Cash", "Credit card", "Savings" };
		ArrayAdapter<String> accountAdapter = new ArrayAdapter<String>(mContext, 
				android.R.layout.simple_spinner_item,
				accountData
				);
		accountAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		Spinner accountSpinner = (Spinner)findViewById(R.id.AccountCategorySpinner);
		accountSpinner.setAdapter(accountAdapter);
		

		
		// 给按钮添加监听器
		Button addButton = (Button) findViewById(R.id.AcountAdd2Button);
		addButton.setOnClickListener( new Button.OnClickListener(){
			public void onClick(View v) {

			}
		});
		
		Button addCloseButton = (Button) findViewById(R.id.AcountAddCloseButton);
		addCloseButton.setOnClickListener( new Button.OnClickListener(){
			public void onClick(View v) {
				dismiss();
			}
		});
		
		Button closeButton = (Button) findViewById(R.id.AcountCloseButton);
		closeButton.setOnClickListener( new Button.OnClickListener(){
			public void onClick(View v) {
				dismiss();
			}
		});

	}
}
