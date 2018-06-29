package com.example.rgamero.carwash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;

public class Opciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int alto = displayMetrics.widthPixels;
        int ancho = displayMetrics.heightPixels;
        getWindow().setLayout((int)(alto*.9),(int) (ancho*.6));

        ImageButton  btn1 = (ImageButton ) findViewById(R.id.btn_perfil);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PerfilActivity.class);
                startActivityForResult(intent, 0);


            }
        });


        ImageButton  btn2 = (ImageButton ) findViewById(R.id.btn_Evaluarimage);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EvaluarActivity.class);
                startActivityForResult(intent, 0);


            }
        });
        ImageButton  btn3 = (ImageButton ) findViewById(R.id.btn_Favoritosimage);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FavoritosActivity.class);
                startActivityForResult(intent, 0);


            }
        });

        ImageButton btn4 = (ImageButton ) findViewById(R.id.btn_Ubicacionimage);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Ubicacion.class);
                startActivityForResult(intent, 0);


            }
        });



    }
}
