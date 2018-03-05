package com.scracture.controller.activities.landing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.scracture.R;
import com.scracture.common.Base;

public class LandingActivity extends Base {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
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

    @Override
    protected boolean useToolbar() {
        return false;
    }
}
