package com.tictactoeapp;

import com.tictactoeapp.jugador.AdminJugadores;
import com.tictactoeapp.jugador.Jugador;

public class Partida {

    private AdminJugadores adminJugadores;
    private Estadistica estadistica;
    private Jugador[] jugadores;
    
    public Partida(AdminJugadores adminJugadores, Estadistica estadistica){
        this.adminJugadores = adminJugadores;
        this.estadistica = estadistica;
        jugadores = new Jugador[2];
        //System.out.println("Creando partida");
    }

    public void jugar() {
        inicializar();
        Consola.limpiarPantalla();
        System.out.println("jugando partida, faltan especificar los jugadores");
        Consola.enterContinuar();
    }

    //verificar que todo este en su lugar antes de iniciar
    // el juego
    public void inicializar() {
        int jugadoresExistentes = adminJugadores.dimeCuantosJugadoresHay();
        if ( jugadoresExistentes < 2){
            //crear jugadores
            for (int i = 0; i < (2-jugadoresExistentes); i++) {
                adminJugadores.agregarJugador();
            }
        }
        //seleccionar
        jugadores = adminJugadores.seleccionarDosJugadores();
        adminJugadores.listarJugadores();
        //inicializar mi tablero 
        // solo eso

    }
}
