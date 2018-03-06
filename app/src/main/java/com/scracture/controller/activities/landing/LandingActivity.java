package com.scracture.controller.activities.landing;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.scracture.R;
import com.scracture.common.Base;
import com.scracture.controller.activities.login.LoginActivity;
import com.scracture.controller.activities.signup.SignUpActiivity;

public class LandingActivity extends Base {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        findViewById(R.id.btnSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSignIn();
            }
        });
        findViewById(R.id.btnSignUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSignUp();
            }
        });
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


    public  void onClickSignIn(){
     //   Toast.makeText(this,"dfmvnfd,",Toast.LENGTH_SHORT).show();
        startNewActivity(LoginActivity.class);
    }
    public  void onClickSignUp(){

      //  Toast.makeText(this,"signup",Toast.LENGTH_SHORT).show();
        startNewActivity(SignUpActiivity.class);
    }

    @Override
    protected boolean useToolbar() {
        return false;
    }
}
