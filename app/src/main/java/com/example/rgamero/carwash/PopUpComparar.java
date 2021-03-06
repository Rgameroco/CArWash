package com.example.rgamero.carwash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

public class PopUpComparar extends Activity {

    GridView gridView;
    String[] valores = {
            "Nombre CarWash",
            "Precio",
            "Tiempo",
            "Distancia",
            "Express",
            "10",
            "15",
            "10 km",
            "Rapidito",
            "13",
            "12",
            "13 km",
    };

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.popupcomparar);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int alto = displayMetrics.widthPixels;
        int ancho = displayMetrics.heightPixels;
        getWindow().setLayout((int) (alto * .9), (int) (ancho * .8));
        llenarGrilla();
        btnReservar();
    }

    public void llenarGrilla() {
        gridView = (GridView) findViewById(R.id.grilla);

        gridView.setAdapter(new PopUpCompararAdapter(this, valores));
    }

    public void btnReservar() {
        Button button = (Button) findViewById(R.id.btn_compararPopup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ReservarActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}
