package com.dfuentes.petgram.Pojo;

/**
 * Created by inavid on 24/06/16.
 */
public class Mascotas {

    private int id;
    private String Nombre;
    private int Foto;
    private int Rate = 0;

    public Mascotas(String nombre, int foto, int rate) {
        this.Nombre = nombre;
        this.Foto = foto;
        this.Rate = rate;
    }

    public Mascotas() {

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }

    public int getRate() {
        return Rate;
    }

    public void setRate(int rate) {
        Rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
