package com.mustafa.juvo.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mustafa.juvo.Commons.Commons;
import com.mustafa.juvo.Model.Activity;
import com.mustafa.juvo.R;


import java.util.List;

public class ActivitiesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    Context context;
    List<Activity> activityList;

    public ActivitiesAdapter(Context context, List<Activity> activityList) {
        this.context = context;
        this.activityList = activityList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        if(viewType== Commons.VIEW_TYPE_DATE){
            ViewGroup date= (ViewGroup)inflater.inflate(R.layout.date_header,parent,false);
            DateViewHolder dateViewHolder= new DateViewHolder(date);
            return dateViewHolder;

        }
        else if(viewType==Commons.VIEW_TYPE_ITEM){
            ViewGroup activity= (ViewGroup)inflater.inflate(R.layout.activity_recycler_layout,parent,false);
            ActivityViewHolder activityViewHolder= new ActivityViewHolder(activity);
            return activityViewHolder;
        }
        else{
            ViewGroup date= (ViewGroup)inflater.inflate(R.layout.date_header,parent,false);
            DateViewHolder dateViewHolder= new DateViewHolder(date);
            return dateViewHolder;

        }
    }

    @Override
    public int getItemViewType(int position) {
        return activityList.get(position).getViewType();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof DateViewHolder){
            DateViewHolder dateViewHolder= (DateViewHolder) holder;
            dateViewHolder.date_header_textview.setText(activityList.get(position).getDate());
            Log.d("ErrorCode:","BAsılmadı");
        }
        else if(holder instanceof ActivityViewHolder){
            ActivityViewHolder activityViewHolder= (ActivityViewHolder) holder;

            activityViewHolder.activity_description_textview.setText(activityList.get(position).getDescription());
            activityViewHolder.activity_title_textview.setText(activityList.get(position).getTitle());
            activityViewHolder.activity_time_textview.setText(activityList.get(position).getTime());
            activityViewHolder.activity_person_textview.setText(activityList.get(position).getPerson());
            activityViewHolder.activity_responsible_textview.setText(activityList.get(position).getResponsible());
            activityViewHolder.activity_picture_textview.setText(activityList.get(position).getPicture());
        }
    }

    @Override
    public int getItemCount() {
        return activityList.size();
    }

    private class DateViewHolder extends RecyclerView.ViewHolder{
        TextView date_header_textview;
        public DateViewHolder(@NonNull View itemView) {
            super(itemView);
            date_header_textview=itemView.findViewById(R.id.date_header_textview);
        }
    }

    private class ActivityViewHolder extends RecyclerView.ViewHolder{
        TextView activity_time_textview,activity_title_textview,
                activity_picture_textview, activity_person_textview,
                activity_responsible_textview, activity_description_textview;
        public ActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            activity_time_textview=itemView.findViewById(R.id.activity_time_textview);
            activity_title_textview=itemView.findViewById(R.id.activity_title_textview);
            activity_picture_textview=itemView.findViewById(R.id.activity_picture_textview);
            activity_person_textview=itemView.findViewById(R.id.activity_person_textview);
            activity_responsible_textview=itemView.findViewById(R.id.activity_responsible_textview);
            activity_description_textview=itemView.findViewById(R.id.activity_description_textview);
        }
    }
}
