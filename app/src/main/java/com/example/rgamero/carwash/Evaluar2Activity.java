package com.example.rgamero.carwash;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Evaluar2Activity extends AppCompatActivity {
    public int contador = 0;
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluar2);
        cambioColor();
        hechoEvento();
    }

    private void cambioColor(){
        final Button button4 =  (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable buttonColor = (ColorDrawable) button4.getBackground();
                int colorId = buttonColor.getColor();
                if(colorId == Color.RED){
                    button4.setBackgroundColor(Color.GREEN);
                    contador = contador-1;
                }
                else {
                    button4.setBackgroundColor(Color.RED);
                    contador = contador+1;}
            }
        });
        final Button button5 =  (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable buttonColor = (ColorDrawable) button5.getBackground();
                int colorId = buttonColor.getColor();
                if(colorId == Color.RED){
                    button5.setBackgroundColor(Color.GREEN);
                    contador = contador-1;
                }
                else {
                    button5.setBackgroundColor(Color.RED);
                    contador = contador+1;
                }
            }
        });
        final Button button6 =  (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable buttonColor = (ColorDrawable) button6.getBackground();
                int colorId = buttonColor.getColor();
                if(colorId == Color.RED){
                    button6.setBackgroundColor(Color.GREEN);
                    contador = contador-1;
                }
                else {
                    button6.setBackgroundColor(Color.RED);
                    contador = contador+1;
                }
            }
        });
        final Button button7 =  (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable buttonColor = (ColorDrawable) button7.getBackground();
                int colorId = buttonColor.getColor();
                if(colorId == Color.RED){
                    button7.setBackgroundColor(Color.GREEN);
                    contador = contador-1;
                }
                else {
                    button7.setBackgroundColor(Color.RED);
                    contador = contador+1;
                }
            }
        });
        final Button button8 =  (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable buttonColor = (ColorDrawable) button8.getBackground();
                int colorId = buttonColor.getColor();
                if(colorId == Color.RED){
                    button8.setBackgroundColor(Color.GREEN);
                    contador = contador-1;
                }
                else{
                    button8.setBackgroundColor(Color.RED);
                    contador = contador+1;
                }
            }
        });
        final Button button =  (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable buttonColor = (ColorDrawable) button.getBackground();
                int colorId = buttonColor.getColor();
                if(colorId == Color.RED){
                    button.setBackgroundColor(Color.GREEN);
                    contador = contador-1;
                }
                else {
                    button.setBackgroundColor(Color.RED);
                    contador = contador+1;
                }
            }
        });

    }

    private void hechoEvento(){
        Button button = (Button) findViewById(R.id.btn_listo);
        // add button listener
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View arg0) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("Usted marco "+contador);
                alertDialogBuilder.setMessage("¿Desea buscar un car wash cercano?");
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, close
                                // current activity
                                Toast toast = Toast.makeText(getApplicationContext(), "BUSCANDO CARWASH", Toast.LENGTH_LONG);
                                toast.setGravity(Gravity.CENTER,0,0);
                                toast.show();
                                Intent intent = new Intent(arg0.getContext(),Ubicacion.class);
                                startActivity(intent);
                                Evaluar2Activity.this.finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(arg0.getContext(),Ubicacion.class);
                                startActivity(intent);
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });
    }
}
