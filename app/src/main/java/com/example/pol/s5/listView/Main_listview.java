package com.example.pol.s5.listView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.pol.s5.Destino;
import com.example.pol.s5.InfoDestino;
import com.example.pol.s5.R;
import com.example.pol.s5.recyclerView.Main_RecyclerView;

import static android.R.attr.name;

public class Main_listview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llista);

        final ListView lista = (ListView)findViewById(R.id.list);

        final ItemsAdapter itemsAdapter = new ItemsAdapter(this);
        lista.setAdapter(itemsAdapter);


        /** Click al element de la llista, agafant tota la info com a objecte **/

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Object item = adapterView.getItemAtPosition(position);

                Intent intent = new Intent(getApplicationContext(), InfoDestino.class);
                //intent.putExtra("ciudad", item.getName());
                startActivity(intent);
            }
        });


    }
}
