package com.pulp.teeapp.ui;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.view.CardView;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.teecard.R;

public class TeeTypeFragment extends Fragment {
	private CardView cardView;
	int BlackTshirt;
	private FragmentActivity mActivity;
	private Context mContext;

	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mActivity = getActivity();
		mContext = getActivity().getBaseContext();
	}

	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.tee_first,
				container, false);
	
		TypedValue tv = new TypedValue();
		mContext.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true);
		int actionBarHeight = getResources().getDimensionPixelSize(tv.resourceId);

		WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		int height = size.y;
		

		if (getArguments() != null)

		{
			Bundle Tshirt = getArguments();
		Card card = new Card(getActivity());
		card.setBackgroundResourceId(Tshirt.getInt("mTshirt"));
		cardView = (CardView) rootView.findViewById(R.id.carddemo);
		cardView.setCard(card);
	}
if(width>height){
		android.view.ViewGroup.LayoutParams params=  cardView.getLayoutParams();
		params.height=(int) height;
		params.width= (int) ((height/1.340));
		Log.e("params landscape",""+ params.height+params.width);
}else{
	android.view.ViewGroup.LayoutParams params=  cardView.getLayoutParams();
	params.height=(int) (width*1.340);
	params.width= (int) width;
	Log.e("params potrait",""+ params.height+params.width);
}
		return rootView;
	}
}