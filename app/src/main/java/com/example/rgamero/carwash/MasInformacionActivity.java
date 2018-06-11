package com.example.rgamero.carwash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MasInformacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mas_informacion);
        llenarSpinner();
        btnReservar();
    }


    public void llenarSpinner(){
        ListView opciones = (ListView) findViewById(R.id.list_info);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opcionesList, android.R.layout.simple_selectable_list_item);
        adapter.setDropDownViewResource(android.R.layout.preference_category);
        opciones.setAdapter(adapter);

    }

    public void btnReservar(){
        Button button = (Button) findViewById(R.id.btn_reservarmasinfo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MasInformacionActivity.this,"LLamando ReservarActivity",Toast.LENGTH_SHORT);
                Intent intent = new Intent(v.getContext(),ReservarActivity.class);
                startActivityForResult(intent,0);
                finish();
            }
        });
    }
}
