package funix.prm.intents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ImplicitIntentActivity extends Activity implements View.OnClickListener {
    private Spinner mSpinner;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        mSpinner = findViewById(R.id.spinner1);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.intent, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
        Button button = findViewById(R.id.button1);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int position = mSpinner.getSelectedItemPosition();
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com.vn"));
                break;
            case 1:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=funix"));
                break;
            case 2:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
