package com.example.pol.s5.listView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pol.s5.Destino;
import com.example.pol.s5.InfoDestino;
import com.example.pol.s5.R;
import com.example.pol.s5.recyclerView.Main_RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pol on 15/11/2016.
 */

public class ItemsAdapter extends BaseAdapter {
    private Context mContext;
    private List<Destino> mItems;

    public ItemsAdapter(Context context){
        mContext=context;
        mItems = new ArrayList<>();
        mItems.add(new Destino( "Barcelona","Aquella ciutat que et deixa...", R.drawable.bcn,"459$"));
        mItems.add(new Destino( "Roma","Gelats i pasta",R.drawable.rome,"329$"));
        mItems.add(new Destino( "New York","La ciutat dels grans gratacels",R.drawable.ny,"1199$"));

    }

    @Override
    public int getCount(){return mItems.size();}

    @Override
    public Object getItem(int position){return mItems.get(position);}

    @Override
    public long getItemId(int position){
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.itemsla, parent, false);
        }
        Destino item = mItems.get(position);
        TextView title = (TextView)convertView.findViewById(R.id.item_title);
        TextView details = (TextView)convertView.findViewById(R.id.item_details);
        TextView preu = (TextView)convertView.findViewById(R.id.item_preu);
        ImageView image=(ImageView)convertView.findViewById(R.id.item_image);
        title.setText(item.getName());
        details.setText(item.getDetails());
        preu.setText(item.getmPreu());
        image.setImageResource(item.getImage());
        return convertView;
    }
}
