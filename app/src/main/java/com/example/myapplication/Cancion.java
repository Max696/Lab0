package com.example.myapplication;
import android.support.annotation.NonNull;

public class Cancion implements Comparable<Cancion>{

    private String artista;
    private String nombre;
    private double duracion;


    Cancion(String Artista, String Nombre, double Duracion) {
        this.artista = Artista;
        this.nombre = Nombre;
        this.duracion= Duracion;
    }

    public String getNombre()
    {
        return  this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String toString()
    {
        return nombre + "-"+ artista+"-"+ String.valueOf(duracion);
    }
    @Override
    public int compareTo(Cancion toCompare) {
        if(this.duracion < toCompare.duracion)
        {
            return -1;
        }
        else if (toCompare.duracion < this.duracion)
        {
            return 1;
        }
        return 0;
    }
}
