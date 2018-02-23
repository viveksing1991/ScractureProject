package com.scracture.utils;

import android.app.ActionBar;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import com.scracture.R;

/**
 * Created by root on 23/2/18.
 */

public class CustomNumberPicker {


    private final Context mContext;
    private AlertDialog customTimeDialog;
    PickerValue pickerValue;
    private int mTimeInHour;
    private int mTimeInMin;
    private int mTimeFormat;

    NumberPicker timeInHour;
    NumberPicker timeInMin ;
    NumberPicker timeFormat ;

    final String[] values= {"AM","PM"};
    String[] time={"01","02","03","04","05","06","07","08","09","10","11","12"};
    String[] minute ={"00","15","30","45"};


    public   CustomNumberPicker(Context context){
        this.mContext=context;
        //pickerValue= (PickerValue) context;
        openCustomDialog();
    }

    private void openCustomDialog() {
        LayoutInflater factory = LayoutInflater.from(mContext);
        final View timePickerView = factory.inflate(R.layout.time_picker_dialog, null);
        if (customTimeDialog != null && customTimeDialog.isShowing()) {
            return;
        }
        customTimeDialog = new AlertDialog.Builder(mContext).create();
        customTimeDialog.setView(timePickerView);
        setCustomTimePickerDialogReference(timePickerView);
        setValuesinTimePicker();
        getValueFromTimePicker();
        customTimeDialog.show();
    }


    /** Method  is used to set the references on custom timepicker dialog
     * @param timePickerView View of dialog
     */
    private void setCustomTimePickerDialogReference(View timePickerView) {
        timeInHour = (NumberPicker) timePickerView.findViewById(R.id.timeInHour);
        timeInMin=(NumberPicker) timePickerView.findViewById(R.id.timeInMin);
        timeFormat  = (NumberPicker)timePickerView.findViewById(R.id.timeFormat);
        Button customTimePickerDone = (Button) timePickerView.findViewById(R.id.customTimePickerDone);
        Button customTimePickerCancel = (Button) timePickerView.findViewById(R.id.customTimePickerCancel);
        setCustomViewListeners(customTimePickerDone,customTimePickerCancel);
    }

    private void setCustomViewListeners(Button customTimePickerDone, Button customTimePickerCancel) {

        customTimePickerDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customTimeDialog.dismiss();
                pickerValue.selectedvalue(mTimeInHour+":"+mTimeInMin+":"+mTimeFormat);
                //     time.setText(pickTime.timeInHour+":"+pickTime.timeInMin+":"+pickTime.timeFormat);

            }
        });
        customTimePickerCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customTimeDialog.dismiss();
            }
        });

    }

    /**
     * Method is used to set the  default values on custom time picker
     */
    private void setValuesinTimePicker() {
        timeFormat.setMinValue(0);
        timeFormat.setMaxValue(values.length-1);
        timeFormat.setDisplayedValues(values);
        timeInMin.setMinValue(0);
        timeInMin.setMaxValue(minute.length-1);
        timeInMin.setDisplayedValues(minute);
        timeInMin.setWrapSelectorWheel(true);
        timeFormat.setWrapSelectorWheel(true);
        timeInHour.setMinValue(1);
        timeInHour.setMaxValue(12);
        timeInHour.setDisplayedValues(time);
        timeInHour.setWrapSelectorWheel(true);

    }


    private void getValueFromTimePicker() {

        timeInHour.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                mTimeInHour=newVal;
            }
        });

        timeInMin.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                mTimeInMin=newVal;
            }
        });

        timeFormat.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                mTimeFormat=newVal;
            }
        });

        //   timeArrayList.add(pickTime);

    }


    public interface PickerValue {
        String selectedvalue(String selectedValue);

    }

    // ALLOWS YOU TO SET LISTENER && INVOKE THE OVERIDING METHOD
    // FROM WITHIN ACTIVITY
    public void setOnScoreSavedListener(PickerValue listener) {
        pickerValue = listener;
    }

    /*This Method is used to set the time interval of 15 minutes*/
    public static int setSelectedValue(int minute) {
        switch (minute) {
            case 00:
                return 0;
            case 15:
                return 1;
            case 30:
                return 2;
            case 45:
                return 3;
            default:
                return 0;
        }
    }
    /*This method is used to get the selected value of 15 min time interval in time picker*/
    private   int getSelectedValue(int newVal) {
        switch (newVal)
        {
            case 0:
                return 00;

            case 1:
                return 15;

            case 2:
                return 30;

            case 3:
                return 45;

            default:
                return 00;
        }

    }

    public void setValueInPicker(int mTimeInHour,int mTimeInMin,int mTimeFormat){
        timeInHour.setValue(mTimeInHour);
        timeInMin.setValue(getMinuteIn15Format(mTimeInMin));
        timeFormat.setValue(mTimeFormat);
        this.mTimeInMin=getSelectedValue(mTimeInMin);
        this.mTimeInHour=mTimeInHour;
        if(mTimeFormat>0)
            this.mTimeFormat=1;
        else
            this.mTimeFormat=0;
    }


    public static int getMinuteIn15Format(int minute){
        if(minute>=0&& minute<=15)
            return 0;
        else if(minute>15&& minute<=30)
            return 1;
        else if(minute>30&& minute<=45)
            return 2;
        else if(minute>45&& minute<=59)
            return 3;
        else
            return 0;

    }


}
