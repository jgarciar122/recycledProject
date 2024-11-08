
package com.example.recyclerapp;

public class Item {

    String nombre;
    String descripcion;
    int image;
    String tipo;

    public Item(String nombre, String descripcion, int image, String tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.image = image;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTipo() {
        return tipo; //
    }

    public void setTipo(String tipo) {
        this.tipo = tipo; // Método para establecer el tipo
    }


}
