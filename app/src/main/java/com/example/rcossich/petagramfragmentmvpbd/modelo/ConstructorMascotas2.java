package com.example.rcossich.petagramfragmentmvpbd.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.widget.Toast;

import com.example.rcossich.petagramfragmentmvpbd.R;
import com.example.rcossich.petagramfragmentmvpbd.db.BaseDatos;
import com.example.rcossich.petagramfragmentmvpbd.db.ConstantesBaseDatos;

import java.util.ArrayList;


/**
 * Created by rcossich on 19/03/2017.
 */

public class ConstructorMascotas2 {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas2(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatosLikes() {
        BaseDatos db = new BaseDatos(context);
        //Toast.makeText(context,"Obteniendo mascotas (maximo 5) con los likes mas recientes ",Toast.LENGTH_SHORT).show();
        return  db.obtenerCincoMascotasConLikesMasRecientes();
    }
}
