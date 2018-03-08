package com.scracture.controller.activities.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.scracture.R;
import com.scracture.common.Base;
import com.scracture.controller.activities.landing.LandingActivity;
import com.scracture.controller.activities.main.MainActivity;

public class LoginActivity extends Base {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvToolbar.setText(getResources().getString(R.string.txt_login));
        findViewById(R.id.btnLogin).setOnClickListener(new UserLoginListener());
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


    class UserLoginListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            startNewActivity(MainActivity.class);
        }
    }
}
