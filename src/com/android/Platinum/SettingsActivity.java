package com.android.Platinum;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;   
import android.content.Intent;
import android.os.Bundle;   
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;   
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;


public class SettingsActivity extends Activity {
	ListView SettingsListView;
	TextView tvSettingsViewTitle;
	Intent intent;
 
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_view);  
        //tvSettingsViewTitle=(TextView)this.findViewById(R.id.SettingViewTitle);
        //tvSettingsViewTitle.setText(R.string.Settings_View_title);
        SettingsListView=(ListView)this.findViewById(R.id.SettingsListView);   
        ArrayList<HashMap<String, Object>> SettingsArrayList = new ArrayList<HashMap<String, Object>>();
        
        HashMap<String, Object> map = new HashMap<String, Object>();       
        map.put("ItemImage", R.drawable.icon); 
        map.put("ItemTitle", getString(R.string.Settings_Item_inc));  
        SettingsArrayList.add(map); 
        
        map = new HashMap<String, Object>(); 
        map.put("ItemImage", R.drawable.icon); 
        map.put("ItemTitle", getString(R.string.Settings_Item_exp));  
        SettingsArrayList.add(map); 
        
        map = new HashMap<String, Object>(); 
        map.put("ItemImage", R.drawable.icon); 
        map.put("ItemTitle", getString(R.string.Settings_Item_sys));  
        SettingsArrayList.add(map); 
        
        map = new HashMap<String, Object>(); 
        map.put("ItemImage", R.drawable.icon); 
        map.put("ItemTitle", getString(R.string.Settings_Item_remind));  
        SettingsArrayList.add(map); 
        
        SimpleAdapter saImageItems = new SimpleAdapter(this, 
        		SettingsArrayList,
                R.layout.settings_view_item,
                new String[]{"ItemImage","ItemTitle"},
                new int[]{R.id.SettingsItemImage,R.id.SettingsItemTitle});  
        
        SettingsListView.setAdapter(saImageItems);
        
        SettingsListView.setOnItemClickListener(new OnItemClickListener()
        {
        	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3)
        	{
        		HashMap<String,String> map=(HashMap<String,String>)SettingsListView.getItemAtPosition(arg2);
        		//String title = map.get("ItemTitle");     
        		//Toast.makeText(getApplicationContext(), "你选择了第"+arg2+"个Item，itemTitle的值是："+title,Toast.LENGTH_SHORT).show(); 
        		
        		switch (arg2)
          		{
          		case 0:       			
          			intent = new Intent(SettingsActivity.this,SettingsIncActivity.class);
          			startActivity(intent);
          			break;
          		case 1:
          			intent = new Intent(SettingsActivity.this,SettingsExpActivity.class);
          			startActivity(intent);
          			break;
          		}

        	}
        });

    }
    


}