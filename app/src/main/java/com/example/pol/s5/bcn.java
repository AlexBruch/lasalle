package com.example.pol.s5;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import static com.example.pol.s5.R.id.activity_bcn;

public class bcn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bcn);
        TextView tx1 = (TextView) findViewById(R.id.tx1);
        tx1.setText("Bacelona");

        Button closeButton = (Button) findViewById(R.id.bClose);
        CheckBox chBox = (CheckBox) findViewById(R.id.checkBox);
       Button fondo = (Button) findViewById(R.id.button2);


//Close Button
        closeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(bcn.this);
                builder.setMessage(getString(R.string.seguro))
                        .setTitle(getString(R.string.alert));
                builder.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
                builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        fondo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                View someView = findViewById(activity_bcn);
                View root = someView.getRootView();
                root.setBackgroundColor(getResources().getColor(R.color.blue));

            }
        });
    }
}
