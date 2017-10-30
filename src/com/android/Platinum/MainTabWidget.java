package com.android.Platinum;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost;

public class MainTabWidget extends TabActivity  {
    /** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);

	    Resources res = getResources(); // Resource object to get Drawables
	    TabHost tabHost = getTabHost();  // The activity TabHost
	    TabHost.TabSpec spec;  // Reusable TabSpec for each tab
	    Intent intent;  // Reusable Intent for each tab

	    // Create an Intent to launch an Activity for the tab (to be reused)
	    // Initialize a TabSpec for each tab and add it to the TabHost

	    //intent = new Intent().setClass(this, BlotterActivityGroup.class);
	    intent = new Intent().setClass(this, BlotterActivityGroup.class);
	    spec = tabHost.newTabSpec("Blotter").setIndicator("Blotter",
	                      res.getDrawable(R.drawable.ic_tab_blotter))
	                  .setContent(intent);
	    tabHost.addTab(spec);

	    intent = new Intent().setClass(this, AccountActivityDefault.class);
	    spec = tabHost.newTabSpec("Account").setIndicator("Account",
	                      res.getDrawable(R.drawable.ic_tab_account))
	                  .setContent(intent);
	    tabHost.addTab(spec);

	    intent = new Intent().setClass(this, ReportActivity.class);
	    spec = tabHost.newTabSpec("Report").setIndicator("Report",
	                      res.getDrawable(R.drawable.ic_tab_report))
	                  .setContent(intent);
	    tabHost.addTab(spec);

	    intent = new Intent().setClass(this, SettingsActivity.class);
	    spec = tabHost.newTabSpec("Settings").setIndicator("Settings",
	                      res.getDrawable(R.drawable.ic_tab_settings))
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    
	    tabHost.setCurrentTab(0);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		this.getLocalActivityManager().getCurrentActivity().onCreateOptionsMenu(menu);
//	    if (getParent() != null) 
//	    {
//	        return getParent().onCreateOptionsMenu(menu);
//	    }
	    return true;
	}
}