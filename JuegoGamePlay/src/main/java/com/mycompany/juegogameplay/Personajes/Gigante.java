package com.mycompany.juegogameplay.Personajes;

public class Gigante extends Jugables {

    private boolean disponible = false;
    private int vida = 150;
    private int daño = 100;
    private int movimientoMax = 1;

    public Gigante() {
        super.caracter = "G";
        super.caracterImpreso = (purple+caracter+reset);
        super.disponible = disponible;
        super.movimientoMax = movimientoMax;
        super.personaje = "Gigante";
        super.vida = vida;
        super.daño = daño;
        super.tipoMovimiento = "Tierra, un cuadro por turno";
        super.tipoAtaque = "Golpea con su brazo, lo que le hace daño a todos los enemigos/obstáculos en una línea en un rango de 3 cuadros";
    }
}
