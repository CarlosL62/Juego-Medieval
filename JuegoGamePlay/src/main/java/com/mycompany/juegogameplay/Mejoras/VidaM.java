package com.mycompany.juegogameplay.Mejoras;

import com.mycompany.juegogameplay.Menu.Consola;
import com.mycompany.juegogameplay.Personajes.Jugables;

public class VidaM extends Mejoras{
    
    private int precio = 80;
    private String nombreMejora = "Mejora Vida";
    private String descripcion = "Le otorga al personaje 50 de vida máxima";

    public VidaM(Jugables[] jugables){
        super.jugables = jugables;
        super.precio = precio;
        super.nombreMejora = nombreMejora;
        super.descripcion = descripcion;
    }

    @Override
    public void mejoraAAPlicar(String personaje){
        switch (personaje) {
            case "C":
                jugables[0].mejorarVida();
                break;
            case "A":
                jugables[1].mejorarVida();
                break;
            case "M":
                jugables[2].mejorarVida();
                break;
            case "G":
                jugables[3].mejorarVida();
                break;
            case "D":
                jugables[4].mejorarVida();
                break;
            default:
                Consola.Invalido();
                break;
        }
    }
}
