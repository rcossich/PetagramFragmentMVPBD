package com.example.rcossich.petagramfragmentmvpbd;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.rcossich.petagramfragmentmvpbd.adaptador.MascotaAdaptador2;
import com.example.rcossich.petagramfragmentmvpbd.db.BaseDatos;
import com.example.rcossich.petagramfragmentmvpbd.modelo.ConstructorMascotas;
import com.example.rcossich.petagramfragmentmvpbd.modelo.ConstructorMascotas2;
import com.example.rcossich.petagramfragmentmvpbd.modelo.Mascota;


public class Favoritos extends AppCompatActivity {

    private ArrayList<Mascota> mascotas2;
    private RecyclerView listaMascotas2;
    private ConstructorMascotas2 constructorMascotas2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listaMascotas2 = (RecyclerView) findViewById(R.id.rvMascotas2);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas2.setLayoutManager(llm);
        //Toast.makeText(this,"Antes de llamar a constructorMascotas2.obtenerDatosLikes",Toast.LENGTH_LONG).show();
        inicializarListaMascotas2();
        inicializarAdaptador2();
    }
    /*
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_opciones,menu);
            return true;
        }
    */
    public void inicializarAdaptador2(){
        MascotaAdaptador2 adaptador = new MascotaAdaptador2(mascotas2);
        listaMascotas2.setAdapter(adaptador);
    }
    public void inicializarListaMascotas2() {

        mascotas2 = new ArrayList<Mascota>();
        constructorMascotas2 = new ConstructorMascotas2(this);
        mascotas2 = constructorMascotas2.obtenerDatosLikes();
        if (mascotas2.size()<=0) {
            Toast.makeText(this,"NO EXISTEN LIKES REGISTRADOS!!!", Toast.LENGTH_LONG).show();
        }

        // Las 3 lineas que vienen se probaron para hacer la llamada directa desde aca, se reemplazaron por las dos anteriores.
       /* BaseDatos db = new BaseDatos(this);
        Toast.makeText(this,"Obteniendo mascotas (maximo 5) con los likes mas recientes ",Toast.LENGTH_SHORT).show();
        mascotas2 = db.obtenerCincoMascotasConLikesMasRecientes(); */
       /* mascotas2.add(new Mascota(R.drawable.dog_pet_02,"Mascota 02",9));
        mascotas2.add(new Mascota(R.drawable.dog_pet_07,"Mascota 07",7));
        mascotas2.add(new Mascota(R.drawable.dog_pet_12,"Mascota 12",8));
        mascotas2.add(new Mascota(R.drawable.dog_pet_14,"Mascota 14",6));
        mascotas2.add(new Mascota(R.drawable.dog_pet_15,"Mascota 15",2)); */

    }
}
