package com.example.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

@SuppressLint("Registered")
public class ContentActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_activity);
        Button button = findViewById(R.id.button_content);
        Intent intent = getIntent();
        String pass = intent.getStringExtra("pass");
        TextView textView = findViewById(R.id.text_view);
        textView.setText(pass);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContentActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });

    }
}
