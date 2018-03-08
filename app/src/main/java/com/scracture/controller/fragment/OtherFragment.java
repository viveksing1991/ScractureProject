package com.scracture.controller.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.scracture.R;
import com.scracture.common.Base;
import com.scracture.common.BaseFragment;
import com.scracture.model.toolbar.category.ReligionCategory;

import java.util.ArrayList;
import java.util.List;


public class OtherFragment extends BaseFragment  implements AdapterView.OnItemClickListener{

    private ListView listView;
    private ArrayList<ReligionCategory> categoryArrayList=new ArrayList<>();

    public OtherFragment() {
        // Required empty public constructor
    }

    public static OtherFragment newInstance(String param1, String param2) {
        OtherFragment fragment = new OtherFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_other, container, false);
        setViewReferences(view);
        setViewListener();
        setDataIntoList();
        setListItemAdaptor();
        return  view;
    }


    private void setDataIntoList(){
        for (int i = 0; i <3 ; i++) {
            ReligionCategory  religionCategory=new ReligionCategory();
            religionCategory.setCategoryName("Abc");
            religionCategory.setCategoryImage(null);
            categoryArrayList.add(religionCategory);
        }
    }

    private void setListItemAdaptor() {
        ItemsMyaccountAdapter itemsMyaccountAdapter = new ItemsMyaccountAdapter(getContext(), categoryArrayList);

        listView.setAdapter(itemsMyaccountAdapter);

    }


    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    protected boolean isValidData() {
        return false;
    }

    @Override
    protected void setViewListener() {
        listView.setOnItemClickListener(this);
    }

    @Override
    protected void setViewReferences(View view) {
        listView = (ListView) view.findViewById(R.id.list);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


    public class ItemsMyaccountAdapter extends BaseAdapter {

        private List<ReligionCategory> objects = new ArrayList<ReligionCategory>();

        private Context context;
        private LayoutInflater layoutInflater;

        public ItemsMyaccountAdapter(Context context, ArrayList<ReligionCategory> objects) {
            this.context = context;
            this.layoutInflater = LayoutInflater.from(context);
            this.objects = objects;
        }

        @Override
        public int getCount() {
            return objects.size();
        }

        @Override
        public ReligionCategory getItem(int position) {
            return objects.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.items_myaccount, null);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            //  viewHolder.image.setImageResource(objects.get(position).getCategoryImage());
            viewHolder.userInfo.setText(objects.get(position).getCategoryImage());
            return convertView;
        }

        public void hideElement(int position) {

        }

        protected class ViewHolder {
            private ImageView image;
            private TextView userInfo;

            public ViewHolder(View view) {
                image = (ImageView) view.findViewById(R.id.Image);
                userInfo = (TextView) view.findViewById(R.id.userInfo);
            }
        }
    }


}
