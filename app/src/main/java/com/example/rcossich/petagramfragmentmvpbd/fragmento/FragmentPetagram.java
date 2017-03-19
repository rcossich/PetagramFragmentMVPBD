package com.example.rcossich.petagramfragmentmvpbd.fragmento;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rcossich.petagramfragmentmvpbd.R;
import com.example.rcossich.petagramfragmentmvpbd.adaptador.MascotaAdaptador;
import com.example.rcossich.petagramfragmentmvpbd.modelo.Mascota;
import com.example.rcossich.petagramfragmentmvpbd.presentador.FragmentPetagramPresenter;
import com.example.rcossich.petagramfragmentmvpbd.presentador.IFragmentPetagramPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPetagram extends Fragment implements IFragmentPetagramView {


    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IFragmentPetagramPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_petagram,container,false); //equivale a asignarle la clase al layout

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new FragmentPetagramPresenter(this,getContext());
        return v;
    }

    public void inicializarAdaptador(){
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());
        return adaptador;

    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}
