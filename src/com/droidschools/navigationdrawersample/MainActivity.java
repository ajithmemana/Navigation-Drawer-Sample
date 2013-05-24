package com.droidschools.navigationdrawersample;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {
	ListView drawerListView;
    public static final String ARG_PHONE_INDEX = "phone_index";


	String[] listItems = {
			"Nokia Lumia 920",
			"iPhone 5s",
			"Nokia Lumia 925",
			"Xperia Z",
			"HTC One"
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		drawerListView = (ListView) findViewById(R.id.left_drawer);
		drawerListView.setAdapter(new ArrayAdapter<String>(getBaseContext(), R.layout.listview_layout_cell,listItems));
		drawerListView.setDividerHeight(2);
		drawerListView.setOnItemClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		Toast.makeText(getBaseContext(), "Clicked " + position, 0).show();
		Fragment deviceDetailFragment = new DeviceDetailFragment();
		Bundle argumentsPassed = new Bundle();
		argumentsPassed.putInt(ARG_PHONE_INDEX, position);
		deviceDetailFragment.setArguments(argumentsPassed);
		FragmentManager  fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, deviceDetailFragment).commit();


	}

}
