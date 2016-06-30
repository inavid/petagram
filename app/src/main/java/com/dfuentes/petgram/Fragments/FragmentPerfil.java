package com.dfuentes.petgram.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.dfuentes.petgram.Adapters.MascotaAdaptador;
import com.dfuentes.petgram.Adapters.PerfilAdaptador;
import com.dfuentes.petgram.Pojo.Mascotas;
import com.dfuentes.petgram.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPerfil extends Fragment {

    private CircularImageView circularImageView;
    ArrayList<Mascotas> mascotas;
    private RecyclerView ListaMascotas;



    public FragmentPerfil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        circularImageView = (CircularImageView) getActivity().findViewById(R.id.circularImage);

        View v = inflater.inflate(R.layout.fragment_fragment_perfil, container, false);

        /**ListaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);

        ListaMascotas.setLayoutManager(llm);

        inicializaMascotas();
        inicializaAdaptador(); */

        // Inflate the layout for this fragment
        return v;
    }

    public void inicializaAdaptador(){
        PerfilAdaptador adaptador = new PerfilAdaptador(mascotas, getActivity());
        ListaMascotas.setAdapter(adaptador);
    }

    public void inicializaMascotas(){
        mascotas  = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas("1", R.drawable.recurso_5, "1"));
        mascotas.add(new Mascotas("2", R.drawable.recurso_5, "0"));
        mascotas.add(new Mascotas("3", R.drawable.recurso_5, "2"));

    }

}
