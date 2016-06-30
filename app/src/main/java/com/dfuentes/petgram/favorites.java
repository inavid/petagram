package com.dfuentes.petgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.dfuentes.petgram.Adapters.MascotaAdaptador;
import com.dfuentes.petgram.Pojo.Mascotas;

import java.util.ArrayList;

public class Favorites extends AppCompatActivity {

    ArrayList<Mascotas> mascotas;
    private RecyclerView ListaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miappbar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ListaMascotas = (RecyclerView) findViewById(R.id.rvMascotasF);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        ListaMascotas.setLayoutManager(llm);

        inicializaMascotas();
        inicializaAdaptador();
    }

    public void inicializaAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        ListaMascotas.setAdapter(adaptador);
    }

    public void inicializaMascotas(){
        mascotas  = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas("Gordi", R.drawable.recurso_5, "5"));
        mascotas.add(new Mascotas("Aurelio", R.drawable.recurso_4, "5"));
        mascotas.add(new Mascotas("rasputio", R.drawable.recurso_3, "2"));
        mascotas.add(new Mascotas("putin", R.drawable.recurso_1, "1"));
        mascotas.add(new Mascotas("machoman", R.drawable.recurso_2, "0"));
    }
}
