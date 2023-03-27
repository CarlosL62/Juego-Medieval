package com.tictactoeapp;

import com.tictactoeapp.jugador.AdminJugadores;

public class TicTacToe {
    //variables de instancia
    //variables globales
    private AdminJugadores adminJugadores;
    private Partida partida;
    private Estadistica estadistica;

    public TicTacToe(){
        System.out.println("creando tictactoe");
        adminJugadores = new AdminJugadores();
        estadistica = new Estadistica();        
        System.out.println("terminando de creando tictactoe");
    }

    public void menuPrincipal(){
        int opcionMenu = 0;

        do {
            Consola.limpiarPantalla();
            Consola.printTitle("Bienvenido a Menu Principal");
            Consola.printLine("1). Admin jugadores");
            Consola.printLine("2). Jugar partida");
            Consola.printLine("3). Estadistica");
            Consola.printLine("4). Salir");
            opcionMenu = Consola.readInt("Ingrese la opcion deseada:");

            if (opcionMenu == 1){
                //esto no se hace
                //AdminJugadores adminJug = new AdminJugadores();
                //adminJug.menu();
                //fin de esto no se hace
                adminJugadores.menu();//me quede esperando
            }
            if (opcionMenu == 2){
                //Partida partidaTemporal = new Partida(adminJugadores);
                partida = new Partida(adminJugadores,estadistica);
                partida.jugar();
            }
            if (opcionMenu == 3){
                estadistica.listarEstadisticas();
            }
            
        } while (opcionMenu != 4 );
    }


}
