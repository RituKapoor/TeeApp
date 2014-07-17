package com.pulp.teeapp.controllers;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.pulp.teeapp.ui.MainActivity;
import com.example.teecard.R;
import com.pulp.teeapp.ui.TeeTypeFragment;
import com.pulp.teeapp.utils.ConstantsUtils;

public class ScreenPagerAdapter extends FragmentStatePagerAdapter {

	public ScreenPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int index) {

		Bundle mTshirt = new Bundle();
		TeeTypeFragment teeType = new TeeTypeFragment();
		switch (index) {
		case 0:
			mTshirt.putInt("mTshirt", R.drawable.tshirtblack3);
			break;
		case 1:
			mTshirt.putInt("mTshirt", R.drawable.tshirtred3);
			break;
		case 2:
			mTshirt.putInt("mTshirt", R.drawable.tshirtblue3);
			break;
		case 3:
			mTshirt.putInt("mTshirt", R.drawable.tshirtwhite3);
			break;
		case 4:
			mTshirt.putInt("mTshirt", R.drawable.tshirtwhite3);
			break;
		case 5:
			mTshirt.putInt("mTshirt", R.drawable.tshirtwhite3);
			break;
		default:
			mTshirt.putInt("mTshirt", R.drawable.tshirtwhite3);
			break;
		}

		teeType.setArguments(mTshirt);
		return teeType;

	}

	@Override
	public int getCount() {
		switch (ConstantsUtils.CURRENT_FRAGMENT) {
		case 0:

			return ConstantsUtils.NO_OF_TSHIRTS;
		case 1:

			return ConstantsUtils.NO_OF_FRAGMENTS;

		case 2:
		

			return ConstantsUtils.NO_OF_FRAGMENTS;
		default:
			notifyDataSetChanged();
			return ConstantsUtils.NO_OF_FRAGMENTS;
		}
	}
}