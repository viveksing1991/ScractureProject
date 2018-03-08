package com.scracture.controller.activities.details;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.scracture.R;
import com.scracture.view.customprogress.CustomProgressDialog;

public class DetailsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView rvItems;
    private TextView tvDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setViewReferences();
        setViewListener();
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


    protected boolean isValidData() {
        return false;
    }

    protected void setViewListener() {

    }

    protected void setViewReferences() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvDetails= (TextView) findViewById(R.id.tvDetails);
    }

}
