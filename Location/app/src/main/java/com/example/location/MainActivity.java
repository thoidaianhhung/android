package com.example.location;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mBtnShowLocation;
    private static final int REQUEST_CODE_PERMISSION = 2;
    private String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;
    // GPSTrackerService class
    private GPSTrackerService mGPSTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            if (ActivityCompat.checkSelfPermission(this, mPermission)
            != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[] {mPermission}, REQUEST_CODE_PERMISSION);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mBtnShowLocation = findViewById(R.id.btnGetLocation);
        mBtnShowLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGPSTracker = new GPSTrackerService(MainActivity.this);
                if (mGPSTracker.canGetLocation()) {
                    double latitude = mGPSTracker.getLatitude();
                    double longitude = mGPSTracker.getLongitude();
                    Toast.makeText(getApplicationContext(), "Your loaction is - \nLast: "
                            + latitude + "\nLong: " + longitude, Toast.LENGTH_SHORT).show();
                } else {
                    mGPSTracker.showSettingsAlert();
                }
            }
        });
    }
}
