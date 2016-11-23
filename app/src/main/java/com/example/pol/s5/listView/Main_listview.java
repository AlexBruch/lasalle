package com.example.pol.s5.listView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.pol.s5.R;

public class Main_listview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llista);


        final ListView lista = (ListView)findViewById(R.id.list);

        ItemsAdapter adeu = new ItemsAdapter(this);
        lista.setAdapter(adeu);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent inici = new Intent(getApplicationContext(),Opcio.class);
                switch( position )
                {
                    case 0:  Intent opcio0 = new Intent(getApplicationContext(),bcn.class);
                        startActivity(opcio0);
                        break;
                    default:  Intent opcio2 =  new Intent(getApplicationContext(),Opcio.class);
                        startActivity(opcio2);
                        break;
                }
            }
        });
    }
}
