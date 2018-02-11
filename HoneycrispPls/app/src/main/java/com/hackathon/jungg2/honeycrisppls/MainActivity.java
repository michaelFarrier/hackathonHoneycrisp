package com.hackathon.jungg2.honeycrisppls;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static GoogleMap gMap;
    Marker marker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(googleServicesAvailable()) {
            //Toast.makeText(this, "PERFECT", Toast.LENGTH_LONG).show();
            setContentView(R.layout.activity_main);
            initMap();
        }
        else {
            //error check for no google maps
        }
    }

    private void initMap() {
        MapFragment mfrag = (MapFragment) getFragmentManager().findFragmentById((R.id.fragment));
        mfrag.getMapAsync(this); //create the map

    }

    public void fillCampus () {
        LatLng commBuilding = new LatLng(48.7328261,-122.485278);
        MarkerOptions option = new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.tapwater))
                .position(commBuilding);
        marker = gMap.addMarker(option);

    }
    public boolean googleServicesAvailable() {
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(this);
        if (isAvailable == ConnectionResult.SUCCESS) { //successful find of gservices
            return true;
        }
        else if (api.isUserResolvableError(isAvailable)) { //some other random error with gservices
            Dialog dialog = api.getErrorDialog(this, isAvailable, 0);
            dialog.show();
        }
        else { //no gservices at all
            Toast.makeText(this, "Cannot connect to Play Services", Toast.LENGTH_LONG).show();
        }
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) { //assign to GoogleMap object to parameter
        gMap = googleMap;
        goToLocation(48.736973,-122.4864025); //change location of the map
        fillCampus();
        setMapLongClick(gMap);
    }

    private void goToLocation(double lat, double lng) {
        LatLng redSquare = new LatLng(lat,lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(redSquare, 18f);
        gMap.moveCamera(update);
    }

    private void setMapLongClick(final GoogleMap map) {
        map.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng commBuilding) {
                startActivity(new Intent(MainActivity.this, FountainsWindow.class));
            }
        });
    }
}
