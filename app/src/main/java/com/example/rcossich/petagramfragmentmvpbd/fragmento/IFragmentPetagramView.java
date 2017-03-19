package com.example.rcossich.petagramfragmentmvpbd.fragmento;

import com.example.rcossich.petagramfragmentmvpbd.adaptador.MascotaAdaptador;
import com.example.rcossich.petagramfragmentmvpbd.modelo.Mascota;

import java.util.ArrayList;

/**
 * Created by rcossich on 17/03/2017.
 */

public interface IFragmentPetagramView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
