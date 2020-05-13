package com.example.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

@SuppressLint("Registered")
public class MainActivity extends Activity {
    private ArrayList<Item> arrayList = new ArrayList<>();
    static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Toast.makeText(MainActivity.this, TAG + " onCreate", Toast.LENGTH_SHORT).show();
        Button button = findViewById(R.id.button_login);
        final EditText editText = findViewById(R.id.edit_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContentActivity.class);
                intent.putExtra("pass", editText.getText().toString());
                startActivity(intent);
            }
        });
        ListView listView = findViewById(R.id.list_view);
        MyAdapter myAdapter = new MyAdapter(getApplicationContext(), R.layout.my_list, arrayList);
        arrayList.add(new Item("Nguyen Hung"));
        listView.setAdapter(myAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, TAG + " onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, TAG + " onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, TAG + " onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, TAG + " onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, TAG + " onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(MainActivity.this, TAG + " onRestart", Toast.LENGTH_SHORT).show();
    }
}
