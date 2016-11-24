package com.example.pol.s5.recyclerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pol.s5.Destino;
import com.example.pol.s5.R;

import java.util.ArrayList;
import java.util.List;

import static android.os.Build.VERSION_CODES.M;

public class Main_RecyclerView extends AppCompatActivity {

    RecyclerView Lista;
    private ArrayList<Destino> listaDestinos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        destinos();
    }


    public void destinos() {

        Lista = (RecyclerView) findViewById(R.id.recycler_view);
        Lista.setHasFixedSize(true);

        listaDestinos = new ArrayList<Destino>();
        listaDestinos.add(new Destino("Barcelona","Aquella ciutat que et deixa...", R.drawable.bcn,"459$"));
        listaDestinos.add(new Destino("Roma","Gelats i pasta",R.drawable.rome,"329$"));
        listaDestinos.add(new Destino("New York","La ciutat dels grans gratacels",R.drawable.ny,"1199$"));
        listaDestinos.add(new Destino("Girona","Colors al riu",R.drawable.girona,"450$"));
        listaDestinos.add(new Destino("Los Angeles","Santa Monica Pier",R.drawable.losangeles,"1400$"));
        listaDestinos.add(new Destino("Madrid","En el centro de la meseta",R.drawable.madrid,"250$"));
        listaDestinos.add(new Destino("Paris","Ciudad de los enamorados",R.drawable.paris,"5199$"));
        listaDestinos.add(new Destino("San Francisco","Lo más similar a Barcelona en EEUU",R.drawable.sanfrancisco,"3199$"));

        Adaptador adaptador = new Adaptador(listaDestinos);

        adaptador.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Destino destino = listaDestinos.get(position);

                Toast toast1 = Toast.makeText(getApplicationContext(), destino.getName(), Toast.LENGTH_SHORT);
                toast1.show();
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        Lista.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(Lista.getContext(), layoutManager.getOrientation());
        Lista.addItemDecoration(dividerItemDecoration);

        Lista.setItemAnimator(new DefaultItemAnimator());
        Lista.setAdapter(adaptador);

    }

    public static class Adaptador extends RecyclerView.Adapter<Adaptador.DestinoViewHolder> {
        private View.OnClickListener listener;
        private OnItemClickListener onItemClickListener;
        private ArrayList<Destino> listaDestinos;

        public Adaptador(ArrayList<Destino> datos) {
            this.listaDestinos = datos;
        }

        public Adaptador.DestinoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemsla, parent, false);
            DestinoViewHolder viewHolder = new DestinoViewHolder(view);
            return viewHolder;
        }

        public void onBindViewHolder(Adaptador.DestinoViewHolder holder, int position) {
            final Destino destino = listaDestinos.get(position);
            holder.bindDestino(destino);
        }

        public int getItemCount() {
            return listaDestinos.size();
        }

        public void setOnItemClickListener(final OnItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }

        public class DestinoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView Ciudad;
            private TextView Descripcion;
            private TextView Precio;
            private ImageView Foto;

            public DestinoViewHolder(View view) {
                super(view);

                Ciudad = (TextView) view.findViewById(R.id.item_title);
                Descripcion = (TextView) view.findViewById(R.id.item_details);
                Precio = (TextView) view.findViewById(R.id.item_preu);
                Foto = (ImageView) view.findViewById(R.id.item_image);

                view.setOnClickListener(this);
            }

            public void bindDestino(Destino d) {
                Ciudad.setText(d.getName());
                Descripcion.setText(d.getDetails());
                Precio.setText(d.getmPreu());
                Foto.setImageResource(d.getImage());
            }

            @Override
            public void onClick(View view) {
                if(onItemClickListener != null)
                    onItemClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }
    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }
}

