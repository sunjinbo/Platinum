package com.android.Platinum;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.app.ActivityGroup;
import android.content.Intent;
import static com.android.Platinum.MenuValues.*;

public class WelcomeActivity extends Activity {
	private Toolbar mToolbar;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        
        mToolbar = (Toolbar)findViewById(R.id.welcomeToolbar);
        mToolbar.init(R.layout.welcome_toolbar);
        mToolbar.setTab1OnClickListener(new Button.OnClickListener(){
        	public void onClick(View v){
        		ActivityGroup context = (ActivityGroup)getParent();
        		AddDialog addDialog = new AddDialog(context);
        		addDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        		addDialog.show();
        	}
        });
        
        mToolbar.setTab2OnClickListener(new Button.OnClickListener(){
        	public void onClick(View v){
				LinearLayout container = (LinearLayout)((ActivityGroup)getParent())
								.getWindow()
								.findViewById(R.id.blotterLinearLayout);
				container.removeAllViews();
				Intent intent = new Intent(WelcomeActivity.this, BlotterActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				Window subActivity = ((ActivityGroup)WelcomeActivity.this.getParent())
								.getLocalActivityManager()
								.startActivity("BlotterActivity",intent);
				View view=subActivity.getDecorView();
				container.addView(view);
				LinearLayout.LayoutParams params = (LayoutParams)view.getLayoutParams();
				params.width = LayoutParams.FILL_PARENT;
				params.height = LayoutParams.FILL_PARENT;
				view.setLayoutParams(params);
        	}
        });
        
        mToolbar.setTab3OnClickListener(new Button.OnClickListener(){
        	public void onClick(View v){
        		WelcomeActivity.this.finish();
        	}
        });

    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		/*
		SubMenu subMenuAddBlotter = menu.addSubMenu( 
				MENU_GROUP_WELCOME, 
				MENU_ADD_BLOTTER, 
				0, 
				R.string.add_button
				);
		subMenuAddBlotter.setIcon(R.drawable.add);
		
		SubMenu subMenuExploreBlotter = menu.addSubMenu(
				MENU_GROUP_WELCOME, 
				MENU_EXPLORE_BLOTTER,
				0, 
				R.string.explore
				);
		subMenuExploreBlotter.setIcon(R.drawable.blotter);
		
		SubMenu subMenuQuitApplication = menu.addSubMenu(
				MENU_GROUP_WELCOME, 
				MENU_QUIT_APPLICATION,
				0, 
				R.string.quit
				);
		subMenuQuitApplication.setIcon(R.drawable.quit);
		*/
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem) {
		
		switch( menuItem.getItemId() ) {
			case MENU_ADD_BLOTTER:
			case MENU_EXPLORE_BLOTTER:
			case MENU_QUIT_APPLICATION:
				break;
		}
		return true;
	}
}