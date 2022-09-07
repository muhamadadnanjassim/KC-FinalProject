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

public class historyAdapter extends ArrayAdapter<Item> {


    List<Item> itemsList;

    public historyAdapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
        itemsList = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.activity_item_row, parent, false);
        Item currentItem = itemsList.get(position);

        TextView count = v.findViewById(R.id.txt_CStep);
        TextView step = v.findViewById(R.id.txt_Step);
        TextView day = v.findViewById(R.id.txt_day);

        String count1 = String.valueOf(currentItem.getCount());
        count.setText(count1);
        day.setText(String.valueOf(currentItem.getDay()));

        ImageView delete = v.findViewById(R.id.delet);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemsList.remove(position);
                notifyDataSetChanged();
            }
        });

        return v;
    }
}
