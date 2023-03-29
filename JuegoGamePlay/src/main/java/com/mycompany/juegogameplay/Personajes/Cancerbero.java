package com.mycompany.juegogameplay.Personajes;

public class Cancerbero extends Enemigos{
    
    private int vida = 400;
    private int daño = 45;

    public Cancerbero() {
        super.caracter = "E";
        super.caracterImpreso = (red+caracter+reset);
        super.movimientoMax = 1;
        super.personaje = "Cancerbero";
        super.vida = vida;
        super.daño = daño;
        super.tipoMovimiento = "Tierra, un cuadro por turno";
        super.tipoAtaque = "Incendia todo a su alrededor, en un rango de un cuadro";
    }

}
