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

import com.mustafa.juvo.Adapters.FoldersAdapter;
import com.mustafa.juvo.Model.Folder;
import com.mustafa.juvo.R;
import com.mustafa.juvo.viewmodels.FolderViewModel;

import java.util.ArrayList;
import java.util.List;

public class FolderFragment extends Fragment {
    private FolderViewModel mViewModel;
    private List<Folder> folderList= new ArrayList<>();
    FoldersAdapter foldersAdapter;
    RecyclerView recyclerView;

    //private FolderViewModel mViewModel;

    public static FolderFragment newInstance() {
        return new FolderFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.folder_fragment, container, false);
        recyclerView=view.findViewById(R.id.folder_recyclerview);




        return view; }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FolderViewModel.class);
        // TODO: Use the ViewModel
        mViewModel.getMutableLiveData().observe(getActivity(), new Observer<List<Folder>>() {
            @Override
            public void onChanged(List<Folder> folders) {
                foldersAdapter= new FoldersAdapter(getContext(),folders);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(foldersAdapter);
            }
        });
    }

}
