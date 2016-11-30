package com.example.pol.s5;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.example.pol.s5.R.id.precio;

public class InfoDestino extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_destino);

        TextView ciudad = (TextView) findViewById(R.id.ciudad);
        ciudad.setText(getIntent().getStringExtra("ciudad"));

        TextView descripcion = (TextView) findViewById(R.id.descripcion);
        descripcion.setText(getIntent().getStringExtra("descripcion"));

        TextView precio = (TextView) findViewById(R.id.precio);
        precio.setText(getIntent().getStringExtra("precio"));

        ImageView imageView = (ImageView) findViewById(R.id.item_image);
        //imageView.setImageResource(getIntent().);

        Toast toast1 = Toast.makeText(getApplicationContext(), "Has seleccionado "+ getIntent().getStringExtra("ciudad"), Toast.LENGTH_SHORT);
        toast1.show();
    }
}
