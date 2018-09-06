package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.myapplication.R.layout.support_simple_spinner_dropdown_item;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<Cancion> adapter;
    ArrayAdapter<Cancion> adap2;
    ArrayList<Cancion> PlayList;
    Cancion cancion;
    Cancion[] resultant;
    Cancion[] intento;
    ListView lstV;
    Map<String,Cancion> map;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PlayList = new ArrayList<>();
        lstV = findViewById(R.id.PlayList);
        searchView = findViewById(R.id.buscador);

        map = new HashMap<>();

        map.put("Wait and Bleed",new Cancion("Slipknot","Wait and Bleed",2));
        map.put("Duality", new Cancion("Slipknot","Duality",2));
        map.put("The Devil in I",new Cancion("Slipknot","The Devil in I",2));

        resultant = map.values().toArray(new Cancion[0]);
        intento = resultant;
        intento[0] = new Cancion("Rock","Wait n Bleed",2);

        adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, resultant);
        adap2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, intento);

        lstV.setAdapter(adap2);

        //Boton de busqueda
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                if (map.containsKey(text)) {

                    lstV.setAdapter(adapter);
                    adapter.getFilter().filter(text);
                }else{
                    lstV.setAdapter(adap2);
                }

                return false;
            }
        });

        //CUANDO SELECIONAMOS UNA CANCION DEL LISTADO
        lstV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cancion cancion = (Cancion) adapter.getItem(i);
                PlayList.add(cancion);
                Toast.makeText(getBaseContext(), "Añadido " + cancion.getNombre(),Toast.LENGTH_LONG).show();
            }
        });


    }

}
