package com.mycompany.juegogameplay.Objetos;

public class SemillaDeLaVida extends Objetos{
    
    private String nombreObjeto = "Semilla de la vida";
    private String descripcion = "Resucita a uno de los personajes";
    private int cantidadDisponible = 0;
    private int precio = 50;

    public SemillaDeLaVida(){
        super.nombreObjeto = nombreObjeto;
        super.descripcion = descripcion;
        super.precio = precio;
        super.cantidadDisponible = cantidadDisponible;
    }
}
