package com.example.rgamero.carwash;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

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
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class Ubicacion extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private View popup = null;



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
                            Intent intent = new Intent(v.getContext(), Pop.class);
                            startActivityForResult(intent, 0);
                        }
                    });
                    return true;
                case R.id.comparar:

                    return true;
                case R.id.localizacion:

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
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        ImageButton btn = (ImageButton) findViewById(R.id.btn_registrarmapa);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ReservarActivity.class);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
        // Add a marker in Lasalle and move the camera
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
                .title("CarWash Express")
                .snippet("Precio : 14 soles" + "\n" + "Tiempo: 15 minutos" + "\n" + "Distancia: 10 minutos" + "\n" + "Dirección: Av Springfield 555 hunter" + "\n" + "Telefono: 9899945" + "\n")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_carwash))
                .position(carWashExpress)
                .flat(true)
        );

        //Marcador Rapidito
        LatLng carWashRapidito = new LatLng(-16.428462, -71.559458);
        mMap.addMarker(new MarkerOptions().position(carWashRapidito)
                .title("CarWash Rapidito")
                .snippet("Distancia: 15 minutos" + "\n" + "Tiempo: 12 minutos" + "\n" + "Precio : 15 soles" + "\n" + "Dirección: Av Siempre Viva 105 hunter" + "\n" + "Telefono: 9899945" + "\n")
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
                if (popup == null) {
                    popup = getLayoutInflater().inflate(R.layout.popupcarwash1, null);
                }
                TextView txtView = (TextView) popup.findViewById(R.id.titlepopup);
                ImageView imgView = (ImageView) popup.findViewById(R.id.iconpopup);
                RatingBar ratingBar = (RatingBar) popup.findViewById(R.id.ratingBar);
                txtView.setText(marker.getTitle());
                imgView.setImageResource(R.mipmap.carwashlogo);
                txtView = (TextView) popup.findViewById(R.id.snippetpopup);
                txtView.setText(marker.getSnippet());
                ratingBar.setNumStars(5);
                ratingBar.setRating(3);
                return (popup);
            }
        });
       /* mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                int position = (int)(markador.getTag());
                Intent intent = new Intent(Ubicacion.this, MasInformacionActivity.class);
                startActivity(intent);
                return false;
            }
        });*/

    }

    LatLng hcm = new LatLng(-16.424327, -71.556138);//universidad

    public void Ruta(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.addPolyline(new PolylineOptions().add(
                hcm,
                new LatLng(-16.426713, -71.559810),//punto medio
                new LatLng(-16.427783, -71.560438),//punto medio
                new LatLng(-16.428462, -71.559458)
        )
                        .width(10)
                        .color(Color.green(10))
        );
        mMap.addPolyline(new PolylineOptions().add(
                hcm,
                new LatLng(-16.421492, -71.553064)
        )
                .width(10)
                .color(Color.green(10))
        );

    }
}
