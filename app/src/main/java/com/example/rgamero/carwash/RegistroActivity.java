package com.example.rgamero.carwash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class RegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

    Spinner spinner =(Spinner) findViewById(R.id.spinner);
    String [] Opciones ={"Contado","Tarjeta"};
    spinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item));

    Spinner spinner2 =(Spinner) findViewById(R.id.spinner2);
    String [] Opciones2 ={"Mina","Paticular","Movilidad"};
    spinner2.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item));


    }
}
