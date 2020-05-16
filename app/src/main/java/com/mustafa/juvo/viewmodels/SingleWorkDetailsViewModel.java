package com.mustafa.juvo.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mustafa.juvo.Model.SingleWork;

import java.util.ArrayList;
import java.util.List;

public class SingleWorkDetailsViewModel extends ViewModel {
    MutableLiveData<List<SingleWork>> mutableLiveData;
    List<SingleWork> singleWorkList= new ArrayList<>();


    public MutableLiveData<List<SingleWork>> getMutableLiveData() {
        return mutableLiveData;
    }

    public SingleWorkDetailsViewModel() {
        this.mutableLiveData = new MutableLiveData<>();
        init();
    }

    public void init() {
        populateList();
        mutableLiveData.setValue(singleWorkList);
    }

    public void populateList(){
        singleWorkList.add(new SingleWork("Tıbbi Ekipman - ASH11000212 - Ebru Yıldız","Ana Bina - 3. Kat - B Blok \n 310117 - KVC AMELİYATHANE - 2",
                "Lorem ipsum dolor sit amet, consectetur \n adipiscing elit. Donec eget nibh malesuada, imperdiet lectus"
                ,"Hasan Gençoğlan","01.04.2019 \n 10:00:27","Hedef Süre \n 2 Saat","Kalan Süre \n 1:30:07","Çalışıyor",true));
        singleWorkList.add(new SingleWork("Tıbbi Ekipman - ASH11000212 - Ebru Yıldız","Ana Bina - 3. Kat - B Blok \n 310117 - KVC AMELİYATHANE - 2",
                "Lorem ipsum dolor sit amet, consectetur \nadipiscing elit. Donec eget nibh malesuada, imperdiet lectus"
                ,"Hasan Gençoğlan","01.04.2019 \n 10:00:27","Hedef Süre \n 2 Saat","Kalan Süre \n 1:30:07","Çalışıyor",false));
        singleWorkList.add(new SingleWork("Tıbbi Ekipman - ASH11000212 - Ebru Yıldız","Ana Bina - 3. Kat - B Blok \n 310117 - KVC AMELİYATHANE - 2",
                "Lorem ipsum dolor sit amet, consectetur \n adipiscing elit. Donec eget nibh malesuada, imperdiet lectus"
                ,"Hasan Gençoğlan","01.04.2019 \n 10:00:27","Hedef Süre \n 2 Saat","Kalan Süre \n 1:30:07","Çalışıyor",true));
    }
}
