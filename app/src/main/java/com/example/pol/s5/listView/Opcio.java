package com.example.pol.s5.listView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pol.s5.R;

public class Opcio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcio);

        Bundle param = getIntent().getExtras();

        if (param!=null){
            String ciutat = param.getString("text");
            TextView tx1 = (TextView) findViewById(R.id.tx1);
            tx1.setText(ciutat);

        }
        else{
            TextView tx1 = (TextView) findViewById(R.id.tx1);
            tx1.setText("404 Not found");

        }

    }
}
