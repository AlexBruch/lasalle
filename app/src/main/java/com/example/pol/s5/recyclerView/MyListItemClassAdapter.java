package com.example.pol.s5.recyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pol.s5.Destino;
import com.example.pol.s5.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexbruch on 23/11/16.
 */

public class MyListItemClassAdapter extends RecyclerView.Adapter<MyListItemClassAdapter.ViewHolder> {

    private List<Destino> destinoList;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView ciudad, descripcion, precio;
        public ImageView foto;

        public ViewHolder(View view) {
            super(view);
            ciudad = (TextView) view.findViewById(R.id.item_title);
            descripcion = (TextView) view.findViewById(R.id.item_details);
            precio = (TextView) view.findViewById(R.id.item_preu);
            foto = (ImageView) view.findViewById(R.id.item_image);
        }
    }

    public MyListItemClassAdapter(List<Destino> destinoList) {
        this.destinoList = destinoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemsla, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Destino destino = destinoList.get(position);
        holder.ciudad.setText(destino.getName());
        holder.descripcion.setText(destino.getDetails());
        holder.precio.setText(destino.getmPreu());
        holder.foto.setImageResource(destino.getImage());
    }

    @Override
    public int getItemCount() {
        return destinoList.size();
    }
}
