package funix.prm.tourguideapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class HospitalFragment extends Fragment {
    // Declare list view
    ListView simpleList;
    // Declare hospital list
    ArrayList<Item> hospitalList = new ArrayList<Item>();

    // Return a View component from this method
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hospital, container, false);
        simpleList = view.findViewById(R.id.list_hospital);
        hospitalList.add(new Item(R.drawable.hospital, "Bệnh viện Bạch Mai",
                "78 – Đường Giải Phóng – Phương Mai – Đống Đa – Hà Nội"));
        hospitalList.add(new Item(R.drawable.hospital, "Bệnh Viện Hữu Nghị",
                "Số 1 – Trần Khánh Dư – Quận Hai Bà Trưng – Hà Nội"));
        hospitalList.add(new Item(R.drawable.hospital, "Bệnh Viện Tai Mũi Họng Trung Ương",
                "78 – Đường Giải Phóng – Quận Đống Đa – Hà Nội"));
        // Declare the class MyAdapter object adapter
        MyAdapter adapter = new MyAdapter(getContext(), R.layout.mylist, hospitalList);
        simpleList.setAdapter(adapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Toast.makeText(getContext(), "78 – Đường Giải Phóng – Phương Mai – Đống Đa – Hà Nội",
                            Toast.LENGTH_SHORT).show();
                }
                if (i == 1) {
                    Toast.makeText(getContext(), "Số 1 – Trần Khánh Dư – Quận Hai Bà Trưng – Hà Nội",
                            Toast.LENGTH_SHORT).show();
                }
                if (i == 2) {
                    Toast.makeText(getContext(), "78 – Đường Giải Phóng – Quận Đống Đa – Hà Nội",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

}
