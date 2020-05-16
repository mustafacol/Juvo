package com.mustafa.juvo.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mustafa.juvo.Model.CagriItem;
import com.mustafa.juvo.R;

import java.util.ArrayList;
import java.util.List;

public class YeniCagriSecimAdapter extends RecyclerView.Adapter<YeniCagriSecimAdapter.YeniCagriSecimItemHolder> {
    Context context;
    List<String> cagriSecimItems;
    public YeniCagriSecimAdapter(Context context, List<String> items) {
        this.context=context;
        this.cagriSecimItems=items;
    }

    @NonNull
    @Override
    public YeniCagriSecimItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());

        View itemView=inflater.inflate(R.layout.yeni_cagri_secim_recycler_layout,parent,false);

        YeniCagriSecimAdapter.YeniCagriSecimItemHolder yeniCagriSecimItemHolder= new YeniCagriSecimAdapter.YeniCagriSecimItemHolder(itemView);

        return yeniCagriSecimItemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull YeniCagriSecimItemHolder holder, int position) {

        final int i= position;
        String  cagriItem= cagriSecimItems.get(i);
        Log.d("Item",cagriItem.toString());
        holder.category.setText(cagriItem);


    }

    @Override
    public int getItemCount() {
        return cagriSecimItems.size();
    }

    class YeniCagriSecimItemHolder extends RecyclerView.ViewHolder {
        LinearLayout frame;
        TextView category;
        Button button;
        CheckBox checkBox;
        public YeniCagriSecimItemHolder(@NonNull View itemView) {
            super(itemView);
            frame=itemView.findViewById(R.id.yeni_cagri_secim_item_layout);
            category=itemView.findViewById(R.id.yeni_cagri_secim_item_textview);
            button=itemView.findViewById(R.id.yeni_cagri_secim_item_button);





        }
    }
}
