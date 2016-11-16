package com.example.pol.s5;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public  class MainActivity extends AppCompatActivity {

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Codi Alex prova */

        setContentView(R.layout.main_activity);

        /** ----- SPINNER ----- **/

        Spinner spinner=(Spinner) findViewById(R.id.spinner);

        ArrayList<ListaSpinner> spinnerLista = new ArrayList<>();
        spinnerLista.add(new ListaSpinner("1", "ListView"));
        spinnerLista.add(new ListaSpinner("2", "RecyclerView"));

        ArrayAdapter<ListaSpinner> adapter = new ArrayAdapter<ListaSpinner>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                spinnerLista);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final ListaSpinner listaSpinner = (ListaSpinner) parent.getSelectedItem();
                Toast toast = Toast.makeText(getApplicationContext(), listaSpinner.getText(), Toast.LENGTH_SHORT);
                toast.show();

                /** ----- BUTTON ----- **/

                Button next=(Button) findViewById(R.id.button);
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(listaSpinner.getId()=="1"){
                            Intent intent = new Intent(getApplicationContext(), ListViewcl.class);
                            startActivity(intent);
                        } else if(listaSpinner.getId()=="2"){
                            Intent intent = new Intent(getApplicationContext(),RecyclerView.class);
                            startActivity(intent);
                        }
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        /** Codi Pol correcte

        setContentView(R.layout.activity_main);

        final ListView lista =(ListView)findViewById(R.id.list);
        ItemsAdapter adeu = new ItemsAdapter(this);
        lista.setAdapter(adeu);



      lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               //Intent inici = new Intent(getApplicationContext(),Opcio.class);
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

        **/

    }

}
