package com.scracture.controller.activities.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.scracture.R;
import com.scracture.common.Base;

public class LoginActivity extends Base {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvToolbar.setText(getResources().getString(R.string.txt_login));
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
        return true;
    }
}
