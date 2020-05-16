package com.mustafa.juvo.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class YeniCagriSecimViewModel extends ViewModel {

    MutableLiveData<List<String>> mutableLiveData;
    List<String> secimList= new ArrayList<>();


    public MutableLiveData<List<String>> getMutableLiveData() {
        return mutableLiveData;
    }

    public YeniCagriSecimViewModel() {
        mutableLiveData = new MutableLiveData<>();
        init();

    }

    public void init() {
        populateList();
        mutableLiveData.setValue(secimList);
    }

    public void populateList() {
        secimList.add("Numune Taşıma");
        secimList.add("Haste Taşıma");
        secimList.add("Temizlik Taşıma");
        secimList.add("HBYS Sorunu");

    }


}
