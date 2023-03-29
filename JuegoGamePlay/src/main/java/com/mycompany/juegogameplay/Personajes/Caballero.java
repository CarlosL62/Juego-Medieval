package com.mycompany.juegogameplay.Personajes;

public class Caballero extends Jugables{

    private boolean disponible = false;
    private int vida = 300;
    private int daño = 45;
    private int movimientoMax = 1;

    public Caballero() {
        super.caracter = "C";
        super.caracterImpreso = (purple+caracter+reset);
        super.disponible = disponible;
        super.movimientoMax = movimientoMax;
        super.personaje = "Caballero";
        super.vida = vida;
        super.daño = daño;
        super.tipoMovimiento = "Tierra, un cuadro por turno";
        super.tipoAtaque = "Golpea con su espada a todos a su alrededor";
    }
}
