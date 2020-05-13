package funix.prm.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvName = findViewById(R.id.tvName);
        Button btnGetName = findViewById(R.id.btnGetName);
        Button btnUpdate = findViewById(R.id.btnUpdateName);
        final MyDbHelper myDbHelper = new MyDbHelper(getApplicationContext());
        Student student = new Student(1, "Nguyễn Văn Hùng", "Hà Nội", "0386625869");
        myDbHelper.addStudent(student);
        btnGetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = myDbHelper.getStudent(1).getName();
                tvName.setText(name);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student1 = myDbHelper.getStudent(1);
                student1.setName("Nguyễn Đức Cường");
                myDbHelper.updateStudent(student1);
                String name = myDbHelper.getStudent(1).getName();
                tvName.setText(name);
            }
        });
    }
}
