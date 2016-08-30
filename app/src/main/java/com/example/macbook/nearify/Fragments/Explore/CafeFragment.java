package com.example.macbook.nearify.Fragments.Explore;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.macbook.nearify.Activity.DetailActivity;
import com.example.macbook.nearify.R;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;

public class CafeFragment extends Fragment {

    private ObservableScrollView scrollView;

    private View view;
    private CardView dataCard;

    public static CafeFragment newInstance() {
        return new CafeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_cafe, container, false);
        dataCard = (CardView) view.findViewById(R.id.data_card);
        dataCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Navigate to Detail Activity
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                startActivity(intent);

            }
        });

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        scrollView = (ObservableScrollView) view.findViewById(R.id.scrollView);

        MaterialViewPagerHelper.registerScrollView(getActivity(), scrollView, null);
    }
}
