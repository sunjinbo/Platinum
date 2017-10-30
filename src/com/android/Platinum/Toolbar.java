package com.android.Platinum;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Toolbar extends LinearLayout {
	private TextView mTab1;
	private TextView mTab2;
	private TextView mTab3;
	private Context mContext;
	public Toolbar(final Context context) {
		super(context);
		
		mContext = context;
	}
	
	public Toolbar(final Context con, AttributeSet attrs) {
		super(con,attrs);
		
		mContext = con;
		
		setOrientation(HORIZONTAL);
		setBackgroundColor(getResources().
				getColor(android.R.color.white));
	}
	
	public void init(int resource){
		LayoutInflater inflater = (LayoutInflater) 
		mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(resource, this);
		
		mTab1 = (TextView) findViewById(R.id.tab1);
		mTab2 = (TextView) findViewById(R.id.tab2);
		mTab3 = (TextView) findViewById(R.id.tab3);
	}
	
	public void setTab1OnClickListener( View.OnClickListener l ){
		mTab1.setOnClickListener( l );
	}
	
	public void setTab2OnClickListener( View.OnClickListener l ){
		mTab2.setOnClickListener( l );
	}
	
	public void setTab3OnClickListener( View.OnClickListener l ){
		mTab3.setOnClickListener( l );
	}
}
