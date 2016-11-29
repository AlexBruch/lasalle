package com.example.pol.s5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallesCiudad extends AppCompatActivity {
    ImageView ciudad;
    TextView nombre, descripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalleciudad);

        Bundle details = getIntent().getExtras();
        String TX1 = details.getString("param1");
        String TX2 = details.getString("param2");
        int img = details.getInt("param3");

        TextView nombre = (TextView) findViewById(R.id.Name);
        nombre.setText(TX1);
        TextView detalles = (TextView) findViewById(R.id.descripcion);
        detalles.setText(TX2);
      ImageView imatge = (ImageView) findViewById(R.id.imageView2);

       imatge.setImageResource(img);


    }





}
