package com.scracture.model.toolbar.category;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by root on 7/3/18.
 */

public class ReligionCategory implements Parcelable {
    private  String categoryName;

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    private  String categoryImage;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.categoryName);
        dest.writeString(this.categoryImage);
    }

    public ReligionCategory() {
    }

    protected ReligionCategory(Parcel in) {
        this.categoryName = in.readString();
        this.categoryImage = in.readString();
    }

    public static final Parcelable.Creator<ReligionCategory> CREATOR = new Parcelable.Creator<ReligionCategory>() {
        @Override
        public ReligionCategory createFromParcel(Parcel source) {
            return new ReligionCategory(source);
        }

        @Override
        public ReligionCategory[] newArray(int size) {
            return new ReligionCategory[size];
        }
    };
}
