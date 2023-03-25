package com.mycompany.juegogameplay.Personajes;

import com.mycompany.juegogameplay.Menu.Consola;
import com.mycompany.juegogameplay.Menu.Jugador;

public class Mago extends Jugables{

    private boolean disponible = false;
    private int vida = 100;
    private int daño = 60;

    public Mago() {
        super.caracter = "M";
        super.caracterImpreso = (purple+caracter+reset);
        super.disponible = disponible;
        super.personaje = "Mago";
        super.vida = vida;
        super.daño = daño;
        super.tipoMovimiento = "Vuela, hasta tres cuadros por turno";
        super.tipoAtaque = "Dispara un hechizo hacía el final de una línea que impacta en el primer enemigo/obstáculo que se encuentre";
    }
}
