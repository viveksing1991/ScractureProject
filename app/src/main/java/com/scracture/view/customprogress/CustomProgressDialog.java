package com.scracture.view.customprogress;

import android.app.Activity;
import android.app.ProgressDialog;

import com.scracture.R;

/**
 * Created by root on 8/3/18.
 */

public class CustomProgressDialog {

    private static  ProgressDialog pd=null;

    public static  void CustomProgressDialog(Activity activity) {
        if(pd==null)
     pd= new ProgressDialog(activity, R.style.MyTheme);
        pd.setCancelable(false);
        pd.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
    }
    public static void ShowDialog(){
        pd.show();
    }

    public static void  DismissDialog(){
        if(pd!=null&&pd.isShowing())
        pd.dismiss();
    }
}
