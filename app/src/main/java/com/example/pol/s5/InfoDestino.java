package com.example.pol.s5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class InfoDestino extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_destino);

        String ciudad= getIntent().getStringExtra("ciudad");

        Toast toast1 = Toast.makeText(getApplicationContext(), ciudad, Toast.LENGTH_SHORT);
        toast1.show();
    }
}
