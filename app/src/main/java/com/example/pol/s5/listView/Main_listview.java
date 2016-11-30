package com.example.pol.s5.listView;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pol.s5.Destino;
import com.example.pol.s5.InfoDestino;
import com.example.pol.s5.R;
import com.example.pol.s5.recyclerView.Main_RecyclerView;

import java.util.ArrayList;

import static android.R.attr.name;

public class Main_listview extends AppCompatActivity {

    private ListView Lista;
    private ArrayList<Destino> listaDestinos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llista);

        Ciudades();


        /** Click al element de la llista, agafant tota la info com a objecte **/

        Lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Destino destino = listaDestinos.get(position);

                Intent intent = new Intent(getApplicationContext(), InfoDestino.class);
                intent.putExtra("ciudad", destino.getName());
                intent.putExtra("descripcion", destino.getDetails());
                intent.putExtra("precio", destino.getmPreu());
                intent.putExtra("foto", destino.getImage());
                startActivity(intent);
            }
        });
    }

    public void Ciudades() {
        Lista = (ListView) findViewById(R.id.list);

        listaDestinos = new ArrayList<>();
        listaDestinos.add(new Destino("Barcelona","Aquella ciutat que et deixa...", R.drawable.bcn,"459$"));
        listaDestinos.add(new Destino("Roma","Gelats i pasta",R.drawable.rome,"329$"));
        listaDestinos.add(new Destino("New York","La ciutat dels grans gratacels",R.drawable.ny,"1199$"));
        listaDestinos.add(new Destino("Girona","Colors al riu",R.drawable.girona,"450$"));
        listaDestinos.add(new Destino("Los Angeles","Santa Monica Pier",R.drawable.losangeles,"1400$"));
        listaDestinos.add(new Destino("Madrid","En el centro de la meseta",R.drawable.madrid,"250$"));
        listaDestinos.add(new Destino("Paris","Ciudad de los enamorados",R.drawable.paris,"5199$"));
        listaDestinos.add(new Destino("San Francisco","Lo más similar a Barcelona en EEUU",R.drawable.sanfrancisco,"3199$"));

        AdaptadorDestinos adaptadorDestinos = new AdaptadorDestinos(this);
        Lista.setAdapter(adaptadorDestinos);
    }

    class AdaptadorDestinos extends ArrayAdapter<Destino> {

        AppCompatActivity appCompatActivity;

        public AdaptadorDestinos(AppCompatActivity context) {
            super(context, R.layout.itemsla, listaDestinos);
            appCompatActivity = context;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = convertView;
            ViewHolder holder;

            if (view == null) {
                LayoutInflater inflater = appCompatActivity.getLayoutInflater();
                view = inflater.inflate(R.layout.itemsla, null);

                holder = new ViewHolder();

                holder.Ciudad = (TextView) view.findViewById(R.id.item_title);
                holder.Descripcion = (TextView) view.findViewById(R.id.item_details);
                holder.Precio = (TextView) view.findViewById(R.id.item_preu);
                holder.Foto = (ImageView) view.findViewById(R.id.item_image);

                view.setTag(holder);

            }else {
                holder = (ViewHolder) view.getTag();
            }

            holder.Ciudad.setText(listaDestinos.get(position).getName());
            holder.Descripcion.setText(listaDestinos.get(position).getDetails());
            holder.Precio.setText(listaDestinos.get(position).getmPreu());
            holder.Foto.setImageResource(listaDestinos.get(position).getImage());

            return view;
        }
    }

    static class ViewHolder {
        TextView Ciudad;
        TextView Descripcion;
        TextView Precio;
        ImageView Foto;
    }
}
