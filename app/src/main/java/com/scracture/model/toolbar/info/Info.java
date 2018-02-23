package com.scracture.model.toolbar.info;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.scracture.R;
import com.squareup.picasso.Picasso;

import retrofit2.http.Field;

/**
 * Created by root on 22/2/18.
 */
public class Info {
    public ObservableField<String> heading=new ObservableField<>();
    public ObservableField<String> data=new ObservableField<>();
    public String imageUrl="http://cdn.meme.am/instances/60677654.jpg";
    // public ObservableField<String> imageUrl=new ObservableField<>();

    public String getImageUrl() {
        // The URL will usually come from a model (i.e Profile)
        return "http://cdn.meme.am/instances/60677654.jpg";
    }

    @BindingAdapter({"app:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load("http://cdn.meme.am/instances/60677654.jpg")
                .into(view);
    }

   }
