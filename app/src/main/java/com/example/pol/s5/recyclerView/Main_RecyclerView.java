package com.example.pol.s5.recyclerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.example.pol.s5.Destino;
import com.example.pol.s5.R;

import java.util.ArrayList;
import java.util.List;

public class Main_RecyclerView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Destino> destinoList = new ArrayList<>();
    private MyListItemClassAdapter myListItemClassAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        myListItemClassAdapter = new MyListItemClassAdapter(destinoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myListItemClassAdapter);

        pelis();
    }

    public void pelis() {
        Destino listaDestino = new Destino("Barcelona2","Aquella ciutat que et deixa...", R.drawable.bcn,"459$");
        destinoList.add(listaDestino);

        listaDestino = new Destino("Roma2","Gelats i pasta",R.drawable.rome,"329$");
        destinoList.add(listaDestino);

        listaDestino = new Destino("New York2","La ciutat dels grans gratacels",R.drawable.ny,"1199$");
        destinoList.add(listaDestino);

        myListItemClassAdapter.notifyDataSetChanged();

    }

}
