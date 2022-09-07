package com.example.steponstep;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StoreAdapter extends ArrayAdapter {

    List<StoreItem> storeItemList;

    public StoreAdapter(@NonNull Context context, int resource, @NonNull List<StoreItem> objects) {
        super(context, resource, objects);
        storeItemList = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.store_row, parent, false);
        StoreItem currentStore = storeItemList.get(position);

        TextView Name = v.findViewById(R.id.name);
        TextView CpName = v.findViewById(R.id.cpname);
        ImageView CpImage = v.findViewById(R.id.cpimage);

        Name.setText(currentStore.getItemName());
        CpName.setText(currentStore.getCpName());
        CpImage.setImageResource(currentStore.getCpImage());

        return v;
    }
}
