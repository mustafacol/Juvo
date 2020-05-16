package com.mustafa.juvo.bodyFragments;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mustafa.juvo.R;
import com.mustafa.juvo.viewmodels.YeniCagriUpdateViewModel;

public class YeniCagriUpdateFragment extends Fragment {

    private YeniCagriUpdateViewModel mViewModel;

    public static YeniCagriUpdateFragment newInstance() {
        return new YeniCagriUpdateFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.yeni_cagri_update_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(YeniCagriUpdateViewModel.class);
        // TODO: Use the ViewModel
    }

}
