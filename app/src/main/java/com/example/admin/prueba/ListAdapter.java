package com.example.admin.prueba;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{

    private static final double FLING_SPEED_FACTOR = 0.3;
    ArrayList<String> datos;
    int currentPosition;

    public ListAdapter(ArrayList<String> datos) {
        this.datos = datos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ArrayList<String> datos = new ArrayList<>();
        datos.add("A");
        datos.add("B");
        datos.add("C");

        ItemAdapter adapter = new ItemAdapter(datos);
        holder.rvViewPager.setAdapter(adapter);
        holder.rvViewPager.setHasFixedSize(true);

        SnapHelper mSnapHelper = new PagerSnapHelper();
        mSnapHelper.attachToRecyclerView(holder.rvViewPager);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(holder.itemView.getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.rvViewPager.setLayoutManager(layoutManager);

        holder.rvViewPager.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {

                    //Log.d("a", layoutManager.getPosition(holder.rvViewPager) + "");

                    int width = layoutManager.findLastVisibleItemPosition();
                    Log.d("valor","width = "+width);

                    /*if (position <firstLimit)
                        layoutManager.scrollToPositionWithOffset(0,0);
                    else if (position < secondLimit)
                        layoutManager.scrollToPositionWithOffset(1,0);
                    else
                        layoutManager.scrollToPositionWithOffset(2,0);*/

                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                Log.d("prubaScroll", dx + "");
                currentPosition = dx;
            }
        });

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        RecyclerView rvViewPager;

        public ViewHolder(View itemView) {
            super(itemView);
            rvViewPager = itemView.findViewById(R.id.rvViewPager);
        }
    }



}
