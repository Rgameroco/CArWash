package com.example.rgamero.carwash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Opciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        Button btn = (Button) findViewById(R.id.btn_Registrar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),RegistroActivity.class);
                startActivityForResult(intent,0);

            }
        });

        Button btn1 = (Button) findViewById(R.id.btn_Perfil);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),PerfilActivity.class);
                startActivityForResult(intent,0);

            }
        });

        Button btn2 = (Button) findViewById(R.id.btn_Evaluar);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),EvaluarActivity.class);
                startActivityForResult(intent,0);

            }
        });
        Button btn3 = (Button) findViewById(R.id.btn_Favoritos);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),FavoritosActivity.class);
                startActivityForResult(intent,0);

            }
        });

        Button btn4 = (Button) findViewById(R.id.btn_Ubicacion);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Ubicacion.class);
                startActivityForResult(intent,0);

            }
        });
        Button btn5= (Button) findViewById(R.id.btn_Reservar);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ReservarActivity.class);
                startActivityForResult(intent,0);

            }
        });


    }
}
