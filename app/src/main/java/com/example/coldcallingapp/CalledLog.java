package com.example.coldcallingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class CalledLog extends AppCompatActivity {
    ListView listView;
    ListView listView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_called_log);
        listView = (ListView)findViewById(R.id.listview);
        listView2 = (ListView)findViewById(R.id.listview2);
        Bundle e = getIntent().getExtras();

        ArrayList <String> called = new ArrayList<>();
        called = e.getStringArrayList("key");

        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, called);
        listView.setAdapter(arrayAdapter);

        ArrayList <String> number  = new ArrayList<>();
        number = e.getStringArrayList("num");

        ArrayAdapter arrayAdapter2=new ArrayAdapter(this,android.R.layout.simple_list_item_1, number);
        listView2.setAdapter(arrayAdapter2);
    }
}