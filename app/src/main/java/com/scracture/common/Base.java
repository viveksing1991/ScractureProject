package com.scracture.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.scracture.R;
import com.scracture.view.CommonToolbar;

/**
 * Created by root on 21/2/18.
 */

abstract  public class Base extends CommonToolbar{

    abstract protected boolean isValidData();
    abstract protected void setViewListener();
    abstract protected void setViewReferences();
    /**
     * Find Current activity object.
     *
     * @return
     */
    protected Base getActivity() {
        return this;
    }


    /** Method is used to start a new Activity
     * @param cls Name of the class which you want to forward
     */
    protected void startNewActivity(Class<?> cls){
        startActivity(new Intent(getActivity(),cls));
        overridePendingTransition(R.anim.activity_animation_enter,
                R.anim.activity_animation_exit);

    }
    /** Method is used to start a new Activity
     * @param intent Data which you want to forward to next Activity
     */

    protected void startNewActivityWithData(Intent intent){
        startActivity(intent);
        overridePendingTransition(R.anim.activity_animation_enter,
                R.anim.activity_animation_exit);

    }

    /** Method is used to start a new Activity with Result
     * @param cls Name of the class which you want to forward
     * @param bundle  Data which you want to forward to next Activity
     * @param requestCode request code for Activity  so you can get the result
     */
    protected void startActivityWithResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent(getActivity(), cls);
        if (bundle != null) {
            intent.putExtra("data", bundle);
        }
        startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.activity_animation_enter, R.anim.activity_animation_exit);
    }


}
