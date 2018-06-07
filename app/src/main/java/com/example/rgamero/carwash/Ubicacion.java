package com.example.rgamero.carwash;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ImageButton;

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
    private View popup = null;

    private ImageButton btnMarcador;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.buscar:
                    BottomNavigationItemView btn = (BottomNavigationItemView) findViewById(R.id.buscar);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(v.getContext(),Pop.class);
                            startActivityForResult(intent,0);
                        }
                    });
                    return true;
                case R.id.comparar:
                    //mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.localizacion:
                   // mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.relocalizacion:
                    //mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

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


        //Marcador Express
        LatLng carWashExpress = new LatLng(-16.421492, -71.553064);
        mMap.addMarker(new MarkerOptions().position(carWashExpress)
                .title("CarWash Express")
                .snippet("Precio : 14 soles"+"\n"+"Tiempo: 15 minutos"+"\n"+"Distancia: 10 minutos"+"\n"+"Dirección: Av Springfield 555 hunter"+"\n"+"Telefono: 9899945"+"\n")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_carwash))
                .position(carWashExpress)
                .flat(true)
        );

        //Marcador Rapidito
        LatLng carWashRapidito = new LatLng(-16.428462, -71.559458);
        mMap.addMarker(new MarkerOptions().position(carWashRapidito)
                .title("CarWash Rapidito")
                .snippet("Distancia: 15 minutos"+"\n"+"Tiempo: 12 minutos"+"\n"+"Precio : 15 soles"+"\n"+"Dirección: Av Siempre Viva 105 hunter"+"\n"+"Telefono: 9899945"+"\n")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_carwash))
                .position(carWashRapidito)
                .flat(true)
        );

        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                if (popup == null){
                    popup = getLayoutInflater().inflate(R.layout.popupcarwash1,null);
                }
                TextView txtView = (TextView) popup.findViewById(R.id.titlepopup);
                ImageView imgView = (ImageView) popup.findViewById(R.id.iconpopup);
                RatingBar ratingBar =(RatingBar) popup.findViewById(R.id.ratingBar);
                txtView.setText(marker.getTitle());
                imgView.setImageResource(R.mipmap.carwashlogo);
                txtView = (TextView)popup.findViewById(R.id.snippetpopup);
                txtView.setText(marker.getSnippet());

                ratingBar.setNumStars(5);
                ratingBar.setRating(3);
                return (popup);
            }
        });





}

    }
