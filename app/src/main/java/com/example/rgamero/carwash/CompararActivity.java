package com.example.rgamero.carwash;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class CompararActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.buscarComparar:
                    BottomNavigationItemView btn = (BottomNavigationItemView) findViewById(R.id.buscarComparar);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(v.getContext(), Pop.class);
                            startActivityForResult(intent, 0);
                        }
                    });
                    return true;
                case R.id.localizacionComparar:

                    return true;
                case R.id.relocalizacionComparar:
                    //mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;


        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparar);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationubi);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        btnComparar();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Toast mensaje = Toast.makeText(getApplicationContext(),"SELEECIONE LOS CARWASH A COMPARAR",Toast.LENGTH_LONG);
        mensaje.show();
        mMap = googleMap;
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
        LatLng universidadLasalle = new LatLng(-16.424327, -71.556138);
        final Marker markador = mMap.addMarker(new MarkerOptions().position(universidadLasalle).title("Universidad La Salle"));
        CameraPosition camera = new CameraPosition.Builder()
                .target(universidadLasalle)
                .zoom(15)
                .bearing(90)
                .build();
        markador.setTag(universidadLasalle);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(universidadLasalle));
        mMap.animateCamera(zoom);

        //Marcador Express
        LatLng carWashExpress = new LatLng(-16.421492, -71.553064);
        mMap.addMarker(new MarkerOptions().position(carWashExpress)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_carwash_verde))
                .position(carWashExpress)
                .flat(true)
        );

        //Marcador Rapidito
        LatLng carWashRapidito = new LatLng(-16.428462, -71.559458);
        mMap.addMarker(new MarkerOptions().position(carWashRapidito)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_carwash_verde))
                .position(carWashRapidito)
                .flat(true)
        );

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                mMap.clear();
                Toast toast  = Toast.makeText(getApplicationContext(),"DE CLICK AL BOTON COMPARAR",Toast.LENGTH_LONG);
                toast.show();
                LatLng universidadLasalle = new LatLng(-16.424327, -71.556138);
                final Marker markador = mMap.addMarker(new MarkerOptions().position(universidadLasalle).title("Universidad La Salle"));
                CameraPosition camera = new CameraPosition.Builder()
                        .target(universidadLasalle)
                        .zoom(15)
                        .bearing(90)
                        .build();
                markador.setTag(universidadLasalle);
                mMap.moveCamera(CameraUpdateFactory.newLatLng(universidadLasalle));
                //Marcador Express
                LatLng carWashExpress = new LatLng(-16.421492, -71.553064);
                mMap.addMarker(new MarkerOptions().position(carWashExpress)
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_carwash_verdesombreado))
                        .position(carWashExpress)
                        .flat(true)
                );
                //Marcador Rapidito
                LatLng carWashRapidito = new LatLng(-16.428462, -71.559458);
                mMap.addMarker(new MarkerOptions().position(carWashRapidito)
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_carwash_verdesombreado))
                        .position(carWashRapidito)
                        .flat(true)
                );
                return false;
            }
        });
    }

    public void btnComparar(){
        Button buttonComparr = (Button) findViewById(R.id.btn_compararmapa) ;
        buttonComparr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),PopUpComparar.class);
                startActivityForResult(intent,0);
            }
        });
    }

}
