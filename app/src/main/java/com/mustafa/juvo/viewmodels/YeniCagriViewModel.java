package com.mustafa.juvo.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mustafa.juvo.Commons.Commons;
import com.mustafa.juvo.Model.CagriItem;
import com.mustafa.juvo.R;

import java.util.ArrayList;

public class YeniCagriViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    MutableLiveData<ArrayList<CagriItem>> mutableLiveData;

    ArrayList<CagriItem> cagriItems= new ArrayList<>();

    int resources[]={R.drawable.numunevector, R.drawable.hastavector,R.drawable.temizlikvector,R.drawable.hbysvector};

    public YeniCagriViewModel(){
        mutableLiveData= new MutableLiveData<>();
        init();
    }

    public MutableLiveData<ArrayList<CagriItem>> getMutableLiveData() {
        return mutableLiveData;
    }

    private void init() {
        populateList();
        mutableLiveData.setValue(cagriItems);
    }

    private void populateList() {
        cagriItems.add(new CagriItem(R.drawable.numunevector,"Numune Taşıma"));
        cagriItems.add(new CagriItem(R.drawable.hastavector,"Hasta Taşıma"));
        cagriItems.add(new CagriItem(R.drawable.temizlikvector,"Temizlik Taşıma"));
        cagriItems.add(new CagriItem(R.drawable.hbysvector,"HBYS Sorunu"));
        cagriItems.add(new CagriItem(R.drawable.artiicon,"Seçiniz"));
    }

    public ArrayList<CagriItem> addEmptyItem(){
        cagriItems.add(cagriItems.size(),new CagriItem(R.drawable.artiicon,"Seçiniz"));
        mutableLiveData.setValue(cagriItems);

        return cagriItems;

    }


    public ArrayList<CagriItem> updateCagriItem(int position){
        cagriItems.get(Commons.cagriPosition-1).setResourceId(Commons.cagrisecimitemPosition);
        mutableLiveData.setValue(cagriItems);


        return cagriItems;
    }

}
