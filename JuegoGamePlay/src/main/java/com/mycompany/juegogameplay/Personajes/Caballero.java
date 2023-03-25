package com.mycompany.juegogameplay.Personajes;

import com.mycompany.juegogameplay.Menu.Consola;
import com.mycompany.juegogameplay.Menu.Jugador;

public class Caballero extends Jugables{

    private boolean disponible = false;
    private int vida = 300;
    private int daño = 45;

    public Caballero() {
        super.caracter = "C";
        super.caracterImpreso = (purple+caracter+reset);
        super.disponible = disponible;
        super.personaje = "Caballero";
        super.vida = vida;
        super.daño = daño;
        super.tipoMovimiento = "Tierra, un cuadro por turno";
        super.tipoAtaque = "Golpea con su espada a todos a su alrededor";

        //Variables de tipo
        tipoPersonaje = 1;
    }
}
