package com.example.macbook.nearify.Fragments.Explore;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.macbook.nearify.R;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

public class ExploreFragment extends Fragment {

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private MaterialViewPager mViewPager;
    private Toolbar toolbar;
    private View rootView = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_explore, container, false);


        // Floating Action Button
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // TODO: Handle FAB click
            }
        });


        // Material View Pager
        mViewPager = (MaterialViewPager) rootView.findViewById(R.id.materialViewPager);

        toolbar = mViewPager.getToolbar();
        toolbar.setNavigationIcon(null);

        mViewPager.getPagerTitleStrip().setTextColor(getResources().getColor(R.color.white));
        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % 6) {
                    case 0:
                        return CafeFragment.newInstance();
                    case 1:
                        return CafeFragment.newInstance();
                    case 2:
                        return CafeFragment.newInstance();
                    case 3:
                        return CafeFragment.newInstance();
                    case 4:
                        return CafeFragment.newInstance();
                    case 5:
                        return CafeFragment.newInstance();
                    default:
                        return CafeFragment.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 6;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 6) {
                    case 0:
                        return "Cafes & Restaurants";
                    case 1:
                        return "ATM & Banks";
                    case 2:
                        return "Petrol Pumps";
                    case 3:
                        return "Shopping Malls";
                    case 4:
                        return "Departmental Stores";
                    case 5:
                        return "Electronic Shops";
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.colorPrimary,
                                "http://cdn1.tnwcdn.com/wp-content/blogs.dir/1/files/2014/06/wallpaper_51.jpg");
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.colorPrimary,
                                "https://fs01.androidpit.info/a/63/0e/android-l-wallpapers-630ea6-h900.jpg");
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.colorPrimary,
                                "http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg");
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.colorPrimary,
                                "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");

                    case 4:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.colorPrimary,
                                "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");

                    case 5:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.colorPrimary,
                                "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
                }

                return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());
        return rootView;
    }
}
