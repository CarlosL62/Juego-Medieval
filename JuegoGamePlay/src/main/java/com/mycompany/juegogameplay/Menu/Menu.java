package com.mycompany.juegogameplay.Menu;

import com.mycompany.juegogameplay.Objetos.CapaDeMovilidad;
import com.mycompany.juegogameplay.Objetos.ElixirVerde;
import com.mycompany.juegogameplay.Objetos.Objetos;
import com.mycompany.juegogameplay.Objetos.SemillaDeLaVida;
import com.mycompany.juegogameplay.Personajes.Arquero;
import com.mycompany.juegogameplay.Personajes.Caballero;
import com.mycompany.juegogameplay.Personajes.Dragon;
import com.mycompany.juegogameplay.Personajes.Gigante;
import com.mycompany.juegogameplay.Personajes.Jugables;
import com.mycompany.juegogameplay.Personajes.Mago;

public class Menu{

    //Variables de instancia
    private Jugador jugador;
    private Jugables jugables[];
    private Objetos objetos[];
    private Tienda tienda;
    private Tablero tablero;
    private Partida partida;
    private Inventario inventario;

    public Menu(){
        System.out.println("Creando el juego");
        //Instanciamos todos los objetos
        jugador = new Jugador();

        jugables = new Jugables[5];
        jugables[0] = new Caballero();
        jugables[1] = new Arquero();
        jugables[2] = new Mago();
        jugables[3] = new Gigante();
        jugables[4] = new Dragon();

        objetos = new Objetos[3];
        objetos[0] = new SemillaDeLaVida();
        objetos[1] = new ElixirVerde();
        objetos[2] = new CapaDeMovilidad();

        tienda = new Tienda(jugador, jugables, objetos);
        tablero = new Tablero();
        inventario = new Inventario(jugador, jugables, objetos);
        partida = new Partida(tienda, tablero, jugador, jugables, objetos);
        System.out.println("Completado");
    }

    public void MostrarMenu () {
        int opcion = 0;
        boolean primerPartida = true;
        do {
            // Se muestra el menú
            Consola.LimpiarPantalla();
            if (primerPartida) {
                System.out.println("Selecciona Iniciar Partida para comenzar");
                primerPartida = false;
            }
            Consola.Titulo("Menu");
            System.out.println("Seleccione una opción al ingresar el número");
            System.out.println("1| Iniciar Partida");
            System.out.println("2| Tienda");
            System.out.println("3| Generación del tablero");
            System.out.println("4| Inventario");
            System.out.println("5| Salir");

            // Se solicita al usuario la opción
            opcion = Consola.readInt("Opción número: ");
            switch (opcion) {
                case 1:
                    partida.IniciarPartida();
                    break;
                case 2:
                    tienda.IniciarTienda();
                    break;
                case 3:
                    tablero.IniciarTablero();
                    break;
                case 4:
                    inventario.IniciarInventario();
                    break;
                case 5:
                    System.out.println("Cerrando el juego...");
                    break;
                default:
                    Consola.Invalido();
            }
        } while (opcion != 5);
    }
}
