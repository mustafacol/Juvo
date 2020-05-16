package com.mustafa.juvo.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mustafa.juvo.Commons.Commons;
import com.mustafa.juvo.Model.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<List<Activity>> mutableLiveData;

    List<Activity> activityList= new ArrayList<>();


    public ActivityViewModel(){
        mutableLiveData= new MutableLiveData<List<Activity>>();
        init();
    }

    public void init(){
        createList();
        mutableLiveData.setValue(activityList);
    }
    public LiveData<List<Activity>> getMutableLiveData(){
        return mutableLiveData;
    }




    public List<Activity> populateList(List<Activity> activityList){
        activityList.add(new Activity("29 Nisan 2019","10:00:11","Reddet","Ahmet Mehmetoğlu","1231232.jpg","Signum Destek 1001","Tamirden önceki hali",1));
        activityList.add(new Activity("29 Nisan 2019","10:00:11","Reddet","Ahmet Mehmetoğlu","1231232.jpg","Signum Destek 1001","Tamirden önceki hali",1));
        activityList.add(new Activity("29 Nisan 2019","10:00:11","Reddet","Ahmet Mehmetoğlu","1231232.jpg","Signum Destek 1001","Tamirden önceki hali",1));
        activityList.add(new Activity("30 Nisan 2019","10:00:11","Hatalı Yönlendirme Olarak","Ahmet Mehmetoğlu","1231232.jpg","Signum Destek 1001","İdare, Yardım Masası vakalarını değerlendirmesinde girilen",1));
        activityList.add(new Activity("30 Nisan 2019","10:00:11","Hatalı Yönlendirme Olarak","Ahmet Mehmetoğlu","1231232.jpg","Signum Destek 1001","İdare, Yardım Masası vakalarını değerlendirmesinde girilen",1));
        activityList.add(new Activity("30 Nisan 2019","10:00:11","Hatalı Yönlendirme Olarak","Ahmet Mehmetoğlu","1231232.jpg","Signum Destek 1001","İdare, Yardım Masası vakalarını değerlendirmesinde girilen",1));


        //mutableLiveData.setValue(activityList);

        return activityList;
    }

    public List<Activity> addList(List<Activity> list){
        int i;
        List<Activity> customList= new ArrayList<>();
        Activity firstPosition= new Activity();
        firstPosition.setDate(list.get(0).getDate());
        firstPosition.setViewType(Commons.VIEW_TYPE_DATE);

        customList.add(firstPosition);


        for(i=0;i<list.size()-1;i++){
            Activity activity= new Activity();
            String date1= list.get(i).getDate();
            String date2=list.get(i+1).getDate();
            if(date1.equals(date2)){
                list.get(i).setViewType(Commons.VIEW_TYPE_ITEM);
                customList.add(list.get(i));
            }
            else{
                list.get(i).setViewType(Commons.VIEW_TYPE_ITEM);
                customList.add(list.get(i));
                activity.setDate(date2);
                activity.setViewType(Commons.VIEW_TYPE_DATE);
                customList.add(activity);
            }

        }
        list.get(i).setViewType(Commons.VIEW_TYPE_ITEM);
        customList.add(list.get(i));


        Log.d("List:",customList.toString());

        return customList;

    }

    public void createList(){
        activityList=populateList(activityList);
        activityList=addList(activityList);
        mutableLiveData.setValue(activityList);
    }
}
