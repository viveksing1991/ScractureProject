package com.scracture.controller.activities.signup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.scracture.R;
import com.scracture.common.Base;

public class SignUpActiivity extends Base {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_actiivity);
        tvToolbar.setText(getResources().getString(R.string.txt_signup));
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


}
