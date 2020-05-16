package com.mustafa.juvo.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.mustafa.juvo.Activities.DetailsActivity;
import com.mustafa.juvo.Activities.SingleWorkDetailActivity;
import com.mustafa.juvo.Model.SingleWork;
import com.mustafa.juvo.R;

import java.util.List;

public class SingleWorkDetailAdapter extends RecyclerView.Adapter<SingleWorkDetailAdapter.SingleWorkDetailItemHolder> {

    Context context;
    List<SingleWork> singleWorks;

    public SingleWorkDetailAdapter(Context context, List<SingleWork> singleWorks) {
        this.context = context;
        this.singleWorks = singleWorks;
    }

    @NonNull
    @Override
    public SingleWorkDetailItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.singleworkdetail_recycler_layout,parent,false);
        SingleWorkDetailAdapter.SingleWorkDetailItemHolder singleWorkDetailItemHolder= new SingleWorkDetailAdapter.SingleWorkDetailItemHolder(itemView);

        return singleWorkDetailItemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SingleWorkDetailItemHolder holder, int position) {
        final SingleWork singleWork= singleWorks.get(position);

        holder.singlework_header.setText(singleWork.getHeader());
        holder.singlework_location.setText(singleWork.getLocation());
        holder.singlework_explanation.setText(singleWork.getExplanation());
        holder.singlework_header.setText(singleWork.getHeader());
        holder.singlework_responsible.setText(singleWork.getResponsible());
        holder.singlework_date.setText(singleWork.getDate());
        holder.singlework_target_time.setText(singleWork.getTarget_time());
        holder.singlework_remain_time.setText(singleWork.getRemain_time());
        holder.single_work_situation.setText(singleWork.getSituation());
        if(!singleWork.getStatus()){
            holder.single_work_situation.setBackgroundColor(Color.rgb(209,93,87));

        }

    }

    @Override
    public int getItemCount() {
        return singleWorks.size();
    }

    class SingleWorkDetailItemHolder extends RecyclerView.ViewHolder {
        ConstraintLayout singlework_constraint_layout;
        TextView singlework_header,singlework_location,singlework_explanation,singlework_responsible,
                singlework_date,singlework_target_time,singlework_remain_time,single_work_situation;
        public SingleWorkDetailItemHolder(@NonNull View itemView) {
            super(itemView);
            singlework_constraint_layout=itemView.findViewById(R.id.singlework_constraint_layout);
            singlework_header=itemView.findViewById(R.id.singlework_header);
            singlework_location=itemView.findViewById(R.id.singlework_location);
            singlework_explanation=itemView.findViewById(R.id.singlework_explanation);
            singlework_responsible=itemView.findViewById(R.id.singlework_responsible);
            singlework_date=itemView.findViewById(R.id.singlework_date);
            singlework_target_time=itemView.findViewById(R.id.singlework_target_time);
            singlework_remain_time=itemView.findViewById(R.id.singlework_remain_time);
            single_work_situation=itemView.findViewById(R.id.single_work_situation);

            singlework_constraint_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(context, DetailsActivity.class);

                    intent.putExtra("header",singlework_header.getText().toString());
                    context.startActivity(intent);
                }
            });
        }
    }
}
