package com.mustafa.juvo.bodyFragments;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;

import com.mustafa.juvo.Adapters.DuyurularAdapter;
import com.mustafa.juvo.Adapters.IsListelerimAdapter;
import com.mustafa.juvo.Model.Duyuru;
import com.mustafa.juvo.Model.WorkList;
import com.mustafa.juvo.R;
import com.mustafa.juvo.viewmodels.DuyurularViewModel;

import java.util.ArrayList;
import java.util.List;

import at.blogc.android.views.ExpandableTextView;

public class DuyurularFragment extends Fragment {

    private DuyurularViewModel mViewModel;
    RecyclerView recyclerView;
    private DuyurularAdapter adapter;
    LinearLayout linearLayout;
    ExpandableTextView expandableTextView;
    public static DuyurularFragment newInstance() {
        return new DuyurularFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.duyurular_fragment, container, false);
        recyclerView=view.findViewById(R.id.duyurular_recyclerview);


        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DuyurularViewModel.class);



        mViewModel.getMutableLiveData().observe(getActivity(), new Observer<List<Duyuru>>() {
            @Override
            public void onChanged(List<Duyuru> duyuruList) {
                adapter= new DuyurularAdapter(getContext(),duyuruList );

                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.e("RecyclerView", "onScrollStateChanged");
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

    }

    public void setExpandableTextview(){

    }

}
