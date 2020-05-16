package com.mustafa.juvo.detailsFragments;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mustafa.juvo.R;
import com.mustafa.juvo.viewmodels.SummaryViewModel;

public class SummaryFragment extends Fragment {

    private SummaryViewModel mViewModel;

    public static SummaryFragment newInstance() {
        return new SummaryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.summary_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SummaryViewModel.class);
        // TODO: Use the ViewModel
    }

}
