package com.mustafa.juvo.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mustafa.juvo.Model.WorkList;

import java.util.ArrayList;
import java.util.List;

public class IsListelerimViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    MutableLiveData<List<WorkList>> mutableLiveData;

    List<WorkList> workLists= new ArrayList<>();

    public IsListelerimViewModel() {
        mutableLiveData = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<List<WorkList>> getMutableLiveData() {
        return mutableLiveData;
    }

    public void init(){
        populateList();
        mutableLiveData.setValue(workLists);
    }

    public void populateList() {
        workLists.add(new WorkList("Bina Arazi - Arıza İş Emirleri","15"));
        workLists.add(new WorkList("911- Hasta Yönlendirme, Refakat","250"));
        workLists.add(new WorkList("Hasta Yönlendirme_2","9"));
        workLists.add(new WorkList("Doğrudan Zarar Talepleri (Spv)","1549"));
        workLists.add(new WorkList("DTE - Bakım İş Emirleri","98"));
        workLists.add(new WorkList("Açık Vakalar","23659"));
        workLists.add(new WorkList("911 - Biyomedikal","254"));
        workLists.add(new WorkList("Bina Arazi - Arıza İş Emirleri","15"));
        workLists.add(new WorkList("911- Hasta Yönlendirme, Refakat","250"));
        workLists.add(new WorkList("Hasta Yönlendirme_2","9"));
        workLists.add(new WorkList("Doğrudan Zarar Talepleri (Spv)","1549"));
        workLists.add(new WorkList("DTE - Bakım İş Emirleri","98"));
        workLists.add(new WorkList("Açık Vakalar","23659"));
        workLists.add(new WorkList("911 - Biyomedikal","254"));

    }
}
