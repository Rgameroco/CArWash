package com.example.rgamero.carwash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class AgregarCarroFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_carro_form);

        Button btn = (Button) findViewById(R.id.btn_regresar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Ubicacion.class);
                startActivityForResult(intent,0);


            }
        });
        llenarSpinner();
    }

    public void Mensaje(View view){
        Toast.makeText(this , "Carro Guardado", Toast.LENGTH_SHORT);
    }

    public void llenarSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opcionesTipoUso, android.R.layout.simple_spinner_item);
        Spinner opciones = (Spinner) findViewById(R.id.spi_uso);
        opciones.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.preference_category);

    }
}
