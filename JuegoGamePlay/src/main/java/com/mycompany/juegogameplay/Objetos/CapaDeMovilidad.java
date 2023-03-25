package com.mycompany.juegogameplay.Objetos;

public class CapaDeMovilidad extends Objetos{

    private String nombreObjeto = "Capa de movilidad";
    private String descripcion = "Mueve al personaje una casilla alrededor";
    private int cantidadDisponible = 0;
    private int precio = 75;

    public CapaDeMovilidad(){
        super.nombreObjeto = nombreObjeto;
        super.descripcion = descripcion;
        super.precio = precio;
        super.cantidadDisponible = cantidadDisponible;
    }
}
