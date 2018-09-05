package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView listaCanciones;
    SearchView searchView;
    Map<String,String> map;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        map = new HashMap<String,String>();
        searchView = (SearchView) findViewById(R.id.buscador);



        map.put("Hola","x");
        map.put("K dice","x");
        map.put("Colega","x");

        String[] key = map.keySet().toArray(new String[0]);
        listaCanciones = findViewById(R.id.songs);
        adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,key);
        listaCanciones.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
            adapter.getFilter().filter(text);
                return false;
            }
        });

    }
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);
    }
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
}
