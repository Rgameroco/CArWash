package com.example.rgamero.carwash;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class PopUpComparar extends Activity {
    @Override
    protected  void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.popupcomparar);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int alto = displayMetrics.widthPixels;
        int ancho = displayMetrics.heightPixels;
        getWindow().setLayout((int)(alto*.9),(int) (ancho*.8));
    }
}
