package com.example.coldcallingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class UncalledLog extends AppCompatActivity {
    ListView listView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uncalled_log);
        Bundle e = getIntent().getExtras();
        listView3 = (ListView)findViewById(R.id.listview3);
        ArrayList<String> uncalled = new ArrayList<>();
        uncalled = e.getStringArrayList("key");

        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, uncalled);
        listView3.setAdapter(arrayAdapter);
    }
}