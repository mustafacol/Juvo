package com.mustafa.juvo.viewmodels;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mustafa.juvo.Model.Vaka;

public class VakaAramaViewModel extends ViewModel {

    public MutableLiveData<String> vakaNo= new MutableLiveData<>();
    public MutableLiveData<String> durum= new MutableLiveData<>();
    public MutableLiveData<String> hizmet= new MutableLiveData<>();
    public MutableLiveData<String> tarih= new MutableLiveData<>();
    public MutableLiveData<String> aciklama= new MutableLiveData<>();
    public MutableLiveData<String> x= new MutableLiveData<>();

    public MutableLiveData<Vaka> vakaMutableLiveData= new MutableLiveData<>();

    public MutableLiveData<Vaka> getVakaMutableLiveData() {
        return vakaMutableLiveData;
    }

    public void setVakaMutableLiveData(MutableLiveData<Vaka> vakaMutableLiveData) {
        this.vakaMutableLiveData = vakaMutableLiveData;
    }

    public void onClick(View view){
        Vaka vaka= new Vaka(vakaNo.getValue(),durum.getValue(),hizmet.getValue(),tarih.getValue(),aciklama.getValue());

        vakaMutableLiveData.setValue(vaka);
        x.setValue(vaka.toString());

    }










}