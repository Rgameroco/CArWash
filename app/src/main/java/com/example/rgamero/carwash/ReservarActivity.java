package com.example.rgamero.carwash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class ReservarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar);

        Spinner spinner =(Spinner) findViewById(R.id.cmb_hora);
        String [] Opciones ={"9:00","10:00","11:00","12:00","13:00"};
        spinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item));

        Spinner spinner2 =(Spinner) findViewById(R.id.cmb_tipo);
        String [] Opciones2 ={"Interior","Exterior"};
        spinner2.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item));

        Spinner spinner3 =(Spinner) findViewById(R.id.cmb_seleccion);
        String [] Opciones3 ={"Carro 1","Carro 2","Carro 3"};
        spinner3.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item));

    }


}
