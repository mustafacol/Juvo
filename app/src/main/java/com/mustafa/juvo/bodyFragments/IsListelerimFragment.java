package com.mustafa.juvo.bodyFragments;

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

import com.mustafa.juvo.Adapters.IsListelerimAdapter;
import com.mustafa.juvo.Model.WorkList;
import com.mustafa.juvo.R;
import com.mustafa.juvo.viewmodels.IsListelerimViewModel;

import java.util.ArrayList;
import java.util.List;

public class IsListelerimFragment extends Fragment {

    private IsListelerimViewModel mViewModel;
    private RecyclerView recyclerview;
    IsListelerimAdapter adapter;
    public static IsListelerimFragment newInstance() {
        return new IsListelerimFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.is_listelerim_fragment, container, false);

        recyclerview=view.findViewById(R.id.isListelerim_recyclerview);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(IsListelerimViewModel.class);
        // TODO: Use the ViewModel
        mViewModel.getMutableLiveData().observe(getActivity(), new Observer<List<WorkList>>() {
            @Override
            public void onChanged(List<WorkList> workLists) {
                adapter= new IsListelerimAdapter(getContext(), (ArrayList<WorkList>) workLists);
                recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerview.setAdapter(adapter);
            }
        });
    }

}
