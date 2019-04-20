package com.devapps.mapku;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements OnMapReadyCallback {

    MapView mapView;
    GoogleMap mGoogleMap;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_fragment1, container, false);

        mapView = v.findViewById(R.id.map_main);

        return v;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if(mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        setCoordinate(-7.607704, 110.203773);
        setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    void setCoordinate(double lat, double lang) {
        LatLng location = new LatLng(lat, lang);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(location);

        CameraPosition cameraPosition = new CameraPosition.Builder().target(location).zoom(16).build();

        mGoogleMap.addMarker(markerOptions);
        mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    public void setMapType(int mapType){
        mGoogleMap.setMapType(mapType);
    }
}
