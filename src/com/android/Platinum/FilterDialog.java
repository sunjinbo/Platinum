package com.android.Platinum;

import java.util.Calendar;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;


public class FilterDialog extends Dialog{
	private Calendar mCalendar;
	private DatePicker mStartDatePicker;
	private DatePicker mClosingDatePicker;
	private Button mThisMonthButton;
	private Button mThisWeekButton;
	private Button mOkayButton;

	public FilterDialog(Context context){
		super(context);
	}
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);

		setContentView(R.layout.filterdialog);

		mCalendar = Calendar.getInstance();
		
		// 初始化DatePicker
		mStartDatePicker = (DatePicker)findViewById(R.id.startDatePicker);
		mStartDatePicker.init(mCalendar.get(Calendar.YEAR),mCalendar.get(Calendar.MONTH), 
				mCalendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
					
					public void onDateChanged(DatePicker view, int year, int monthOfYear,
							int dayOfMonth) {
						// TODO Auto-generated method stub
						
					}
				});
		
		mClosingDatePicker = (DatePicker)findViewById(R.id.startDatePicker);
		mClosingDatePicker.init(mCalendar.get(Calendar.YEAR),mCalendar.get(Calendar.MONTH), 
				mCalendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
					
					public void onDateChanged(DatePicker view, int year, int monthOfYear,
							int dayOfMonth) {
						// TODO Auto-generated method stub
						
					}
				});
		
		// 初始化Button
		mThisMonthButton = (Button)findViewById(R.id.thisMonthButton);
		mThisMonthButton.setOnClickListener( new Button.OnClickListener(){
			public void onClick(View v) {
			}
		});
		
		mThisWeekButton = (Button)findViewById(R.id.thisWeekButton);
		mThisWeekButton.setOnClickListener( new Button.OnClickListener(){
			public void onClick(View v) {
			}
		});
		
		mOkayButton = (Button)findViewById(R.id.okayButton);
		mOkayButton.setOnClickListener( new Button.OnClickListener(){
			public void onClick(View v) {
				dismiss();
			}
		});
	}
}
