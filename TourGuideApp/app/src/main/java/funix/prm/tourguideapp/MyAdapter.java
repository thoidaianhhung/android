package funix.prm.tourguideapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Item> {
    private ArrayList<Item> arrayList;
    MyAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Item> objects) {
        super(context, resource, objects);
        arrayList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        listItem = inflater.inflate(R.layout.mylist, null);

        ImageView imageView = listItem.findViewById(R.id.imageView);
        imageView.setImageResource(arrayList.get(position).getmImgId());

        TextView textViewTitle = listItem.findViewById(R.id.textViewTitle);
        textViewTitle.setText(arrayList.get(position).getmTitle());

        TextView subTextViewTitle = listItem.findViewById(R.id.subTextViewTitle);
        subTextViewTitle.setText(arrayList.get(position).getmSubtitle());

        return listItem;
    }
}
