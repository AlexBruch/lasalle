package com.example.pol.s5.recyclerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.pol.s5.R;

public class Main_RecyclerView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llista);

        final ListView lista = (ListView)findViewById(R.id.list);

        MyListItemClassAdapter listAdapter = new MyListItemClassAdapter(this);
        lista.setAdapter(listAdapter);
    }

}
