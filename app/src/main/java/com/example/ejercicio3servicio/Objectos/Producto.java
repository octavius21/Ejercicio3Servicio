package com.example.ejercicio3servicio.Objectos;

import android.content.Context;

import java.io.Serializable;

public class Producto implements Serializable {
    private int id,precio,delivery;
    private String name,provider;
    private String thumbnail_url;
    private Context contexto;

    public Producto(int id, int precio, int delivery, String name, String provider, String thumbnail_url, Context contexto) {
        this.id = id;
        this.precio = precio;
        this.delivery = delivery;
        this.name = name;
        this.provider = provider;
        this.thumbnail_url = thumbnail_url;
        this.contexto = contexto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCosto() {
        return delivery;
    }

    public void setCosto(int delivery) {
        this.delivery = delivery;
    }

    public String getNombbre() {
        return name;
    }

    public void setNombbre(String name) {
        this.name = name;
    }

    public String getProveedor() {
        return provider;
    }

    public void setProveedor(String provider) {
        this.provider = provider;
    }

    public String getImagen() {
        return thumbnail_url;
    }

    public void setImagen(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }
}
