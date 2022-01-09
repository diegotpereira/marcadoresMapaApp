package com.example.marcadoresmapaapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.marcadoresmapaapp.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng marcador1 = new LatLng(-30.0652453, -51.2358921);
        mMap.addMarker(new MarkerOptions()
            .position(marcador1)
            .title("Estádio Beira Rio - Porto Alegre")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));

        LatLng marcador2 = new LatLng(-12.0262676, -77.1278653);
        mMap.addMarker(new MarkerOptions()
                .position(marcador2)
                .title("Lima - Perú")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));

        LatLng marcador3 = new LatLng(40.6892534, -74.0466891);
        mMap.addMarker(new MarkerOptions()
                .position(marcador3)
                .title("Estatua de la Libertad - EEUU")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));

        LatLng marcador4 = new LatLng(48.8583701, 2.2922926);
        mMap.addMarker(new MarkerOptions()
                .position(marcador4)
                .title("Torre Eiffel - França")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));

        // Centralizar marcadores
        LatLngBounds.Builder construtor = new LatLngBounds.Builder();
        construtor.include(marcador1);
        construtor.include(marcador2);
        construtor.include(marcador3);
        construtor.include(marcador4);

        LatLngBounds limites = construtor.build();

        int largura = getResources().getDisplayMetrics().widthPixels;
        int altura = getResources().getDisplayMetrics().heightPixels;
        int espacamento = (int) (altura * 0.25);

        CameraUpdate centrarMarcadores = CameraUpdateFactory.newLatLngBounds(limites, largura, altura, espacamento);

        mMap.animateCamera(centrarMarcadores);
    }
}