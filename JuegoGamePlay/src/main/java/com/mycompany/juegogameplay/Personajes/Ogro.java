package com.mycompany.juegogameplay.Personajes;

public class Ogro extends Enemigos{
    
    private int vida = 300;
    private int daño = 50;

    public Ogro() {
        super.caracter = "O";
        super.caracterImpreso = (red+caracter+reset);
        super.movimientoMax = 1;
        super.personaje = "Ogro";
        super.vida = vida;
        super.daño = daño;
        super.tipoMovimiento = "Tierra, un cuadro a la vez";
        super.tipoAtaque = "Golpea con su bastón a un punto en un rango de un cuadro a su alrededor";
    }

}
