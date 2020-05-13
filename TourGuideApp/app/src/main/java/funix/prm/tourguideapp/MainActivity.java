package funix.prm.tourguideapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare title bar
        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Tour Guide App");

        // Declare image button for hotel, hospital, atm, metro
        final ImageButton hotel = findViewById(R.id.image_button_hotel);
        final ImageButton hospital = findViewById(R.id.image_button_hospital);
        final ImageButton atm = findViewById(R.id.image_button_atm);
        final ImageButton metro = findViewById(R.id.image_button_metro);

        // Declare object fragment
        final Fragment fragmentHotel = new HotelFragment();
        final Fragment fragmentHospital = new HospitalFragment();
        final Fragment fragmentAtm = new AtmFragment();
        final Fragment fragmentMetro = new MetroFragment();

        // Button image event hotel
        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.layout, fragmentHotel);
                fragmentTransaction.commit();
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setTitle("Hotel");
                hotel.setVisibility(View.GONE);
                hospital.setVisibility(View.GONE);
                atm.setVisibility(View.GONE);
                metro.setVisibility(View.GONE);
            }
        });

        // Button image event hospital
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.layout, fragmentHospital);
                fragmentTransaction.commit();
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setTitle("Hospital");
                hotel.setVisibility(View.GONE);
                hospital.setVisibility(View.GONE);
                atm.setVisibility(View.GONE);
                metro.setVisibility(View.GONE);
            }
        });

        // Button image event atm
        atm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.layout, fragmentAtm);
                fragmentTransaction.commit();
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setTitle("ATM");
                hotel.setVisibility(View.GONE);
                hospital.setVisibility(View.GONE);
                atm.setVisibility(View.GONE);
                metro.setVisibility(View.GONE);
            }
        });

        // Button image event metro
        metro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.layout, fragmentMetro);
                fragmentTransaction.commit();
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setTitle("Metro");
                hotel.setVisibility(View.GONE);
                hospital.setVisibility(View.GONE);
                atm.setVisibility(View.GONE);
                metro.setVisibility(View.GONE);
            }
        });
    }

    // Method back to home page
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(intent, 0);
        return true;
    }
}
