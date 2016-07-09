package com.dfuentes.petgram.Pojo;

import android.content.ContentValues;
import android.content.Context;

import com.dfuentes.petgram.R;
import com.dfuentes.petgram.db.BaseDatos;
import com.dfuentes.petgram.db.ConstantesBaseDatos;

import java.util.ArrayList;

/**
 * Created by inavid on 06/07/16.
 */
public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascotas> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        insertarCincoMascotas(db);
        return  db.obtenerTodasLasMascotas();
    }

    public void insertarCincoMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Putin");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.recurso_1);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Gordi");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.recurso_5);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Aurelio");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.recurso_4);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Rasputio");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.recurso_2);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Machoman");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.recurso_3);

        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascotas mascotas){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA, mascotas.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_LIKES_LIKE, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascotas mascotas){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascotas);
    }


}
