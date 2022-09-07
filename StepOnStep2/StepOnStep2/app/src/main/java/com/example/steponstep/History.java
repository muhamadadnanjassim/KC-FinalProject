package com.example.steponstep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class History extends AppCompatActivity {
    ArrayList<Item> items = new ArrayList<>();
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        back = findViewById(R.id.back);


        Item S1 = new Item("Today", 4300);
        Item S2 = new Item("yesterday",2134);
        Item S3 = new Item("sunday",3567);
        Item S4 = new Item("monday",7456);
        Item S5 = new Item("tuesday",5345);
        Item S6 = new Item("wednesday",11234);
        Item S7 = new Item("thursday", 1300);
        Item S8 = new Item("friday",2134);
        Item S9 = new Item("saturday",8567);
        Item S10 = new Item("12/3",15456);
        Item S11 = new Item("11/3",1945);
        Item S12 = new Item("10/3",10234);

        items.add(S1);
        items.add(S2);
        items.add(S3);
        items.add(S4);
        items.add(S5);
        items.add(S6);
        items.add(S7);
        items.add(S8);
        items.add(S9);
        items.add(S10);
        items.add(S11);
        items.add(S12);

        ListView listView = findViewById(R.id.listview);

        historyAdapter i = new historyAdapter(this,0,items);

        listView.setAdapter(i);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(History.this,Home_Screen.class);
                startActivity(intent);
            }
        });

    }
}