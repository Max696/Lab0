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
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.myapplication.R.layout.support_simple_spinner_dropdown_item;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<Cancion> adapter;
    ArrayAdapter<Cancion> adap2;
    ArrayList<Cancion> PlayList;
    Cancion[] resultant;
    ListView lstV;
    ListView lstB;
    Map<String,Cancion> map;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PlayList = new ArrayList<>();
        map = new HashMap<>();

        lstV = findViewById(R.id.PlayList);
        lstB = findViewById(R.id.Busqueda);
        searchView = findViewById(R.id.buscador);

        //Creacion de todas las canciones
        map.put("Wait and Bleed",new Cancion("Slipknot","Wait and Bleed",1));
        map.put("Duality", new Cancion("Slipknot","Duality",0.5));
        map.put("The Devil in I",new Cancion("Slipknot","The Devil in I",4));
        map.put("Sentimental",new Cancion("Moderatto","Sentimental",3.2));
        map.put("In My Feelings",new Cancion("Drake","In My Feelings",3.37));
        map.put("Lucky You",new Cancion("Eminem","Lucky You",4.04));
        map.put("Fall",new Cancion("Eminem","Fall",4.22));
        map.put("SICKO MODE",new Cancion("Travis Scott","SICKO MODE",5.12));
        map.put("Happier",new Cancion("Marshmello","Happier",3.34));
        map.put("God's Plan",new Cancion("Drake","God's Plan",3.18));

        resultant = map.values().toArray(new Cancion[0]);

        adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, resultant);
        adap2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, PlayList);

        lstB.setAdapter(adapter);
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
                    adapter.getFilter().filter(text);
                }else{

                }

                return false;
            }
        });

        //CUANDO SELECIONAMOS UNA CANCION DEL LISTADO
        lstB.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cancion cancion = (Cancion) adapter.getItem(i);
                if (PlayList.contains(cancion)){
                    Toast.makeText(getBaseContext(), "Cancion ya agregada ",Toast.LENGTH_LONG).show();
                }else {
                    PlayList.add(cancion);
                    adap2.notifyDataSetChanged();
                    Toast.makeText(getBaseContext(), "Añadido " + cancion.getNombre(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void ordenAscendente(View v){
        Collections.sort(PlayList,name);
        adap2.notifyDataSetChanged();
    }
    public void ordenDescendente(View v){
        Collections.sort(PlayList, Collections.reverseOrder(name));
        adap2.notifyDataSetChanged();
    }
    public void ascendenteDuracion(View v){
        Collections.sort(PlayList);
        adap2.notifyDataSetChanged();
    }
    public void descendenteDuracion(View v){
        Collections.sort(PlayList, Collections.reverseOrder());
        adap2.notifyDataSetChanged();
    }
    public static Comparator<Cancion> name = new Comparator<Cancion>(){
        public int compare(Cancion c1, Cancion c2){
            return c1.getNombre().compareTo(c2.getNombre());
        }
    };

}

