package funix.prm.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonImplicitIntent = findViewById(R.id.implicit_intent);
        buttonImplicitIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ImplicitIntentActivity.class);
                startActivity(intent);
            }
        });
        Button buttonExplicitIntent = findViewById(R.id.explicit_intent);
        buttonExplicitIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ExplicitIntentActivity.class);
                startActivity(intent);
            }
        });
        Button buttonIntentFilter = findViewById(R.id.intent_filter);
        buttonIntentFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IntentFilterActivity.class);
                startActivity(intent);
            }
        });
    }
}
