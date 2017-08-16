package com.example.admin.prueba;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{

    ArrayList<String> subDatos;

    public ItemAdapter(ArrayList<String> subDatos) {
        this.subDatos = subDatos;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subitem_list, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.tvNumeroSubitem.setText(position + "");
    }

    @Override
    public int getItemCount() {
        return subDatos.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        TextView tvNumeroSubitem;

        public ItemViewHolder(View itemView) {
            super(itemView);

            tvNumeroSubitem = itemView.findViewById(R.id.tvNumeroSubitem);
        }
    }
}
