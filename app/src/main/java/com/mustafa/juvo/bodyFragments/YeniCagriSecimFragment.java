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

import com.mustafa.juvo.Adapters.YeniCagriAdapter;
import com.mustafa.juvo.Adapters.YeniCagriSecimAdapter;
import com.mustafa.juvo.R;
import com.mustafa.juvo.viewmodels.YeniCagriSecimViewModel;
import com.mustafa.juvo.viewmodels.YeniCagriViewModel;

import java.util.List;

public class YeniCagriSecimFragment extends Fragment {

    private YeniCagriSecimViewModel mViewModel;
    YeniCagriSecimAdapter adapter;
    RecyclerView recyclerView;

    public static YeniCagriSecimFragment newInstance() {
        return new YeniCagriSecimFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.yeni_cagri_secim_fragment, container, false);
        recyclerView=view.findViewById(R.id.yeni_cagri_secim_recyclerview);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(YeniCagriSecimViewModel.class);
        // TODO: Use the ViewModel
        mViewModel.getMutableLiveData().observe(getActivity(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                adapter = new YeniCagriSecimAdapter(getContext(),strings);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);
            }
        });
    }

}
