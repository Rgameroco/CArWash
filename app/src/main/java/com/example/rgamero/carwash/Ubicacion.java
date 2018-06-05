package com.example.rgamero.carwash;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
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

public class Ubicacion extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
        // Add a marker in Lasalle and move the camera
        LatLng universidadLasalle = new LatLng(-16.424327, -71.556138);
        mMap.addMarker(new MarkerOptions().position(universidadLasalle).title("Universidad La Salle"));
        CameraPosition camera = new CameraPosition.Builder()
                .target(universidadLasalle)
                .zoom(15)
                .bearing(90)
                .build();

        mMap.moveCamera(CameraUpdateFactory.newLatLng(universidadLasalle));
        mMap.animateCamera(zoom);


        //Marcador Carwash1
        LatLng carWashExpress = new LatLng(-16.421492, -71.553064);
        mMap.addMarker(new MarkerOptions().position(carWashExpress)
                .title("CarWash Express")
                .snippet("precio : 15 soles"+"\n"+"Valoracion 4/5")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_carwash))
                .position(carWashExpress)
                .flat(true)
        );

        //Marcador 2
        LatLng carWashRapidito = new LatLng(-16.428462, -71.559458);
        mMap.addMarker(new MarkerOptions().position(carWashRapidito)
                .title("CarWash Rapidito")
                .snippet("precio : 15 soles"+"\n"+"Valoracion 4/5")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_carwash))
                .position(carWashRapidito)
                .flat(true)
        );

    }



}
