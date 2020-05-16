package com.mustafa.juvo.detailsFragments;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mustafa.juvo.Adapters.ActivitiesAdapter;
import com.mustafa.juvo.Model.Activity;
import com.mustafa.juvo.R;
import com.mustafa.juvo.viewmodels.ActivityViewModel;

import java.util.List;

public class ActivityFragment extends Fragment {

    private ActivityViewModel mViewModel;
    ActivitiesAdapter activitiesAdapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    public static ActivityFragment newInstance() {
        return new ActivityFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_fragment, container, false);
        recyclerView=view.findViewById(R.id.activity_recyclerview);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ActivityViewModel.class);
        // TODO: Use the ViewModel
        mViewModel.getMutableLiveData().observe(getActivity(), new Observer<List<Activity>>() {
            @Override
            public void onChanged(List<Activity> activityList) {
                activitiesAdapter= new ActivitiesAdapter(getContext(),activityList);
                layoutManager=new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
                //recyclerView.addItemDecoration(new DividerItemDecoration(this,layoutManager.));
                recyclerView.setAdapter(activitiesAdapter);
            }
        });
    }

}
