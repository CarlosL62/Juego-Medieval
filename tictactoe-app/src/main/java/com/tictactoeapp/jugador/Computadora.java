package com.tictactoeapp.jugador;

import com.tictactoeapp.Coordenada;

public class Computadora extends Jugador {

    public Computadora(String nombre) {
        super(nombre);
    }


    @Override
    public String toString() {
        return "[Computadora] Nombre: "+this.nombre;
    }


    @Override
    public Coordenada getCoordenada() {
        //random
        //verificar si los espacios estan en blanco
        return new Coordenada(1,1);
    }
}
