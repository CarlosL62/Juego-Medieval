package com.mycompany.juegogameplay.Objetos;

public class ElixirVerde extends Objetos{

    private String nombreObjeto = "Elixir verde";
    private String descripcion = "Cura 50 de la vida";
    private int cantidadDisponible = 0;
    private int precio = 25;

    public ElixirVerde(){
        super.nombreObjeto = nombreObjeto;
        super.descripcion = descripcion;
        super.precio = precio;
        super.cantidadDisponible = cantidadDisponible;
    }
}
