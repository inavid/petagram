package com.dfuentes.petgram.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dfuentes.petgram.Adapters.MascotaAdaptador;
import com.dfuentes.petgram.Pojo.Mascotas;
import com.dfuentes.petgram.R;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    ArrayList<Mascotas> mascotas;
    private RecyclerView ListaMascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        ListaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        ListaMascotas.setLayoutManager(llm);

        this.inicializaMascotas();
        inicializaAdaptador();

        return v;
    }

    public void inicializaAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        ListaMascotas.setAdapter(adaptador);
    }

    public void inicializaMascotas(){
        mascotas  = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas("putin", R.drawable.recurso_1, "1"));
        mascotas.add(new Mascotas("machoman", R.drawable.recurso_2, "0"));
        mascotas.add(new Mascotas("rasputio", R.drawable.recurso_3, "2"));
        mascotas.add(new Mascotas("Aurelio", R.drawable.recurso_4, "5"));
        mascotas.add(new Mascotas("Gordi", R.drawable.recurso_5, "5"));
    }

}
