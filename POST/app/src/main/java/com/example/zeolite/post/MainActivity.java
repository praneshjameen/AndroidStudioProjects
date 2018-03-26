package com.example.zeolite.post;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    TextView res,lati,lngi;
    DatabaseReference loc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = findViewById(R.id.result);
        lati=findViewById(R.id.lat);
        lngi=findViewById(R.id.lng);
        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
        final LocationManager locationManager = (LocationManager) MainActivity.this.getSystemService(Context.LOCATION_SERVICE);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    // The toggle is enabled


                    LocationListener locationListener = new LocationListener() {
                        public void onLocationChanged(Location location) {
                            // Called when a new location is found by the network location provider.
                            double lat,lng;
                            lat =location.getLatitude();
                          lng =location.getLongitude();
                          change(lat,lng);

                        }

                        public void onStatusChanged(String provider, int status, Bundle extras) {
                        }

                        public void onProviderEnabled(String provider) {
                        }

                        public void onProviderDisabled(String provider) {
                        }
                    };

// Register the listener with the Location Manager to receive location updates
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);


                }
                else {
                    // The toggle is disabled
                }
            }
        });


    }
    public void change(double lat,double lng)
    {
        loc= FirebaseDatabase.getInstance().getReference("map");
        loc.child("lat").setValue(lat);
        loc.child("lng").setValue(lng);

        lati.setText(String.valueOf(lat));
        lngi.setText(String.valueOf(lng));
    }
    public void Scann(View v){
        Intent i=new Intent(this, BarCode.class);
        startActivityForResult(i,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==0)
        {
            if(resultCode== CommonStatusCodes.SUCCESS){
                if(data!=null)
                {
                    Barcode ba=data.getParcelableExtra("barcode");
                    res.setText("QR value : "+ba.displayValue );
                }
                else
                {
                    res.setText("No QR found");
                }
            }
        }
        else
        {

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}