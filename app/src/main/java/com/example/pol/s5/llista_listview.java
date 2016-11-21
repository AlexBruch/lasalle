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
                Intent inici = new Intent(getApplicationContext(),Opcio.class);
                switch( position )
                {
                    case 0:  Intent opcio0 = new Intent(getApplicationContext(),bcn.class);
                        startActivity(opcio0);
                        break;
                    case 1:

                        // 1. Instantiate an AlertDialog.Builder with its constructor
                        AlertDialog.Builder builder = new AlertDialog.Builder(llista_listview.this);
                        builder.setMessage(getString(R.string.romedetalls))
                                .setTitle("Rome");
                        builder.setPositiveButton("Barcelona", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent opcio0 = new Intent(getApplicationContext(),bcn.class);
                                startActivity(opcio0);
                            }
                        });
                        builder.setNeutralButton("Retry", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(llista_listview.this, "Error", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                        break;

                    default:  Intent opcio3 =  new Intent(getApplicationContext(),Opcio.class);
                        startActivity(opcio3);
                        break;
                }
            }
        });
    }
}
