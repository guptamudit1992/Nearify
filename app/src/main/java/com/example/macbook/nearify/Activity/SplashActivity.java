package com.example.macbook.nearify.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.macbook.nearify.Commons.StaticConstants;
import com.example.macbook.nearify.R;
import com.skyfishjy.library.RippleBackground;

public class SplashActivity extends Activity {

    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Start Animation
        RippleBackground rippleBackground = (RippleBackground)findViewById(R.id.content);
        rippleBackground.startRippleAnimation();


        // Handler
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();

                // This method will be executed once the timer is over
                // Start your app on boarding activity
                Intent i = new Intent(SplashActivity.this, OnboardingActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }

        }, StaticConstants.SPLASH_SCREEN_TIMEOUT);
    }
}
