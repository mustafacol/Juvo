package com.mustafa.juvo.bodyFragments;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.mustafa.juvo.R;
import com.mustafa.juvo.viewmodels.AnasayfaViewModel;

public class AnasayfaFragment extends Fragment {

    private AnasayfaViewModel mViewModel;

    public static AnasayfaFragment newInstance() {
        return new AnasayfaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.anasayfa_fragment, container, false);

        /*androidx.appcompat.widget.Toolbar toolbar=getActivity().findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_dehaze_black_24dp);*/



        /*androidx.appcompat.widget.Toolbar toolbar= view.findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.WHITE);*/

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AnasayfaViewModel.class);
        // TODO: Use the ViewModel
    }

}
