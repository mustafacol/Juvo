package com.mustafa.juvo.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mustafa.juvo.Activities.SingleWorkDetailActivity;
import com.mustafa.juvo.Model.WorkList;
import com.mustafa.juvo.R;

import java.util.ArrayList;

public class IsListelerimAdapter extends RecyclerView.Adapter<IsListelerimAdapter.IsListelerimItemHolder> {
    Context context;
    ArrayList<WorkList> workList;
    public IsListelerimAdapter(Context context, ArrayList<WorkList> workList) {
        this.context=context;
        this.workList=workList;
    }

    @NonNull
    @Override
    public IsListelerimItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());

        View itemView=inflater.inflate(R.layout.is_listelerim_recycler_layout,parent,false);

        IsListelerimItemHolder workListItemHolder= new IsListelerimItemHolder(itemView);

        return workListItemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull IsListelerimItemHolder holder, int position) {
        final WorkList work= workList.get(position);

        holder.description.setText(work.getDescription());
        holder.count.setText(work.getCount());
        holder.movebutton.setImageResource(R.drawable.right_arrow_24dp);

    }

    @Override
    public int getItemCount() {
        return workList.size() ;
    }

    class IsListelerimItemHolder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout;
        TextView description,count;
        ImageView movebutton;

        public IsListelerimItemHolder(@NonNull View itemView) {
            super(itemView);

            linearLayout=itemView.findViewById(R.id.linearLayout2);
            description=itemView.findViewById(R.id.description);
            count=itemView.findViewById(R.id.count);
            movebutton=itemView.findViewById(R.id.movebutton);


            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(context, SingleWorkDetailActivity.class);

                    intent.putExtra("header",description.getText().toString());
                    context.startActivity(intent);


                }
            });

        }



    }
}
