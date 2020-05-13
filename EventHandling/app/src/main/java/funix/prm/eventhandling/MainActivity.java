package funix.prm.eventhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mSubtraction;
    private Button mDivision;
    private EditText mInputA, mInputB;
    private TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSubtraction = findViewById(R.id.subtraction);
        Button mMultiplication = findViewById(R.id.multiplication);
        mDivision = findViewById(R.id.division);
        mInputA = findViewById(R.id.inputA);
        mInputB = findViewById(R.id.inputB);
        mResult = findViewById(R.id.result);
        mMultiplication.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                double result = Double.parseDouble(mInputA.getText().toString())
                        * Double.parseDouble(mInputB.getText().toString());
                mResult.setText("Result: " + mInputA.getText().toString() + " * " + mInputB.getText().toString() + " = "
                + result);
            }
        });
        View.OnClickListener listener = new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (view == mDivision) {
                    double result = Double.parseDouble(mInputA.getText().toString())
                            / Double.parseDouble(mInputB.getText().toString());
                    mResult.setText("Result : " + mInputA.getText().toString() + " / " + mInputB.getText().toString() + " = "
                    + result);
                }
            }
        };
        mDivision.setOnClickListener(listener);
        mSubtraction.setOnClickListener(this);
    }
    @SuppressLint("SetTextI18n")
    public void summation(View view) {
        double result = Double.parseDouble(mInputA.getText().toString()) + Double.parseDouble(mInputB.getText().toString());
        mResult.setText("Result : " + mInputA.getText().toString() + " + " + mInputB.getText().toString() + " = " + result);
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        if (view == mSubtraction) {
            double result = Double.parseDouble(mInputA.getText().toString()) - Double.parseDouble(mInputB.getText().toString());
            mResult.setText("Result :" + mInputA.getText().toString() + " - " + mInputB.getText().toString() + " = " + result);
        }
    }
}
