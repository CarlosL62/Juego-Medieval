package com.tictactoeapp.jugador;

import com.tictactoeapp.Coordenada;

public abstract class Jugador {

    protected String nombre;

    public Jugador(String nombre){
        this.nombre = nombre;
    }

    public abstract Coordenada getCoordenada();

}
