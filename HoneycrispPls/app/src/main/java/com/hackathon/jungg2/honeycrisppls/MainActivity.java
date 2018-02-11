package com.hackathon.jungg2.honeycrisppls;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap gMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(googleServicesAvailable()) {
            Toast.makeText(this, "PERFECT", Toast.LENGTH_LONG).show();
            setContentView(R.layout.activity_main);
            initMap();

        }
        else {
            //error check for no google maps
        }
    }

    private void initMap() {
        MapFragment mfrag = (MapFragment) getFragmentManager().findFragmentById((R.id.fragment));
        mfrag.getMapAsync(this);
    }

    public boolean googleServicesAvailable() {
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(this);
        if (isAvailable == ConnectionResult.SUCCESS) { //successful find of gservices
            return true;
        }
        else if (api.isUserResolvableError(isAvailable)) {
            Dialog dialog = api.getErrorDialog(this, isAvailable, 0);
            dialog.show();
        }
        else {
            Toast.makeText(this, "Cannot connect to Play Services", Toast.LENGTH_LONG).show();
        }
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) { //assign to GoogleMap object to parameter
        gMap = googleMap;
        goToLocation(48.736973,-122.4864025);

    }

    private void goToLocation(double lat, double lng) {
        LatLng redSquare = new LatLng(lat,lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(redSquare, 18f);
        gMap.moveCamera(update);
    }
}
