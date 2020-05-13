package funix.prm.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView result = findViewById(R.id.resultTextView);
        Intent intent = getIntent();
        String sum = intent.getStringExtra("SUM");
        result.setText(sum);
    }
}
