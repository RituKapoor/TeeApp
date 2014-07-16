package com.pulp.teeapp.controllers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.teecard.R;
import com.pulp.teeapp.ui.TeeTypeFirstFragment;
import com.pulp.teeapp.utils.ConstantsUtils;

public class ScreenPagerAdapter extends FragmentStatePagerAdapter {

	public ScreenPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int index) {

		Bundle mTshirt = new Bundle();
		TeeTypeFirstFragment teeType = new TeeTypeFirstFragment();
		switch (index) {
		case 0:
			mTshirt.putInt("mTshirt", R.drawable.tshirtblack2);
			break;
		case 1:
			mTshirt.putInt("mTshirt", R.drawable.tshirtred2);
			break;
		case 2:
			mTshirt.putInt("mTshirt", R.drawable.tshirtblue2);
			break;
		case 3:
			mTshirt.putInt("mTshirt", R.drawable.tshirtwhite2);
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		default:
			break;
		}

		teeType.setArguments(mTshirt);
		return teeType;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return ConstantsUtils.NO_OF_FRAGMENTS;
	}

}
