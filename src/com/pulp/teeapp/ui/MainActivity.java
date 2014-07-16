package com.pulp.teeapp.ui;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.teecard.R;
import com.pulp.teeapp.controllers.ScreenPagerAdapter;

public class MainActivity extends ActionBarActivity {

	private ViewPager cardSelector;
	private ScreenPagerAdapter mPagerAdapter;
	private Typeface icomoon;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		cardSelector = (ViewPager) findViewById(R.id.pager);
		mPagerAdapter = new ScreenPagerAdapter(getSupportFragmentManager());
		cardSelector.setAdapter(mPagerAdapter);
		
		TextView chooseColor=(TextView) findViewById(R.id.chooseColor);
		TextView chooseDesign=(TextView) findViewById(R.id.chooseDesign);
		TextView chooseImage=(TextView) findViewById(R.id.chooseImage);
		TextView chooseEffects=(TextView) findViewById(R.id.chooseEffects);
		TextView shareImage=(TextView) findViewById(R.id.shareImage);
		icomoon  = Typeface.createFromAsset(this.getAssets(), "icomoon.ttf");
		chooseColor.setTypeface(icomoon);
		chooseDesign.setTypeface(icomoon);
		chooseImage.setTypeface(icomoon);
		chooseEffects.setTypeface(icomoon);
		shareImage.setTypeface(icomoon);
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
