package com.pulp.teeapp.ui;

import android.content.Context;
import android.content.Intent;

import com.pulp.teeapp.utils.ConstantsUtils.CurrentScreenChoice;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.pulp.teeapp.*;
import com.pulp.teeapp.controllers.ScreenPagerAdapter;
import com.pulp.teeapp.utils.ConstantsUtils;

public class ButtonFragment extends Fragment implements OnClickListener {

	private Typeface icomoon;
	private TextView chooseColor;
	private TextView chooseDesign;
	private TextView chooseEffects;
	private TextView shareImage;
	private TextView chooseImage;
	private FragmentActivity mActivity;
	private Context mContext;
	ScreenPagerAdapter mPagerAdapter;
	
	

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mActivity = getActivity();
		mContext = getActivity().getBaseContext();

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater
				.inflate(R.layout.button_fragment, container, false);

		chooseColor = (TextView) view.findViewById(R.id.chooseColor);
		chooseDesign = (TextView) view.findViewById(R.id.chooseDesign);
		chooseEffects = (TextView) view.findViewById(R.id.chooseEffects);
		chooseImage = (TextView) view.findViewById(R.id.chooseImage);
		shareImage = (TextView) view.findViewById(R.id.shareImage);

		icomoon = Typeface.createFromAsset(mContext.getAssets(), "icomoon.ttf");
		chooseColor.setTypeface(icomoon);
		chooseDesign.setTypeface(icomoon);
		chooseImage.setTypeface(icomoon);
		chooseEffects.setTypeface(icomoon);
		shareImage.setTypeface(icomoon);
		chooseColor.setOnClickListener(this);
		chooseDesign.setOnClickListener(this);
		chooseEffects.setOnClickListener(this);

		
		
		
		final int ACTIVITY_SELECT_IMAGE = 1234;
		((TextView) view.findViewById(R.id.chooseImage))
        .setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Picture"), ACTIVITY_SELECT_IMAGE);
            }
        });
		

		return view;
	}

	
	
	
	@Override
	public void onClick(View v) {
		
		CurrentScreenChoice screenChoice = null;
		
		switch (v.getId()) {
		case R.id.chooseColor:
			Toast.makeText(mContext, "Choose Color", Toast.LENGTH_LONG).show();
			ConstantsUtils.CURRENT_CHOICE =screenChoice.CHOOSE_COLOR;
			MainActivity.mPagerAdapter.notifyDataSetChanged();
			break;

		case R.id.chooseDesign:
			Toast.makeText(mContext, "Choose Design", Toast.LENGTH_LONG).show();

			ConstantsUtils.CURRENT_CHOICE = screenChoice.CHOOSE_FRAME;
			MainActivity.mPagerAdapter.notifyDataSetChanged();
			break;
		case R.id.chooseEffects:

			Toast.makeText(mContext, "Choose Effects", Toast.LENGTH_LONG)
					.show();
			ConstantsUtils.CURRENT_CHOICE =screenChoice.CHOOSE_EFFECT;
			MainActivity.mPagerAdapter.notifyDataSetChanged();
			break;

		case R.id.chooseImage:

			Toast.makeText(mContext, "Choose Image", Toast.LENGTH_LONG)
					.show();
			ConstantsUtils.CURRENT_CHOICE =screenChoice.CHOOSE_IMAGE;
			MainActivity.mPagerAdapter.notifyDataSetChanged();

	        Intent i = new Intent(Intent.ACTION_PICK,
	                   android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
	        final int ACTIVITY_SELECT_IMAGE = 1234;
	        startActivityForResult(i, ACTIVITY_SELECT_IMAGE); 
			   
			break;
			
		case R.id.shareImage:

			Toast.makeText(mContext, "Share Image", Toast.LENGTH_LONG)
					.show();
			ConstantsUtils.CURRENT_CHOICE =screenChoice.CHOOSE_SHARE;
			MainActivity.mPagerAdapter.notifyDataSetChanged();
			break;
			
		}

	}

}
