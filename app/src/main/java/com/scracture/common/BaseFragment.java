package com.scracture.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.scracture.R;

/**
 * Created by root on 22/2/18.
 */

abstract  public class BaseFragment extends Fragment {
    abstract protected boolean isValidData();
    abstract protected void setViewListener();
    abstract protected void setViewReferences(View view);
    /**
     * Find Current activity object.
     *
     * @return
     */
    protected Activity getActivityInsideFragment() {
        return getActivity();
    }


    /** Method is used to start a new Activity
     * @param cls Name of the class which you want to forward
     */
    protected void startNewActivity(Class<?> cls){
        startActivity(new Intent(getActivity(),cls));
        getActivity().overridePendingTransition(R.anim.activity_animation_enter,
                R.anim.activity_animation_exit);

    }
    /** Method is used to start a new Activity
     * @param intent Data which you want to forward to next Activity
     */

    protected void startNewActivityWithData(Intent intent){
        startActivity(intent);
        getActivity(). overridePendingTransition(R.anim.activity_animation_enter,
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
        getActivity().overridePendingTransition(R.anim.activity_animation_enter, R.anim.activity_animation_exit);
    }


}
