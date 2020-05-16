package com.mustafa.juvo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;


import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.interfaces.SwipeItemMangerInterface;
import com.daimajia.swipe.util.Attributes;
import com.mustafa.juvo.Model.Duyuru;
import com.mustafa.juvo.R;

import java.util.List;

import at.blogc.android.views.ExpandableTextView;

public class DuyurularAdapter extends RecyclerView.Adapter<DuyurularAdapter.DuyuruItemHolder> {
    Context context;
    List<Duyuru> duyuruList;

    public DuyurularAdapter(Context context, List<Duyuru> duyuruList) {
        this.context = context;
        this.duyuruList = duyuruList;
    }

    @NonNull
    @Override
    public DuyuruItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());

        View itemView=inflater.inflate(R.layout.duyurular_recycler_layout,parent,false);

        DuyurularAdapter.DuyuruItemHolder duyuruItemHolder= new DuyurularAdapter.DuyuruItemHolder(itemView);

        return duyuruItemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final DuyuruItemHolder holder,final int position) {
        final Duyuru duyuru= duyuruList.get(position);

        holder.expandableTextView.setText(duyuru.getDescription());
        holder.title.setText(duyuru.getTitle());
        holder.date.setText(duyuru.getDate());
        if(duyuru.getStatus()==1) {
            holder.image.setBackgroundResource(R.drawable.yeniduyuruikonu);
        }
        else{
            holder.image.setBackgroundResource(R.drawable.duyuruikonu);
        }


        holder.swipeLayout.addDrag(SwipeLayout.DragEdge.Right, holder.swipeLayout.findViewById(R.id.bottom_wraper));
        holder.swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onStartOpen(SwipeLayout layout) {

            }

            @Override
            public void onOpen(SwipeLayout layout) {

            }

            @Override
            public void onStartClose(SwipeLayout layout) {

            }

            @Override
            public void onClose(SwipeLayout layout) {

            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {

            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {

            }
        });

        holder.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwipeItemMangerInterface mItemManger= new SwipeItemMangerInterface() {
                    @Override
                    public void openItem(int position) {

                    }

                    @Override
                    public void closeItem(int position) {

                    }

                    @Override
                    public void closeAllExcept(SwipeLayout layout) {

                    }

                    @Override
                    public void closeAllItems() {

                    }

                    @Override
                    public List<Integer> getOpenItems() {
                        return null;
                    }

                    @Override
                    public List<SwipeLayout> getOpenLayouts() {
                        return null;
                    }

                    @Override
                    public void removeShownLayouts(SwipeLayout layout) {

                    }

                    @Override
                    public boolean isOpen(int position) {
                        return false;
                    }

                    @Override
                    public Attributes.Mode getMode() {
                        return null;
                    }

                    @Override
                    public void setMode(Attributes.Mode mode) {

                    }
                };
                mItemManger.removeShownLayouts(holder.swipeLayout);
                duyuruList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, duyuruList.size());
                mItemManger.closeAllItems();
            }
        });



    }

    @Override
    public int getItemCount() {
        return duyuruList.size();
    }

    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    public class DuyuruItemHolder extends RecyclerView.ViewHolder {
        TextView title,date;
        ExpandableTextView expandableTextView;
        FrameLayout image;
        LinearLayout linearLayout;
        public SwipeLayout swipeLayout;
        public TextView Delete;


        public DuyuruItemHolder(@NonNull final View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.duyuru_title);
            date=itemView.findViewById(R.id.duyuru_date);
            linearLayout=itemView.findViewById(R.id.duyurular_item_layout);
            expandableTextView=itemView.findViewById(R.id.expandableTextView);
            image=itemView.findViewById(R.id.duyurular_image);
            swipeLayout = (SwipeLayout) itemView.findViewById(R.id.swipe);
            Delete = (TextView) itemView.findViewById(R.id.Delete);



            expandableTextView.setAnimationDuration(750L);
            expandableTextView.setInterpolator(new OvershootInterpolator());

            // or set them separately
            expandableTextView.setExpandInterpolator(new OvershootInterpolator());
            expandableTextView.setCollapseInterpolator(new OvershootInterpolator());

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    expandableTextView.toggle();

                }
            });




        }
    }
}
