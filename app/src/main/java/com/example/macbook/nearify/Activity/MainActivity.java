package com.example.macbook.nearify.Activity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.macbook.nearify.Fragments.AboutUs.AboutUsFragment;
import com.example.macbook.nearify.Fragments.Explore.ExploreFragment;
import com.example.macbook.nearify.Fragments.HotDeals.HotDealsFragment;
import com.example.macbook.nearify.Fragments.NotificationCenter.NotificationCenterFragment;
import com.example.macbook.nearify.Fragments.Profile.ProfileFragment;
import com.example.macbook.nearify.Fragments.Share.ShareFragment;
import com.example.macbook.nearify.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        setSupportActionBar(toolbar);

        // Navigation Drawer Layout
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Set Homepage Fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, new ExploreFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        Fragment fragment = null;
        Class fragmentClass = null;

        int id = item.getItemId();
        switch (id) {

            case R.id.nav_exp:
                fragmentClass = ExploreFragment.class;
                break;

            case R.id.nav_hd:
                fragmentClass = HotDealsFragment.class;
                break;

            case R.id.nav_nc:
                fragmentClass = NotificationCenterFragment.class;
                break;

            case R.id.nav_profile:
                fragmentClass = ProfileFragment.class;
                break;

            case R.id.nav_share:
                fragmentClass = ShareFragment.class;
                break;

            case R.id.nav_ru:
                rateUsPlayStore(getApplicationContext());
                break;

            case R.id.nav_au:
                fragmentClass = AboutUsFragment.class;
                break;

            default: break;
        }

        // Setup fragment with fragment class initialized
        try {

            fragment = (Fragment) fragmentClass.newInstance();

        } catch (Exception e) {
            // TODO: Handle exception
        }

        // Insert the fragment by replacing main content
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_content, fragment).commit();

        // Close the navigation drawer
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    /**
     * Function to navigate user to play store
     * @param context
     */
    private static void rateUsPlayStore(Context context) {

        //Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
        Uri uri = Uri.parse("market://details?id=com.application.zomato");
        Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            context.startActivity(myAppLinkToMarket);
        } catch (ActivityNotFoundException e) {

            try {

                Uri url = Uri.parse("https://play.google.com/store/apps/details?id=" + context.getPackageName());
                myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, url);
                context.startActivity(myAppLinkToMarket);

            } catch (ActivityNotFoundException ex) {

                // TODO: Handle error
            }
        }
    }
}
