package funix.prm.fragment;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Fragment one = new MyListFragment();
        final Fragment two = new FragmentTwo();
        final Button btnSend = findViewById(R.id.fragment1);
        final Button btnSend1 = findViewById(R.id.fragment2);
        final ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("Fragment Home");

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.layout, one);
                fragmentTransaction.commit();
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setTitle("Fragment One");
                btnSend.setVisibility(View.GONE);
                btnSend1.setVisibility(View.GONE);

            }

        });

        btnSend1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.layout, two);
                fragmentTransaction.commit();
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setTitle("Fragment Two");
                btnSend.setVisibility(View.GONE);
                btnSend1.setVisibility(View.GONE);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}
