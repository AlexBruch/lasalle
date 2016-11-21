package com.example.pol.s5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pol on 15/11/2016.
 */

public class ItemsAdapter extends BaseAdapter {
    private Context mContext;
    private List<ItemsList> mItems;

    public ItemsAdapter(Context context){
        mContext=context;
        mItems = new ArrayList<>();
        mItems.add(new ItemsList( "Barcelona","Go to Activity",R.drawable.bcn,"459$"));
        mItems.add(new ItemsList( "Rome","Simple AlertDialog",R.drawable.rome,"329$"));
        mItems.add(new ItemsList( "New York","La ciutat dels grans gratacels",R.drawable.ny,"1199$"));

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
        ItemsList item = mItems.get(position);
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
