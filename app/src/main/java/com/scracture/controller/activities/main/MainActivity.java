package com.scracture.controller.activities.main;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.scracture.R;
import com.scracture.common.Base;
import com.scracture.controller.fragment.HomeFragment;
import com.scracture.controller.fragment.InfoFragment;
import com.scracture.controller.fragment.NotificationFragment;
import com.scracture.controller.fragment.OtherFragment;
import com.scracture.utils.BottomNavigationViewHelper;

public class MainActivity extends Base {
    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViewReferences();
        setViewListener();
        showFragmentManually();
        disableBottomNavigationShiftMode();
    }

    private void disableBottomNavigationShiftMode() {
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
    }

    @Override
    protected boolean isValidData() {
        return false;
    }

    @Override
    protected void setViewListener() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new NavigatenItem());
    }

    @Override
    protected void setViewReferences() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
    }

    class NavigatenItem implements BottomNavigationView.OnNavigationItemSelectedListener {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.action_home:
                    if(homeFragment!=null)
                        selectedFragment = homeFragment;
                    else
                        selectedFragment=new HomeFragment();
                    setTextOnToolbar("Home");
                    break;
                case R.id.action_info:
                    selectedFragment = new InfoFragment();
                    setTextOnToolbar("Info");
                    break;
                case R.id.action_notification:
                    selectedFragment = new NotificationFragment();
                    setTextOnToolbar("Notifications");
                    break;
                case R.id.action_others:
                    selectedFragment = OtherFragment.newInstance("", "");
                    setTextOnToolbar("Others");
                    break;
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frag_container, selectedFragment);
            transaction.commit();
            return true;
        }
    }

    private void setTextOnToolbar(String text) {
        tvToolbar.setText(text);
    }

    private void showFragmentManually() {
        //Manually displaying the first fragment - one time only
        if(homeFragment==null)
            homeFragment=  new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frag_container,homeFragment );
        transaction.commit();
        setTextOnToolbar("Home");
    }


}
