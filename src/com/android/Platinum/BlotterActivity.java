package com.android.Platinum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ActivityGroup;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;

public class BlotterActivity extends Activity {
    private Toolbar mToolbar;
    private ListView mListView;
    private List<Map<String, Object>> mListViewData;

    private final int CONTEXT_MENU_ID = 1;
    private final int MENU_ITEM_EDIT_ACTION = 1;
    private final int MENU_ITEM_DELETE_ACTION = 2;

    private IconContextMenu mIconContextMenu;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blotter);
        
        Resources res = getResources();
        
        mListView = (ListView) findViewById(R.id.blotterListView);
        mListViewData = getData();
        BlotterListViewAdapter adapter = new BlotterListViewAdapter(this);
        mListView.setAdapter(adapter);
        mListView.setOnItemLongClickListener(itemLongClickHandler);
        
        ActivityGroup context = (ActivityGroup)getParent();
        mIconContextMenu = new IconContextMenu(context, CONTEXT_MENU_ID);
        mIconContextMenu.addItem(res, "Edit", R.drawable.ic_icon_context_menu_edit, MENU_ITEM_EDIT_ACTION);
        mIconContextMenu.addItem(res, "Delete", R.drawable.ic_icon_context_menu_delete, MENU_ITEM_DELETE_ACTION);
        mIconContextMenu.setOnClickListener(new IconContextMenu.IconContextMenuOnClickListener() {
            public void onClick(int menuId) {
                switch(menuId) {
                    case MENU_ITEM_EDIT_ACTION:
                        break;
                    case MENU_ITEM_DELETE_ACTION:
                        break;
                    default:
                        break;
                }
            }
        });

        mToolbar = (Toolbar) findViewById(R.id.welcomeToolbar);
        mToolbar.init(R.layout.blotter_toolbar);
        mToolbar.setTab1OnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
        		ActivityGroup context = (ActivityGroup)getParent();
        		FilterDialog filterDialog = new FilterDialog(context);
        		filterDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        		filterDialog.show();
            }
        });

        mToolbar.setTab2OnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                LinearLayout container = (LinearLayout) ((ActivityGroup) getParent())
                        .getWindow().findViewById(R.id.blotterLinearLayout);
                container.removeAllViews();
                Intent intent = new Intent(BlotterActivity.this,
                        AccountBlotterActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Window subActivity = ((ActivityGroup) BlotterActivity.this
                        .getParent()).getLocalActivityManager().startActivity(
                        "AccountBlotterActivity", intent);
                View view = subActivity.getDecorView();
                container.addView(view);
                LinearLayout.LayoutParams params = (LayoutParams) view
                        .getLayoutParams();
                params.width = LayoutParams.FILL_PARENT;
                params.height = LayoutParams.FILL_PARENT;
                view.setLayoutParams(params);
            }
        });

        mToolbar.setTab3OnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                LinearLayout container = (LinearLayout) ((ActivityGroup) getParent())
                        .getWindow().findViewById(R.id.blotterLinearLayout);
                container.removeAllViews();
                Intent intent = new Intent(BlotterActivity.this,
                        WelcomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Window subActivity = ((ActivityGroup) BlotterActivity.this
                        .getParent()).getLocalActivityManager().startActivity(
                        "WelcomeActivity", intent);
                View view = subActivity.getDecorView();
                container.addView(view);
                LinearLayout.LayoutParams params = (LayoutParams) view
                        .getLayoutParams();
                params.width = LayoutParams.FILL_PARENT;
                params.height = LayoutParams.FILL_PARENT;
                view.setLayoutParams(params);
            }
        });
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("decorateImageView", R.drawable.ic_blotter_list_item_decorate_payment);
        map.put("typeImageView", R.drawable.ic_blotter_list_item_payment);
        map.put("categoryTextView", "Transportation card");
        map.put("dateTextView", "06/14/2011");
        map.put("mountTextView", "-50.0 RMB");
        list.add(map);

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("decorateImageView", R.drawable.ic_blotter_list_item_decorate_payment);
        map2.put("typeImageView", R.drawable.ic_blotter_list_item_payment);
        map2.put("categoryTextView", "Vegetables");
        map2.put("dateTextView", "06/14/2011");
        map2.put("mountTextView", "-32.0 RMB");
        list.add(map2);
        
        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("decorateImageView", R.drawable.ic_blotter_list_item_decorate_deposit);
        map3.put("typeImageView", R.drawable.ic_blotter_list_item_deposit);
        map3.put("categoryTextView", "Salary");
        map3.put("dateTextView", "06/15/2011");
        map3.put("mountTextView", "+2000.0 RMB");
        list.add(map3);
        
        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("decorateImageView", R.drawable.ic_blotter_list_item_decorate_payment);
        map4.put("typeImageView", R.drawable.ic_blotter_list_item_payment);
        map4.put("categoryTextView", "Meals");
        map4.put("dateTextView", "06/15/2011");
        map4.put("mountTextView", "-26.0 RMB");
        list.add(map4);
        
        Map<String, Object> map5 = new HashMap<String, Object>();
        map5.put("decorateImageView", R.drawable.ic_blotter_list_item_decorate_deposit);
        map5.put("typeImageView", R.drawable.ic_blotter_list_item_deposit);
        map5.put("categoryTextView", "Allowances");
        map5.put("dateTextView", "06/15/2011");
        map5.put("mountTextView", "+60.0 RMB");
        list.add(map5);
        
        Map<String, Object> map6 = new HashMap<String, Object>();
        map6.put("decorateImageView", R.drawable.ic_blotter_list_item_decorate_payment);
        map6.put("typeImageView", R.drawable.ic_blotter_list_item_payment);
        map6.put("categoryTextView", "Meals");
        map6.put("dateTextView", "06/16/2011");
        map6.put("mountTextView", "-29.0 RMB");
        list.add(map6);
        
        Map<String, Object> map7 = new HashMap<String, Object>();
        map7.put("decorateImageView", R.drawable.ic_blotter_list_item_decorate_payment);
        map7.put("typeImageView", R.drawable.ic_blotter_list_item_payment);
        map7.put("categoryTextView", "Cosmetic");
        map7.put("dateTextView", "06/17/2011");
        map7.put("mountTextView", "-122.0 RMB");
        list.add(map7);
        
        Map<String, Object> map8 = new HashMap<String, Object>();
        map8.put("decorateImageView", R.drawable.ic_blotter_list_item_decorate_deposit);
        map8.put("typeImageView", R.drawable.ic_blotter_list_item_deposit);
        map8.put("categoryTextView", "Bonus");
        map8.put("dateTextView", "06/17/2011");
        map8.put("mountTextView", "500.0 RMB");
        list.add(map8);
        
        Map<String, Object> map9 = new HashMap<String, Object>();
        map9.put("decorateImageView", R.drawable.ic_blotter_list_item_decorate_payment);
        map9.put("typeImageView", R.drawable.ic_blotter_list_item_payment);
        map9.put("categoryTextView", "House rent");
        map9.put("dateTextView", "06/17/2011");
        map9.put("mountTextView", "-200.0 RMB");
        list.add(map9);
        
        return list;
    }

    private OnItemLongClickListener itemLongClickHandler = new OnItemLongClickListener() {

        public boolean onItemLongClick(AdapterView<?> parent, View view,
                int position, long id) {
        	try{
        		showDialog(CONTEXT_MENU_ID);
        	}catch(Exception e){
        		e.getStackTrace();
        	}

            return true;
        }
    };
    
    protected Dialog onCreateDialog(int id) {
    	if (id == CONTEXT_MENU_ID) {
            return mIconContextMenu.createMenu();
        }
        return super.onCreateDialog(id);
    }

    /* Inner class */
    public class BlotterListViewAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public BlotterListViewAdapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        public int getCount() {
            return mListViewData.size();
        }

        public Object getItem(int arg0) {
            return null;
        }

        public long getItemId(int arg0) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.blotter_list_item,
                        null);
                holder.mDecorateImageView = (ImageView) convertView
                        .findViewById(R.id.decorateImageView);
                holder.mTypeImageView = (ImageView) convertView
                        .findViewById(R.id.typeImageView);
                holder.mCategoryTextView = (TextView) convertView
                        .findViewById(R.id.categoryTextView);
                holder.mDateTextView = (TextView) convertView
                        .findViewById(R.id.dateTextView);
                holder.mMountTextView = (TextView) convertView
                        .findViewById(R.id.amountTextView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.mDecorateImageView
                    .setBackgroundResource((Integer) mListViewData
                            .get(position).get("decorateImageView"));
            holder.mTypeImageView.setBackgroundResource((Integer) mListViewData
                    .get(position).get("typeImageView"));
            holder.mCategoryTextView.setText((String) mListViewData.get(
                    position).get("categoryTextView"));
            holder.mDateTextView.setText((String) mListViewData.get(position)
                    .get("dateTextView"));
            holder.mMountTextView.setText((String) mListViewData.get(position)
                    .get("mountTextView"));

            return convertView;
        }

    }

    public final class ViewHolder {
        public ImageView mDecorateImageView;
        public ImageView mTypeImageView;
        public TextView mCategoryTextView;
        public TextView mDateTextView;
        public TextView mMountTextView;
    }
}
