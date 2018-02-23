package com.scracture.controller.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.scracture.R;
import com.scracture.utils.CustomNumberPicker;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {
    NumberPicker timeInHour;
    NumberPicker timeInMin ;
    NumberPicker timeFormat ;
    private AlertDialog customTimeDialog;
    final String[] values= {"AM","PM"};
    String[] time={"01","02","03","04","05","06","07","08","09","10","11","12"};
    /* String[] minute ={"00","01","02","03","04","05","06","07","08","09","10","11","12",
             "13","14","15","16","17","18","19","20" ,"21","22","23","24","25","26","27","28","29","30","31",
             "32","33","34","35","36","37","38",
             "39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59"};
   */
    String[] minute ={"00","15","30","45"};

    private TextView tv;
    private int mTimeInHour;
    private int mTimeInMin;
    private int mTimeFormat;

    public InfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_info, container, false);
        tv= (TextView) view.findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //timePickerCustomDialog();
                CustomNumberPicker customNumberPicker=new CustomNumberPicker(getContext());
                customNumberPicker.setValueInPicker(2,12,2);
                customNumberPicker.setOnScoreSavedListener(new CustomNumberPicker.PickerValue() {
                    @Override
                    public String selectedvalue(String selectedValue) {
                        Toast.makeText(getContext(),selectedValue,Toast.LENGTH_SHORT).show();
                        return null;
                    }
                });
            }
        });
        return view;
    }

}
