package com.droidschools.navigationdrawersample;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener, DrawerListener, OnClickListener {
	ListView drawerListView;
	DrawerLayout drawerLayout;
	ActionBarDrawerToggle drawerToggle;

	public static final String ARG_PHONE_INDEX = "phone_index";
	String[] listItems = { "Nokia Lumia 920", "iPhone 5s", "Nokia Lumia 925", "Xperia Z", "HTC One" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		switchFragment(0);
		// Init views
		drawerListView = (ListView) findViewById(R.id.left_drawer);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_drawer, R.string.open, R.string.close);

		// List view
		drawerListView.setAdapter(new ArrayAdapter<String>(getBaseContext(), R.layout.listview_layout_cell, listItems));
		drawerListView.setDividerHeight(2);
		drawerListView.setOnItemClickListener(this);
		// Set drawer listener
		drawerLayout.setDrawerListener(drawerToggle);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		switchFragment(0);

	}

	// Listview listener
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		switchFragment(position);
	}

	public void switchFragment(int position) {
		Fragment deviceDetailFragment = new DeviceDetailFragment();
		Bundle argumentsPassed = new Bundle();
		argumentsPassed.putInt(ARG_PHONE_INDEX, position);
		deviceDetailFragment.setArguments(argumentsPassed);
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.content_frame, deviceDetailFragment).commit();

	}

	@Override
	public void onDrawerClosed(View arg0) {
		// TODO Auto-generated method stub
		showToast("Closed");

	}

	@Override
	public void onDrawerOpened(View arg0) {
		// TODO Auto-generated method stub
		showToast("Opened");

	}

	@Override
	public void onDrawerSlide(View arg0, float arg1) {
		// TODO Auto-generated method stub
		showToast("Slide");

	}

	@Override
	public void onDrawerStateChanged(int arg0) {
		// TODO Auto-generated method stub
		showToast("State changed");

	}

	public void showToast(String message) {
		Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		showToast("Clicked");

	}
	
	/**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        drawerToggle.onConfigurationChanged(newConfig);
    }

}
