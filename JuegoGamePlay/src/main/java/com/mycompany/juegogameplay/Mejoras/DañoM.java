package com.mycompany.juegogameplay.Mejoras;

import com.mycompany.juegogameplay.Menu.Consola;
import com.mycompany.juegogameplay.Personajes.Jugables;

public class DañoM extends Mejoras{
    
    private int precio = 125;
    private String nombreMejora = "Mejora Daño";
    private String descripcion = "Le otorga al personaje 10 de daño al ataque";

    public DañoM(Jugables[] jugables){
        super.jugables = jugables;
        super.precio = precio;
        super.nombreMejora = nombreMejora;
        super.descripcion = descripcion;
    }

    @Override
    public void mejoraAAPlicar(String personaje){
        switch (personaje) {
            case "C":
                jugables[0].mejorarDaño();
                break;
            case "A":
                jugables[1].mejorarDaño();
                break;
            case "M":
                jugables[2].mejorarDaño();
                break;
            case "G":
                jugables[3].mejorarDaño();
                break;
            case "D":
                jugables[4].mejorarDaño();
                break;
            default:
                Consola.Invalido();
                break;
        }
    }
}
