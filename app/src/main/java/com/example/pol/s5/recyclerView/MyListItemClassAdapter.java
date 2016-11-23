package com.example.pol.s5.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pol.s5.Destino;
import com.example.pol.s5.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexbruch on 23/11/16.
 */

public class MyListItemClassAdapter extends BaseAdapter{

    private Context mContext;
    private List<Destino> items;

    public MyListItemClassAdapter(Context context) {
        mContext = context;
        items = new ArrayList<>();
        items.add(new Destino( "Barcelona2","Aquella ciutat que et deixa...", R.drawable.bcn,"459$"));
        items.add(new Destino( "Roma2","Gelats i pasta",R.drawable.rome,"329$"));
        items.add(new Destino( "New York2","La ciutat dels grans gratacels",R.drawable.ny,"1199$"));

    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.itemsla, parent, false);
        }
        Destino item = items.get(position);
        TextView ciudad =(TextView)convertView.findViewById(R.id.item_title);
        TextView descripcion = (TextView)convertView.findViewById(R.id.item_details);
        TextView precio = (TextView)convertView.findViewById(R.id.item_preu);
        ImageView foto = (ImageView)convertView.findViewById(R.id.item_image);

        ciudad.setText(item.getName());
        descripcion.setText(item.getDetails());
        precio.setText(item.getmPreu());
        foto.setImageResource(item.getImage());

        return convertView;
    }
}
