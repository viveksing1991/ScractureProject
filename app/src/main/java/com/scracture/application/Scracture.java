package com.scracture.application;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by root on 21/2/18.
 */

public class Scracture extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder().setFontAttrId(uk.co.chrisjenx.calligraphy.R.attr.fontPath).build());

    }
}
