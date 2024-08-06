package com.spring_app.Entidad;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//creacion de un constructor sin codigo con spring boot de todas las propiedades
@AllArgsConstructor
public class Producto {
    private int idProducto;
    private String descripcion;
    private int cantidad;
    private double precio;
/*
    este es el constructor pero como ya tenemos el @AllArgtsContuctor ya lo hace por si solo
    public Producto(int idProducto, String descripcion, int cantidad, double precio) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }
 */
}
