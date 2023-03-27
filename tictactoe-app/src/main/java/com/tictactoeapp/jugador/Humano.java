package com.tictactoeapp.jugador;

import com.tictactoeapp.Consola;
import com.tictactoeapp.Coordenada;

public class Humano extends Jugador {

    public Humano(String nombre) {
        super(nombre);
    }

    @Override
    public String toString() {
        return "[Humano] Nombre: "+this.nombre;
    }

    @Override
    public Coordenada getCoordenada() {
        Consola.printLine("Seleccione coordenada");        
        int x = Consola.readInt("Seleccione posicion en x: ");
        int y = Consola.readInt("Seleccione posicion en y: ");
        return new Coordenada(x, y);
    }

    
}
