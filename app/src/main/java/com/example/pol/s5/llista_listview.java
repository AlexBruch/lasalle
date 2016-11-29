package com.example.pol.s5;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class llista_listview extends AppCompatActivity {

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
                String param1, param2;
                int param3;

                switch( position )
                {
                    case 0:
                        Intent opcio0 = new Intent(getApplicationContext(),bcn.class);

                        startActivity(opcio0);
                        break;
                    case 1:


                        AlertDialog.Builder builder = new AlertDialog.Builder(llista_listview.this);
                        builder.setMessage(getString(R.string.romedetalls))
                                .setTitle("Rome");
                        builder.setPositiveButton("Barcelona", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent opcio0 = new Intent(getApplicationContext(),bcn.class);
                                startActivity(opcio0);
                            }
                        });

                        builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
                        dialog.show();
                        break;
                    case 2:
                         param1 =  ((ItemsList) lista.getItemAtPosition(position)).getName();
                        param2 = ((ItemsList) lista.getItemAtPosition(position)).getDetails();
                        param3 =((ItemsList) lista.getItemAtPosition(position)).getImage();
                        Intent opcio2 = new Intent(getApplicationContext(),DetallesCiudad.class);
                        opcio2.putExtra("param1",param1);
                        opcio2.putExtra("param2",param2);
                        opcio2.putExtra("param3",param3);
                        startActivity(opcio2);

                        break;
                    case 3:
                         param1 =  ((ItemsList) lista.getItemAtPosition(position)).getName();
                        param2 = ((ItemsList) lista.getItemAtPosition(position)).getDetails();
                          param3 =((ItemsList) lista.getItemAtPosition(position)).getImage();
                        Intent opcio3 = new Intent(getApplicationContext(),DetallesCiudad.class);
                        opcio3.putExtra("param1",param1);
                        opcio3.putExtra("param2",param2);
                        opcio3.putExtra("param3",param3);
                        startActivity(opcio3);

                        break;
                    default:
                        Toast.makeText(llista_listview.this, "Error", Toast.LENGTH_SHORT).show();


                        break;
                }
            }
        });
    }
}
