package com.pulp.teeapp.ui;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.view.CardView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teecard.R;

public class TeeTypeFirstFragment extends Fragment {
	private CardView cardView;
	int BlackTshirt;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.tee_first,
				container, false);
		

		if (getArguments() != null)

		{
			Bundle Tshirt = getArguments();
			

		Card card = new Card(getActivity());
		card.setBackgroundResourceId(Tshirt.getInt("mTshirt"));
		cardView = (CardView) rootView.findViewById(R.id.carddemo);
		cardView.setCard(card);
	}

		return rootView;
	}
}