package com.scracture.utils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.scracture.R;
import com.squareup.picasso.Picasso;

/**
 * Created by root on 22/2/18.
 */

public final class DataBinder {

    private DataBinder() {
        //NO-OP
    }

  /*  @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Picasso.with(context).load(url).into(imageView);
    }
*/
  public String getImageUrl() {
      // The URL will usually come from a model (i.e Profile)
      return "http://cdn.meme.am/instances/60677654.jpg";
  }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.base)
                .into(view);
    }
}