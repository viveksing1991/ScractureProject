package com.scracture.controller.fragment;


import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.scracture.R;
import com.scracture.common.BaseFragment;
import com.scracture.controller.activities.details.DetailsActivity;
import com.scracture.databinding.FragmentHomeBinding;
import com.scracture.databinding.ItemRecBinding;
import com.scracture.model.toolbar.info.Info;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {


    private RecyclerView recViewHome;
    private Context mContext;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //   View view= inflater.inflate(R.layout.fragment_home, container, false);
        FragmentHomeBinding binding =    DataBindingUtil.inflate(inflater,
                R.layout.fragment_home, container, false);
        View view = binding.getRoot();
        setViewReferences(view);
        setViewListener();
        addLayoutToRecyclerView();
        setAdaptor();
        return  view;
    }

    private void setAdaptor() {
        InfoAdapter  userAdapter=new InfoAdapter(getInfoList());
        recViewHome.setAdapter(userAdapter);

    }

    private List<Info> getInfoList() {
        List<Info> userList=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            Info user=new Info();
            if(i%2==0) {
                user.data.set("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");
                user.heading.set("Heading1");
            }else{
                user.data.set("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock");
                user.heading.set("Heading2");
            }
            userList.add(user);
        }
        return userList;
    }

    private void addLayoutToRecyclerView() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        recViewHome.setLayoutManager(mLayoutManager);
    }

    @Override
    protected boolean isValidData() {
        return false;
    }

    @Override
    protected void setViewListener() {

    }

    @Override
    protected void setViewReferences(View view) {
        recViewHome= (RecyclerView) view.findViewById(R.id.recViewHome);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context!=null)
            mContext=context;
    }

    public class InfoAdapter extends  RecyclerView.Adapter<InfoAdapter.ViewHolder> {

        private List<Info> mUserList=new ArrayList<>();

        InfoAdapter(List<Info> mUserList){
            this.mUserList.addAll(mUserList);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
            ItemRecBinding activityMainBinding=DataBindingUtil.inflate(layoutInflater,R.layout.item_rec,parent,false);
            return new ViewHolder(activityMainBinding);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Info user=mUserList.get(position);
            holder.bind(user);
            listenerOnItem(holder);
        }

        private void listenerOnItem(ViewHolder holder) {
            holder.mBinding.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startNewActivity(DetailsActivity.class);

                }
            });

        }

        @Override
        public int getItemCount() {
            return mUserList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private ItemRecBinding mBinding;

            public ViewHolder(ItemRecBinding binding) {
                super(binding.getRoot());
                mBinding = binding;
            }

            public void bind(@NonNull Info user) {
                mBinding.setInfo(user);
                mBinding.executePendingBindings();

            }

        }
    }



}
