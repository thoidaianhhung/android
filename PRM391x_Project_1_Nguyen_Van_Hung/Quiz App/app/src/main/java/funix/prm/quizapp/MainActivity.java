package funix.prm.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Create a timer variable
    public int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);

        Intent intentReceiver = getIntent();
        String name = intentReceiver.getStringExtra("name");
        textView.setText(name);

        final TextView countTime = findViewById(R.id.countTime);

        final RadioGroup radioGroup = findViewById(R.id.radioGroup);
        final RadioGroup radioGroup1 = findViewById(R.id.radioGroup1);
        final RadioGroup radioGroup2 = findViewById(R.id.radioGroup2);

        final EditText editText1 = findViewById(R.id.editText1);
        final CheckBox checkBox1 = findViewById(R.id.checkbox1);
        final CheckBox checkBox3 = findViewById(R.id.checkbox3);
        final EditText editText2 = findViewById(R.id.editText2);

        final EditText editText3 = findViewById(R.id.editText3);
        final CheckBox checkBox7 = findViewById(R.id.checkbox7);
        final CheckBox checkBox8 = findViewById(R.id.checkbox8);
        final EditText editText4 = findViewById(R.id.editText4);

        final EditText editText5 = findViewById(R.id.editText5);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int count = 0;
                    int selectedId = radioGroup.getCheckedRadioButtonId();
                    RadioButton buttonDNA = findViewById(selectedId);
                    if (buttonDNA.getText().toString().equals("DNA")) {
                        count++;
                    }
                    int selectedId1 = radioGroup1.getCheckedRadioButtonId();
                    RadioButton buttonPine = findViewById(selectedId1);
                    if (buttonPine.getText().toString().equals("Pine trees")) {
                        count++;
                    }
                    int selectedId2 = radioGroup2.getCheckedRadioButtonId();
                    RadioButton buttonStalagmites = findViewById(selectedId2);
                    if (buttonStalagmites.getText().toString().equals("Stalagmites")) {
                        count++;
                    }
                    if (editText1.getText().toString().equals("Vulcanizing")) {
                        count++;
                    }
                    if (editText2.getText().toString().equals("Gravity")) {
                        count++;
                    }
                    if (editText3.getText().toString().equals("Clouds") || editText3.getText().toString().equals("Cloud")) {
                        count++;
                    }
                    if (editText5.getText().toString().equals("Smelting")) {
                        count++;
                    }
                    if (editText4.getText().toString().equals("Wrist")) {
                        count++;
                    }
                    if (checkBox1.isChecked() && checkBox3.isChecked()) {
                        count++;
                    }
                    if (checkBox7.isChecked() && checkBox8.isChecked()) {
                        count++;
                    }
                    if (count == 10) {
                        Toast.makeText(MainActivity.this, "Perfect! You scored " + count + " out of 10", Toast.LENGTH_SHORT ).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Try again. You scored " + count + " out of 10", Toast.LENGTH_SHORT ).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "You have not entered the answer", Toast.LENGTH_SHORT).show();
                }

            }
        });
        new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                countTime.setText(String.valueOf(counter));
                counter++;
            }

            @Override
            public void onFinish() {
                try {
                    int count = 0;
                    int selectedId = radioGroup.getCheckedRadioButtonId();
                    RadioButton buttonDNA = findViewById(selectedId);
                    if (buttonDNA.getText().toString().equals("DNA")) {
                        count++;
                    }
                    int selectedId1 = radioGroup1.getCheckedRadioButtonId();
                    RadioButton buttonPine = findViewById(selectedId1);
                    if (buttonPine.getText().toString().equals("Pine trees")) {
                        count++;
                    }
                    int selectedId2 = radioGroup2.getCheckedRadioButtonId();
                    RadioButton buttonStalagmites = findViewById(selectedId2);
                    if (buttonStalagmites.getText().toString().equals("Stalagmites")) {
                        count++;
                    }
                    if (editText1.getText().toString().equals("Vulcanizing")) {
                        count++;
                    }
                    if (editText2.getText().toString().equals("Gravity")) {
                        count++;
                    }
                    if (editText3.getText().toString().equals("Clouds") || editText3.getText().toString().equals("Cloud")) {
                        count++;
                    }
                    if (editText5.getText().toString().equals("Smelting")) {
                        count++;
                    }
                    if (editText4.getText().toString().equals("Wrist")) {
                        count++;
                    }
                    if (checkBox1.isChecked() && checkBox3.isChecked()) {
                        count++;
                    }
                    if (checkBox7.isChecked() && checkBox8.isChecked()) {
                        count++;
                    }
                    if (count == 10) {
                        Toast.makeText(MainActivity.this, "Perfect! You scored " + count + " out of 10", Toast.LENGTH_SHORT ).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Try again. You scored " + count + " out of 10", Toast.LENGTH_SHORT ).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "You have not entered the answer", Toast.LENGTH_SHORT).show();
                }
            }
        }.start();
    }
}
