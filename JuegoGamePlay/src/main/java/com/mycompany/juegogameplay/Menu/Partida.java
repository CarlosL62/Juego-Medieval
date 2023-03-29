package com.mycompany.juegogameplay.Menu;

import com.mycompany.juegogameplay.Objetos.Objetos;
import com.mycompany.juegogameplay.Personajes.*;

public class Partida{

    private Jugador jugador;
    private Jugables jugables[];
    private Tablero tablero;
    private Tienda tienda;
    private Objetos objetos[];
    private boolean primerPartida = true;

    public Partida() {
        System.out.println("Creando Partida");
    }

    public Partida(Tienda tienda, Tablero tablero, Jugador jugador, Jugables[] jugables, Objetos[] objetos) {
        this.tienda = tienda;
        this.tablero = tablero;
        this.jugador = jugador;
        this.objetos = objetos;
        this.jugables = jugables;
    }

    public void iniciarPartida() {
        Consola.LimpiarPantalla();
        //Si es la primera partida
        if (primerPartida) {
            //Bienvenida
            Consola.LimpiarPantalla();
            jugador.setUser(Consola.readString("Bienvenido aventurero, ¿cuál es tu nombre?"));
            Consola.LimpiarPantalla();
            System.out.println("Una nueva aventura nos espera, " + jugador.getUser());
            Consola.EnterContinuar();
            if (jugador.getUser().equals("RicoMcPato")) {
                jugador.setOro(999999);
            } else{
                jugador.setOro(500);
            }
            Consola.LimpiarPantalla();
            System.out.println("Se te acreditaron " + jugador.getOro() + " de oro");
            // primeraPartida = false;
            Consola.EnterContinuar();
            // Se abre la tienda, la selección de personajes y de mapa
            tienda.iniciarTienda();

            // Al finalizar su primera partida se marca como falso
            primerPartida = false;
        }

        //Nos dirijimos a batalla
        Batalla batalla = new Batalla(tienda, tablero, jugador, jugables, objetos);
        batalla.iniciarBatalla();
    }
}
