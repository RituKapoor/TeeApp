package com.pulp.teeapp.controllers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.pulp.teeapp.*;
import com.pulp.teeapp.ui.TeeTypeFragment;
import com.pulp.teeapp.utils.ConstantsUtils;
import com.pulp.teeapp.utils.ConstantsUtils.CurrentScreenChoice;

public class ScreenPagerAdapter extends FragmentStatePagerAdapter {

	public ScreenPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int index) {

		Bundle mTshirt = new Bundle();
		TeeTypeFragment teeType = new TeeTypeFragment();
		
		switch (index) 
		{
		case 0: // TShirt in 1st Fragment
			mTshirt.putInt("mTshirt", R.drawable.tshirtred);
			break;
		case 1:  // TShirt in 2nd Fragment
			mTshirt.putInt("mTshirt", R.drawable.tshirtblack);
			break;
		case 2: // TShirt in 3rd Fragment
			mTshirt.putInt("mTshirt", R.drawable.tshirtblue);
			break;
		case 3: // TShirt in 4th Fragment
			mTshirt.putInt("mTshirt", R.drawable.tshirtwhite);
			break;
		case 4: // TShirt in 5th Fragment
			mTshirt.putInt("mTshirt", R.drawable.tshirtblack);
			break;
		case 5: // TShirt in 6th Fragment
			mTshirt.putInt("mTshirt", R.drawable.tshirtblack);
			break;
		default:
			mTshirt.putInt("mTshirt", R.drawable.tshirtred);
			break;
		}

		teeType.setArguments(mTshirt);
		return teeType;

	}

	@Override
	public int getCount() {
		
		// This API returns the number of fragments to be created based on the Button clicked.	
		switch (ConstantsUtils.CURRENT_CHOICE)
		{		
		case CHOOSE_COLOR:
			return ConstantsUtils.TSHIRTS_COLORS_CNT;
		case CHOOSE_FRAME:
			return ConstantsUtils.NO_OF_FRAMES;
		case CHOOSE_IMAGE:
			return 1;
			
		case CHOOSE_EFFECT:
			return ConstantsUtils.NO_OF_EFFECTS;
		default:
			notifyDataSetChanged();
			return 1;
		}
	}
	
	

}
