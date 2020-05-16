package com.mustafa.juvo.Adapters;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mustafa.juvo.Model.CagriItem;
import com.mustafa.juvo.R;
import com.mustafa.juvo.bodyFragments.YeniCagriSecimFragment;
import com.mustafa.juvo.bodyFragments.YeniCagriUpdateFragment;

import java.util.ArrayList;

public class YeniCagriAdapter extends RecyclerView.Adapter<YeniCagriAdapter.YeniCagriItemHolder>{

    Context context;
    ArrayList<CagriItem> cagriItemArrayList;
    public YeniCagriAdapter(Context context, ArrayList<CagriItem> values) {
        this.context=context;
        this.cagriItemArrayList=values;
    }

    @NonNull
    @Override
    public YeniCagriItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());

        View itemView=inflater.inflate(R.layout.yeni_cagri_recycler_layout,parent,false);

        YeniCagriAdapter.YeniCagriItemHolder yeniCagriItemHolder= new YeniCagriAdapter.YeniCagriItemHolder(itemView);

        return yeniCagriItemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull YeniCagriAdapter.YeniCagriItemHolder holder, int position) {

        final int i= position;
        final CagriItem cagriItem= cagriItemArrayList.get(i);
        Log.d("Item",cagriItem.toString());
        holder.item_name.setText(cagriItem.getItemName());
        holder.item_image.setImageResource(cagriItem.getResourceId());
        holder.item_right_arrow.setImageResource(R.drawable.right_arrow_24dp);




    }

    @Override
    public int getItemCount() {
        Log.d("Array-Size",cagriItemArrayList.size()+"");
        return cagriItemArrayList.size();
    }

    class YeniCagriItemHolder extends RecyclerView.ViewHolder {

        LinearLayout cagriItem_layout;
        ImageView item_image;
        TextView item_name;
        ImageButton item_right_arrow;

        public YeniCagriItemHolder(@NonNull final View itemView) {
            super(itemView);
            cagriItem_layout=itemView.findViewById(R.id.cagriItem_layout);
            item_image=itemView.findViewById(R.id.item_image);
            item_name=itemView.findViewById(R.id.itemName);
            item_right_arrow=itemView.findViewById(R.id.item_right_arrow);

            cagriItem_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(item_name.getText().equals("Seçiniz")){
                        YeniCagriSecimFragment fragment= YeniCagriSecimFragment.newInstance();
                        Bundle args= new Bundle();
                        args.putInt("position",getLayoutPosition());
                        fragment.setArguments(args);
                        FragmentManager manager=((AppCompatActivity)context).getSupportFragmentManager();
                        manager.beginTransaction().replace(R.id.fragment_container,fragment).commit();

                    }
                    else{
                        YeniCagriUpdateFragment fragment= YeniCagriUpdateFragment.newInstance();
                        /*Bundle args= new Bundle();
                        args.putInt("position",getLayoutPosition());
                        fragment.setArguments(args);*/
                        FragmentManager manager=((AppCompatActivity)context).getSupportFragmentManager();
                        manager.beginTransaction().replace(R.id.fragment_container,fragment).commit();
                    }
                }
            });



        }


    }
}