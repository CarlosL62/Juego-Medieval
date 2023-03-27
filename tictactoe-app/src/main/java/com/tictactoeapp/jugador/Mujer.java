package com.tictactoeapp.jugador;

public class Mujer extends Humano {

    public Mujer(String nombre) {
        super(nombre);
        
    }

    @Override
    public String toString() {
        return "[Humano-Mujer] Nombre: "+this.nombre;
    }
    
}
