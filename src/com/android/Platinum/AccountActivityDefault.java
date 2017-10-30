package com.android.Platinum;

import android.app.Activity;
import android.app.ActivityGroup;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import android.widget.TextView;

public class AccountActivityDefault extends Activity {
	TextView aTextView;
	ImageButton aAddButton;
	ImageButton aQuitButton;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_view_default);
            
        aAddButton = (ImageButton)findViewById(R.id.aAddButton);   
        aAddButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                ActivityGroup context = (ActivityGroup)getParent();
                AccountAddDialog accountAddDialog = new AccountAddDialog(AccountActivityDefault.this);
                accountAddDialog.show();
            }
        });
        
        aQuitButton = (ImageButton)findViewById(R.id.aQuitButton);
        aQuitButton.setOnClickListener(new Button.OnClickListener(){
        	public void onClick(View v){
        		AccountActivityDefault.this.finish();
        	}
        });
    }
}