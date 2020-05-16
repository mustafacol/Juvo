package com.mustafa.juvo.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mustafa.juvo.Commons.Commons;
import com.mustafa.juvo.Model.Folder;

import java.util.ArrayList;
import java.util.List;

public class FolderViewModel extends ViewModel {
    private MutableLiveData<List<Folder>> mutableLiveData;
    List<Folder> folderList= new ArrayList<>();

    public FolderViewModel(){
        mutableLiveData= new MutableLiveData<>();
        init();
    }

    public void init(){
        createList();
        mutableLiveData.setValue(folderList);
    }
    public LiveData<List<Folder>> getMutableLiveData(){
        return mutableLiveData;
    }




    public List<Folder> populateList(List<Folder> folderList){
        folderList.add(new Folder("Mobile_T00326411","29.04.2019","12:09:05","Mobile_T00326411","İdare, Yardım Masası vakalarını değerlendirmesinde girilen",1));
        folderList.add(new Folder("Mobile_T00326411","29.04.2019","12:09:05","Mobile_T00326411","İdare, Yardım Masası vakalarını değerlendirmesinde girilen",1));
        folderList.add(new Folder("Mobile_T00326411","29.04.2019","12:09:05","Mobile_T00326411","İdare, Yardım Masası vakalarını değerlendirmesinde girilen",1));
        folderList.add(new Folder("Mobile_T00326411","30.04.2019","12:09:05","Mobile_T00326411","İdare, Yardım Masası vakalarını değerlendirmesinde girilen",1));
        folderList.add(new Folder("Mobile_T00326411","30.04.2019","12:09:05","Mobile_T00326411","İdare, Yardım Masası vakalarını değerlendirmesinde girilen",1));
        folderList.add(new Folder("Mobile_T00326411","30.04.2019","12:09:05","Mobile_T00326411","İdare, Yardım Masası vakalarını değerlendirmesinde girilen",1));


        //mutableLiveData.setValue(folderList);

        return folderList;
    }
    public List<Folder> addList(List<Folder> list){
        int i;
        List<Folder> customList= new ArrayList<>();
        Folder firstPosition= new Folder();
        firstPosition.setDate(list.get(0).getDate());
        firstPosition.setViewType(Commons.VIEW_TYPE_DATE);

        customList.add(firstPosition);


        for(i=0;i<list.size()-1;i++){
            Folder folder= new Folder();
            String date1= list.get(i).getDate();
            String date2=list.get(i+1).getDate();
            if(date1.equals(date2)){
                list.get(i).setViewType(Commons.VIEW_TYPE_ITEM);
                customList.add(list.get(i));
            }
            else{
                list.get(i).setViewType(Commons.VIEW_TYPE_ITEM);
                customList.add(list.get(i));
                folder.setDate(date2);
                folder.setViewType(Commons.VIEW_TYPE_DATE);
                customList.add(folder);
            }

        }
        list.get(i).setViewType(Commons.VIEW_TYPE_ITEM);
        customList.add(list.get(i));


        Log.d("List:",customList.toString());

        return customList;

    }

    public void createList(){
        folderList=populateList(folderList);
        folderList=addList(folderList);
        mutableLiveData.setValue(folderList);
    }

}
