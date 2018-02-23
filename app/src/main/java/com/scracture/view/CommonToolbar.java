package com.scracture.view;

import android.databinding.DataBindingUtil;
import android.databinding.adapters.ToolbarBindingAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scracture.R;

/**
 * Created by root on 21/2/18.
 */

public class CommonToolbar extends AppCompatActivity implements AppCompatCallback{
    protected Toolbar topToolBar;
    protected TextView tvToolbar;

    @Override
    public void setContentView(int layoutResID)
    {
        LinearLayout fullView = (LinearLayout) getLayoutInflater().inflate(R.layout.common_toolbar, null);
        FrameLayout activityContainer = (FrameLayout) fullView.findViewById(R.id.activity_content);
        tvToolbar= (TextView) fullView.findViewById(R.id.tvToolbar);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);
       // commonToolbarBinding= DataBindingUtil.setContentView(this,R.layout.common_toolbar);
         super.setContentView(fullView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (useToolbar())
        {
            setSupportActionBar(toolbar);

        }
        else
        {
            toolbar.setVisibility(View.GONE);
        }

    }
    protected boolean useToolbar()
    {
        return true;
    }

    public void  setToolBarText(int logo,String text){
        topToolBar.setLogo(logo);
        topToolBar.setLogoDescription(text);
    }

    public void toolbarVisibility(int visibility){
        topToolBar.setVisibility(visibility);
    }
    public void toolbarSetTitle(String title){
        setTitle(title);
        tvToolbar.setText(title);
    }


}
