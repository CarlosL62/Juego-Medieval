package com.mycompany.juegogameplay.Menu;

import com.mycompany.juegogameplay.Personajes.*;
import com.mycompany.juegogameplay.Mejoras.*;
import com.mycompany.juegogameplay.Objetos.*;

public class Tienda {

    //protected Jugador jugador;
    private Jugables jugables[];
    private Jugador jugador;
    private Objetos objetos[];

    public Tienda(Jugador jugador, Jugables jugables[], Objetos[] objetos) {
        System.out.println("Creando Tienda");
        this.jugador = jugador;
        this.jugables = jugables;
        this.objetos = objetos;
    }

    private boolean primerPartida = true;

    public void iniciarTienda() {
        int opcion = 0;
        do {
            Consola.LimpiarPantalla();
            if (primerPartida == true) {
                System.out.println("Selecciona Personajes para comprar a tus primeros dos combatientes");
                primerPartida = false;
            }
            Consola.Titulo("Tienda");
            System.out.println("Seleccione una opción al ingresar el número");
            System.out.println("1| Objetos");
            System.out.println("2| Mejoras");
            System.out.println("3| Personajes");
            System.out.println("4| Cerrar");

            // Se le solicita al usuario su opción
            opcion = Consola.readInt("Opción número: ");
            // Se valida la respuesta
            switch (opcion) {
                case 1:
                    Consola.LimpiarPantalla();
                    comprarObjetos();
                    break;
                case 2:
                    Consola.LimpiarPantalla();
                    String personaje = personajesDisponibles();
                    if (personaje != "") {
                        comprarMejoras(personaje);
                    } else{
                        Consola.EnterContinuar();
                    }
                    break;
                case 3:
                    Consola.LimpiarPantalla();
                    comprarPersonajes();
                    break;
                case 4:
                    System.out.println("Cerrando...");
                    break;
                default:
                    Consola.Invalido();
                    break;
            }
        } while (opcion != 4);
    }

    public void comprarObjetos() {
        int opcion = 0;
        do {
            // Se abre la tienda de objetos
            Consola.LimpiarPantalla();
            Consola.Titulo("Tienda de objetos");
            System.out.println("1| Semilla de la vida");
            System.out.println("2| Elixir verde");
            System.out.println("3| Capa de movilidad");
            System.out.println("4| Regresar");
            opcion = Consola.readInt("Selecciona un objeto");
            switch (opcion) {
                case 1:
                    objetos[0].caracteristicas();
                    jugador.setOro(objetos[0].comprar(jugador.getOro()));
                    break;
                case 2:
                    objetos[1].caracteristicas();
                    jugador.setOro(objetos[1].comprar(jugador.getOro()));
                    break;
                case 3:
                    objetos[2].caracteristicas();
                    jugador.setOro(objetos[2].comprar(jugador.getOro()));
                    break;
                case 4:
                    System.out.println("Regresando...");
                    break;
                default:
                    Consola.Invalido();
                    break;
            }
        } while (opcion != 4);
    }

    public String personajesDisponibles(){
        String opcionLista[] = new String[5];
        int cont = 1;
        int opcion = 0;
        Consola.LimpiarPantalla();
        Consola.Titulo("Selección de personajes");
        for (int i = 0; i < jugables.length; i++) {
            if (!jugables[i].personajeDisponible().equals("")) {
                System.out.println(cont + jugables[i].personajeDisponible());
                opcionLista[(cont-1)] = jugables[i].getCaracter();
                cont = cont + 1;
            }
        }
        if (opcionLista[0] == null) {
            System.out.println("Primero adquiere un combatiente");
            return opcionLista[0] = "";
        } else{
            opcion = Consola.readInt("Seleccione un personaje");
            return opcionLista[(opcion-1)];
        }
    }

    public void comprarMejoras(String personaje) {
        int opcionMejora = 0;
        do {
            // Se abre la tienda de mejoras
            Consola.LimpiarPantalla();
            Consola.Titulo("Tienda de mejoras");
            System.out.println("1| Mejora Vida");
            System.out.println("2| Mejora Daño");
            System.out.println("3| Mejora Movimiento");
            System.out.println("4| Regresar");
            opcionMejora = Consola.readInt("Selecciona una mejora");
            switch (opcionMejora) {
                case 1:
                    Mejoras vida = new VidaM(jugables);
                    vida.caracteristicas();
                    jugador.setOro(vida.comprar(jugador.getOro(), personaje));
                    break;
                case 2:
                    Mejoras daño = new DañoM(jugables);
                    daño.caracteristicas();
                    jugador.setOro(daño.comprar(jugador.getOro(), personaje));
                    break;
                case 3:
                    Mejoras movilidad = new MovilidadM(jugables);
                    movilidad.caracteristicas();
                    jugador.setOro(movilidad.comprar(jugador.getOro(), personaje));
                    break;
                case 4:
                    System.out.println("Regresando...");
                    break;
                default:
                    Consola.Invalido();
                    break;
            }
        } while (opcionMejora != 4);
    }

    public void comprarPersonajes() {
        int opcion = 0;
        do {
            // Se abre la tienda de personajes
            Consola.LimpiarPantalla();
            Consola.Titulo("Tienda de personajes");
            System.out.println("1| Caballero");
            System.out.println("2| Arquero");
            System.out.println("3| Mago");
            System.out.println("4| Gigante");
            System.out.println("5| Dragon");
            System.out.println("6| Regresar");
            opcion = Consola.readInt("Selecciona un personaje");
            switch (opcion) {
                case 1:
                    jugables[0].caracteristicas();
                    jugador.setOro(jugables[0].comprar(jugador.getOro()));
                    break;
                case 2:
                    jugables[1].caracteristicas();
                    jugador.setOro(jugables[1].comprar(jugador.getOro()));
                    break;
                case 3:
                    jugables[2].caracteristicas();
                    jugador.setOro(jugables[2].comprar(jugador.getOro()));
                    break;
                case 4:
                    jugables[3].caracteristicas();
                    jugador.setOro(jugables[3].comprar(jugador.getOro()));
                    break;
                case 5:
                    jugables[4].caracteristicas();
                    jugador.setOro(jugables[4].comprar(jugador.getOro()));
                    break;
                case 6:
                    System.out.println("Regresando...");
                    break;
                default:
                    Consola.Invalido();
                    break;
            }
        } while (opcion != 6);
    }
}
