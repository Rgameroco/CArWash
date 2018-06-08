package com.example.rgamero.carwash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MisCarrosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_carros);

        Spinner spinner =(Spinner) findViewById(R.id.cmb_marca);
        String [] Opciones ={"Kia","Nissan","Toyota","Datsun"};
        spinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item));

        Spinner spinner2 =(Spinner) findViewById(R.id.cmb_modelo);
        String [] Opciones2 ={"Sedan","Mini Van","Hatchback","Compacto"};
        spinner2.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item));
    }
}
