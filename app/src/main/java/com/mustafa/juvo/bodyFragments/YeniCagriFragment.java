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
import android.widget.ImageButton;

import com.mustafa.juvo.Adapters.YeniCagriAdapter;
import com.mustafa.juvo.Model.CagriItem;
import com.mustafa.juvo.R;
import com.mustafa.juvo.viewmodels.YeniCagriViewModel;

import java.util.ArrayList;

public class YeniCagriFragment extends Fragment {

    private YeniCagriViewModel mViewModel;
    private RecyclerView recyclerView;
    YeniCagriAdapter adapter;
    ImageButton imageButton;
    public static YeniCagriFragment newInstance() {
        return new YeniCagriFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.yeni_cagri_fragment, container, false);
        recyclerView=view.findViewById(R.id.yeni_cagri_recyclerview);
        imageButton=view.findViewById(R.id.addButton);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(YeniCagriViewModel.class);
        // TODO: Use the ViewModel

        mViewModel.getMutableLiveData().observe(getActivity(), new Observer<ArrayList<CagriItem>>() {
            @Override
            public void onChanged(ArrayList<CagriItem> cagriItems) {
                adapter = new YeniCagriAdapter(getContext(),cagriItems);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.notifyItemInserted(mViewModel.addEmptyItem().size());

            }
        });




    }

    public void onClick(View view){

    }

}