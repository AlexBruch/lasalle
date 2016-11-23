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

import com.example.pol.s5.com.spinner.s5.ListaSpinner;
import com.example.pol.s5.recyclerView.Llista_RecyclerView;
import com.example.pol.s5.R;
import com.example.pol.s5.listView.llista_listview;

import java.util.ArrayList;

public  class MainActivity extends AppCompatActivity {

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
                            Intent intent = new Intent(getApplicationContext(), llista_listview.class);
                            startActivity(intent);
                        } else if(listaSpinner.getId()=="2"){
                            Intent intent = new Intent(getApplicationContext(),Llista_RecyclerView.class);
                            startActivity(intent);
                        }
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

}
