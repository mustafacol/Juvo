package com.mustafa.juvo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mustafa.juvo.Commons.Commons;
import com.mustafa.juvo.Model.Folder;
import com.mustafa.juvo.R;


import java.util.List;

public class FoldersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Folder> folderList;

    public  FoldersAdapter(Context context, List<Folder> items){
        this.context=context;
        this.folderList=items;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        if(viewType== Commons.VIEW_TYPE_DATE){
            ViewGroup date= (ViewGroup)inflater.inflate(R.layout.date_header,parent,false);
            FoldersAdapter.DateViewHolder dateViewHolder= new FoldersAdapter.DateViewHolder(date);

            return dateViewHolder;

        }
        else if(viewType==Commons.VIEW_TYPE_ITEM){
            ViewGroup activity= (ViewGroup)inflater.inflate(R.layout.folder_recycler_layout,parent,false);
            FoldersAdapter.FolderViewHolder folderViewHolder= new FoldersAdapter.FolderViewHolder(activity);
            return folderViewHolder;
        }
        else{
            ViewGroup date= (ViewGroup)inflater.inflate(R.layout.date_header,parent,false);
            FoldersAdapter.DateViewHolder dateViewHolder= new FoldersAdapter.DateViewHolder(date);
            return dateViewHolder;

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof DateViewHolder){
            FoldersAdapter.DateViewHolder dateViewHolder= (FoldersAdapter.DateViewHolder) holder;
            dateViewHolder.date.setText(folderList.get(position).getDate());
            //Log.d("ErrorCode:","Basılmadı");
        }
        else if(holder instanceof FolderViewHolder){
            FoldersAdapter.FolderViewHolder folderViewHolder= (FoldersAdapter.FolderViewHolder) holder;

            folderViewHolder.description.setText(folderList.get(position).getDescription());
            folderViewHolder.title.setText(folderList.get(position).getTitle());
            folderViewHolder.time.setText(folderList.get(position).getTime());
            folderViewHolder.responsible.setText(folderList.get(position).getResponsible());

        }

    }

    @Override
    public int getItemViewType(int position) {
        return folderList.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return folderList.size();
    }


    public class DateViewHolder extends RecyclerView.ViewHolder {
        TextView date;
        public DateViewHolder(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.date_header_textview);
        }
    }

    public class FolderViewHolder extends RecyclerView.ViewHolder {
        TextView date,time,responsible,description,title;
        public FolderViewHolder(@NonNull View itemView) {
            super(itemView);
            //date=itemView.findViewById(R.id.dosyalar_date_textview);
            time=itemView.findViewById(R.id.dosyalar_time_textview);
            responsible=itemView.findViewById(R.id.dosyalar_sorumlu_textview);
            description=itemView.findViewById(R.id.dosyalar_description_textview);
            title=itemView.findViewById(R.id.dosyalar_title_textview);
        }
    }

}
