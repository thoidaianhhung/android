package funix.prm.contentprovider;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.loader.content.CursorLoader;

import java.util.ArrayList;

@SuppressLint("Registered")
public class ShowAllContactActivity extends Activity {
    private static final String URI = "Content://contacts/people";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_contact);

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        showAllContacts();
    }

    public void showAllContacts() {
        Uri uri = Uri.parse(URI);
        ArrayList<String> list = new ArrayList<>();
        CursorLoader loader = new CursorLoader(this, uri,  null, null,
                null, null);
        Cursor cursor = loader.loadInBackground();
        assert cursor != null;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String s = "";
            String idColumnName = ContactsContract.Contacts._ID;
            int idIndex = cursor.getColumnIndex(idColumnName);
            s = cursor.getString(idIndex) + " - ";
            String nameColumnName = ContactsContract.Contacts.DISPLAY_NAME;
            int nameIndex = cursor.getColumnIndex(nameColumnName);
            s += cursor.getString(nameIndex);
            cursor.moveToNext();
            list.add(s);
        }
        cursor.close();
        ListView listView = findViewById(R.id.listContact);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }
}
