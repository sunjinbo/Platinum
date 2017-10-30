package com.android.Platinum;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class AddDialog extends Dialog{
	private Context mContext;
	private Calendar mCalendar;
	private Button accountButton;
	private int[] accountDrawableIds = { 
					R.drawable.cash, 
					R.drawable.credit_card,
					R.drawable.savings
					};
	private int[] accountTextIds = {
					R.string.cash,
					R.string.credit_card,
					R.string.savings
					};
	
	public AddDialog(Context context){
		super(context);
		mContext = context;
	}
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);

		setContentView(R.layout.adddialog);
		
		mCalendar = Calendar.getInstance();
		
		// 初始化日期下拉列表
		CalendarButton dateButton = (CalendarButton)findViewById(R.id.dateSpinner);
		dateButton.setText("15/06/2011");
		dateButton.setOnClickListener( new Button.OnClickListener(){
			public void onClick(View v) {
				new DatePickerDialog(AddDialog.this.mContext,
						new DatePickerDialog.OnDateSetListener() {
							public void onDateSet(DatePicker view, int year, int monthOfYear,
									int dayOfMonth) {
								// 设置日期
							}
						},
						mCalendar.get(Calendar.YEAR), 
						mCalendar.get(Calendar.MONTH),
						mCalendar.get(Calendar.DAY_OF_MONTH)).show();
			}
		});
		
		// 初始化分类下拉列表
		String[] categoryData = {"Food", "Transport cost", "Clothes", "Utility bills" };
		ArrayAdapter<String> categoryAdapter = new ArrayAdapter<String>(mContext, 
				android.R.layout.simple_spinner_item,
				categoryData
				);
		categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		Spinner categorySpinner = (Spinner)findViewById(R.id.categorySpinner);
		categorySpinner.setAdapter(categoryAdapter);
		categorySpinner.setPrompt("Category/Properties");
		
		// 初始化账户下拉列表
		Spinner accountSpinner = (Spinner)findViewById(R.id.accountSpinner);
		accountSpinner.setAdapter(adapter);
		accountSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
			}

			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		
		// 初始化账户按钮

		accountButton = (Button)findViewById(R.id.accountButton);
		accountButton.setOnTouchListener(new View.OnTouchListener() {

			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){
					accountButton.setTextColor(Color.WHITE);
					accountButton.invalidate();
				}
				else{
					accountButton.setTextColor(Color.BLACK);
					accountButton.invalidate();
				}
				return false;
			}
		});

		// 初始化类型单选框
		RadioButton paymentRadioButton = (RadioButton)findViewById(R.id.paymentRadioButton);
		paymentRadioButton.setChecked(true);
		
		// 给按钮添加监听器
		Button addButton = (Button) findViewById(R.id.add2Button);
		addButton.setOnClickListener( new Button.OnClickListener(){
			public void onClick(View v) {

			}
		});
		
		Button addCloseButton = (Button) findViewById(R.id.addCloseButton);
		addCloseButton.setOnClickListener( new Button.OnClickListener(){
			public void onClick(View v) {
				dismiss();
			}
		});
		
		Button closeButton = (Button) findViewById(R.id.closeButton);
		closeButton.setOnClickListener( new Button.OnClickListener(){
			public void onClick(View v) {
				dismiss();
			}
		});

	}
	
	private BaseAdapter adapter = new BaseAdapter(){

		public int getCount() {
			return accountDrawableIds.length;
		}

		public Object getItem(int position) {
			return accountDrawableIds[position];
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			LinearLayout ll = new LinearLayout(mContext);
			ll.setOrientation(LinearLayout.HORIZONTAL);
			ImageView iv = new ImageView(mContext);
			iv.setImageResource(accountDrawableIds[position]);
			ll.addView(iv);
			TextView tv=new TextView(mContext);
			tv.setText(accountTextIds[position]);
			tv.setTextSize(18);
			tv.setTextColor(Color.BLACK);
			ll.addView(tv);
			return ll;
		}
	};
}
