package com.mycompany.juegogameplay.Personajes;

public class Arquero extends Jugables {

    private boolean disponible = false;
    private int vida = 150;
    private int daño = 100;
    private int movimientoMax = 3;

    public Arquero() {
        super.caracter = "A";
        super.caracterImpreso = (purple + caracter + reset);
        super.disponible = disponible;
        super.movimientoMax = movimientoMax;
        super.personaje = "Arquero";
        super.vida = vida;
        super.daño = daño;
        super.tipoMovimiento = "Tierra, tres cuadros por turno";
        super.tipoAtaque = "Dispara una flecha a cualquier punto en un rango de tres casillas, en cualquiera de las líneas";
    }
}
