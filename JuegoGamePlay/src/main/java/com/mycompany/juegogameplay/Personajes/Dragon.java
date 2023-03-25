package com.mycompany.juegogameplay.Personajes;

import com.mycompany.juegogameplay.Menu.Consola;
import com.mycompany.juegogameplay.Menu.Jugador;

public class Dragon extends Jugables {
    
    private boolean disponible = false;
    private int vida = 150;
    private int daño = 100;

    public Dragon() {
        super.caracter = "D";
        super.caracterImpreso = (purple+caracter+reset);
        super.disponible = disponible;
        super.personaje = "Dragon";
        super.vida = vida;
        super.daño = daño;
        super.tipoMovimiento = "Vuela, hasta tres cuadros por turno";
        super.tipoAtaque = "En línea y en un rango de dos cuadros a todo lo que esté en dicho rango";
    }
}
