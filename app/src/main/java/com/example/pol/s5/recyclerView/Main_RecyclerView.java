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

import static android.os.Build.VERSION_CODES.M;

public class Main_RecyclerView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Destino> destinoList = new ArrayList<>();
    private MyListItemClassAdapter myListItemClassAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.addItemDecoration(new Divider(this, LinearLayoutManager.VERTICAL));
        myListItemClassAdapter = new MyListItemClassAdapter(destinoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myListItemClassAdapter);

        destinos();
    }

    public void destinos() {
        Destino listaDestino = new Destino("Barcelona","Aquella ciutat que et deixa...", R.drawable.bcn,"459$");
        destinoList.add(listaDestino);

        listaDestino = new Destino("Roma","Gelats i pasta",R.drawable.rome,"329$");
        destinoList.add(listaDestino);

        listaDestino = new Destino("New York","La ciutat dels grans gratacels",R.drawable.ny,"1199$");
        destinoList.add(listaDestino);

        listaDestino = new Destino("Girona","Colors al riu",R.drawable.girona,"450$");
        destinoList.add(listaDestino);

        listaDestino = new Destino("Los Angeles","Santa Monica Pier",R.drawable.losangeles,"1400$");
        destinoList.add(listaDestino);

        listaDestino = new Destino("Madrid","En el centro de la meseta",R.drawable.madrid,"250$");
        destinoList.add(listaDestino);

        listaDestino = new Destino("Paris","Ciudad de los enamorados",R.drawable.paris,"5199$");
        destinoList.add(listaDestino);

        listaDestino = new Destino("San Francisco","Lo más similar a Barcelona en EEUU",R.drawable.sanfrancisco,"3199$");
        destinoList.add(listaDestino);

        myListItemClassAdapter.notifyDataSetChanged();

    }

}
