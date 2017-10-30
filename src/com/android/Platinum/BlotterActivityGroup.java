package com.android.Platinum;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class BlotterActivityGroup extends ActivityGroup {
	LinearLayout mContainer;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blotter);

        mContainer = (LinearLayout)findViewById(R.id.blotterLinearLayout);
        mContainer.removeAllViews();

		Intent intent = new Intent(BlotterActivityGroup.this, WelcomeActivity.class); 
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		Window subActivity = getLocalActivityManager().startActivity("WelcomeActivity",intent);
		View view = subActivity.getDecorView();

		mContainer.addView( view );  

		LinearLayout.LayoutParams params = (LayoutParams)view.getLayoutParams();
		params.width=LayoutParams.FILL_PARENT;
		params.height=LayoutParams.FILL_PARENT;
		view.setLayoutParams(params);
	}
}
