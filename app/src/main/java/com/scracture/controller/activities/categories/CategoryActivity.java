package com.scracture.controller.activities.categories;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.scracture.R;
import com.scracture.common.Base;
import com.scracture.controller.activities.landing.LandingActivity;
import com.scracture.controller.activities.main.MainActivity;
import com.scracture.model.toolbar.category.ReligionCategory;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CategoryActivity extends Base implements  AdapterView.OnItemClickListener,SwipeRefreshLayout.OnRefreshListener {

    private GridViewAdapter gridViewAdapter;
    private GridView gridView;
    ArrayList<ReligionCategory> categoryArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        tvToolbar.setText(getResources().getString(R.string.txt_category));
        setViewReferences();
        setViewListener();
        setDataIntoList();
        setCategoriesAdaptor();
    }

    @Override
    protected boolean isValidData() {
        return false;
    }

    @Override
    protected void setViewListener() {
        gridView.setOnItemClickListener(this);
    }

    @Override
    protected void setViewReferences() {
        gridView = (GridView) findViewById(R.id.gridview);

    }

    private void setDataIntoList(){
        for (int i = 0; i <30 ; i++) {
            ReligionCategory  religionCategory=new ReligionCategory();
            religionCategory.setCategoryName("Abc");
            religionCategory.setCategoryImage(null);
            categoryArrayList.add(religionCategory);
        }
    }
    /**
     * This method is used to set the adaptor to show the categories
     */
    private void setCategoriesAdaptor() {
        gridViewAdapter = new GridViewAdapter(getApplicationContext(), categoryArrayList);
        gridView.setAdapter(gridViewAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startNewActivity(MainActivity.class);
    }

    @Override
    public void onRefresh() {

    }


    /**
     * Created by user on 21/7/17.
     */

    public class GridViewAdapter extends BaseAdapter {

        private Context context;
        private LayoutInflater mLayoutInflater;
        ViewHolder viewHolder;
        private List<ReligionCategory> imageLists = new ArrayList<>();

        private ArrayList<ReligionCategory> searchList;

        public GridViewAdapter(Context context, List<ReligionCategory> imageLists) {
            this.context = context;
            this.imageLists = imageLists;
            this.mLayoutInflater = LayoutInflater.from(context);
            searchList = new ArrayList<>();
            searchList.addAll(imageLists);
        }


        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = mLayoutInflater.inflate(R.layout.category_view, null);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);

            } else
                viewHolder = (ViewHolder) convertView.getTag();

            //  Picasso.with(context).load(imageLists.get(position).getCategoryImage()).into(viewHolder.card_Image);
            viewHolder.card_item.setText(String.valueOf(imageLists.get(position).getCategoryName()));
            return convertView;

        }

        protected class ViewHolder {
            private ImageView card_Image;

            private TextView card_item;

            public ViewHolder(View view) {
                card_Image = (ImageView) view.findViewById(R.id.card_Image);
                card_item = (TextView) view.findViewById(R.id.card_item);
            }
        }


        @Override
        public int getCount() {
            return imageLists.size();
        }

        @Override
        public Object getItem(int position) {
            return imageLists.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

    }

}
