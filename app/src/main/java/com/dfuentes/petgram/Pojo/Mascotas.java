package com.dfuentes.petgram.Pojo;

/**
 * Created by inavid on 24/06/16.
 */
public class Mascotas {

    private String Nombre;
    private int Foto;
    private String Rate;

    public Mascotas(String nombre, int foto, String rate) {
        this.Nombre = nombre;
        this.Foto = foto;
        this.Rate = rate;
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

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }
}
