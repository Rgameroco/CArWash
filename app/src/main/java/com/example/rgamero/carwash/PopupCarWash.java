package com.example.rgamero.carwash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class PopupCarWash extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupcarwash1);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.popupprincipal);
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View child = linearLayout.getChildAt(i);
            child.setEnabled(false);
        }
        Button btn = (Button) findViewById(R.id.btn_reservar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RegistroActivity.class);
                startActivityForResult(intent, 0);
            }
        });

    }


}
