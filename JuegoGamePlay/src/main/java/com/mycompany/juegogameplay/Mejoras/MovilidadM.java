package com.mycompany.juegogameplay.Mejoras;

import com.mycompany.juegogameplay.Menu.Consola;
import com.mycompany.juegogameplay.Personajes.Jugables;

public class MovilidadM extends Mejoras{
    
    public int precio = 500;
    public String nombreMejora = "Mejora Movilidad";
    public String descripcion = "Le otorga al personaje 1 casilla adicional de movimiento";

    public MovilidadM(Jugables[] jugables){
        super.jugables = jugables;
        super.precio = precio;
        super.nombreMejora = nombreMejora;
        super.descripcion = descripcion;
    }

    @Override
    public void mejoraAAPlicar(String personaje){
        switch (personaje) {
            case "C":
                jugables[0].mejorarMovilidad();
                break;
            case "A":
                jugables[1].mejorarMovilidad();
                break;
            case "M":
                jugables[2].mejorarMovilidad();
                break;
            case "G":
                jugables[3].mejorarMovilidad();
                break;
            case "D":
                jugables[4].mejorarMovilidad();
                break;
            default:
                Consola.Invalido();
                break;
        }
    }
}
