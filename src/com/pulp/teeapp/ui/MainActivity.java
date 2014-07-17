package com.pulp.teeapp.ui;

import android.content.Context;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import android.view.Menu;
import android.view.MenuItem;

import com.pulp.teeapp.*;
import com.pulp.teeapp.controllers.ScreenPagerAdapter;
import com.pulp.teeapp.utils.ConstantsUtils;
import com.pulp.teeapp.utils.ConstantsUtils.CurrentScreenChoice;;


public class MainActivity extends ActionBarActivity  {

	private ViewPager cardSelector;
	public static  ScreenPagerAdapter mPagerAdapter;

	SharedPreferences preferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ConstantsUtils.CURRENT_CHOICE=CurrentScreenChoice.CHOOSE_COLOR;

		cardSelector = (ViewPager) findViewById(R.id.pager);
		mPagerAdapter = new ScreenPagerAdapter(getSupportFragmentManager());
		cardSelector.setAdapter(mPagerAdapter);
		mPagerAdapter.notifyDataSetChanged();
		
		
		

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.buttonLayout, new ButtonFragment()).commit();
		}

		preferences = this.getSharedPreferences("ScreenActive",
				Context.MODE_PRIVATE);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
