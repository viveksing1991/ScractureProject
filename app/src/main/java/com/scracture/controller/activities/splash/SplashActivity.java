package com.scracture.controller.activities.splash;

import android.os.Bundle;

import com.scracture.controller.activities.categories.CategoryActivity;
import com.scracture.controller.activities.landing.LandingActivity;
import com.scracture.controller.activities.main.MainActivity;
import com.scracture.R;
import com.scracture.common.Base;
import com.scracture.constant.AppConstant;

import android.os.Handler;

public class SplashActivity extends Base {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        waitForFewSecond();
    }

    /**
     * Method is used for waiting  few second to start Main App
     */
    private void waitForFewSecond() {
        new Handler().postDelayed(new SplashRunnable(), AppConstant.SPLASH_TIMER_WAIT);
    }

    @Override
    protected boolean isValidData() {
        return false;
    }

    @Override
    protected void setViewListener() {

    }

    @Override
    protected void setViewReferences() {

    }

    /**
     * Class is used as a seperate thread  for waiting few seconds
     */
    class SplashRunnable implements Runnable {
        @Override
        public void run() {
            startNewActivity(CategoryActivity.class);
          //  startNewActivity(MainActivity.class);
            finish();
        }
    }

    @Override
    protected boolean useToolbar() {
        return false;
    }
}
