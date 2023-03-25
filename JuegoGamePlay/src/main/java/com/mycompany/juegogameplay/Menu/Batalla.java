package com.mycompany.juegogameplay.Menu;

import com.mycompany.juegogameplay.Objetos.Objetos;
import com.mycompany.juegogameplay.Personajes.Jugables;

public class Batalla {

    private Tienda tienda;
    private Tablero tablero;
    private Jugador jugador;
    private Jugables[] jugables;
    private Objetos[] objetos;

    private Jugables personajesJugar[];
    
    public Batalla(Tienda tienda, Tablero tablero, Jugador jugador, Jugables[] jugables, Objetos[] objetos){
        this.tienda = tienda;
        this.tablero = tablero;
        this.jugador = jugador;
        this.jugables = jugables;
        this.objetos = objetos;
    }

    public void iniciarBatalla() {
        //Se abre la selección de personajes
        this.personajesJugar = new Jugables [2];
        seleccionDePersonajes();

        //Se abre la selección de mapas
        tablero.IniciarTablero();

        //Creamos las coordenadas para el combatiente
        int x = 0, y = 0;
        
        //Se empieza la partida y la construcción del tablero
        //Se solicita al usuario colocar al combatiente en el campo
        System.out.println("Ingrese la posición para enviar a su combatiente principal");
        x = Consola.readInt("Ingrese el número de fila");
        y = Consola.readInt("Ingrese el número de columna");
        tablero.edicionTablero(x, y, personajesJugar[0].getCaracterImpreso());
        personajesJugar[0].setXfila(x);
        personajesJugar[0].setYcolumna(y);
        //Se imprimen al azar las casillas
        tablero.casillasAleatorias();
        tablero.imprimirTablero();

        tablero.setTableroBatalla(personajesJugar[0].movimientoPersonajes(tablero.getTableroBatalla()));
        tablero.imprimirTablero();
    }

    public void seleccionDePersonajes() {
        int cont = 0;
        boolean existenPersonajes = true;
        // Usamos el método creado en tienda para la selección de personajes disponibles
        Consola.LimpiarPantalla();
        System.out.println("Seleccione dos personajes para jugar");
        Consola.EnterContinuar();
        do {
            switch (tienda.personajesDisponibles()) {
                case "C":
                    personajesJugar[cont] = jugables[0];
                    cont += 1;
                    existenPersonajes = true;
                    break;
                case "A":
                    personajesJugar[cont] = jugables[1];
                    cont += 1;
                    existenPersonajes = true;
                    break;
                case "M":
                    personajesJugar[cont] = jugables[2];
                    cont += 1;
                    existenPersonajes = true;
                    break;
                case "G":
                    personajesJugar[cont] = jugables[3];
                    cont += 1;
                    existenPersonajes = true;
                    break;
                case "D":
                    personajesJugar[cont] = jugables[4];
                    cont += 1;
                    existenPersonajes = true;
                    break;
                case "":
                    // Ya que no hay personajes, cierra el menú
                    existenPersonajes = false;
                    break;
                default:
                    Consola.Invalido();
                    break;
            }

            if (cont != 2) {
                Consola.LimpiarPantalla();
                System.out.println("Seleccione otro personaje");
                Consola.EnterContinuar();
            }
            //Si ya hay dos personajes seleccionados
            if (cont == 2) {
                if (personajesJugar[0].getPersonaje() == personajesJugar[1].getPersonaje()) {
                System.out.println("Seleccione personajes diferentes");
                cont -= 1;
                int opcion = Consola.readInt("¿Deseas abrir la tienda? \n1| Sí \n2| No\n");
                    if(opcion == 1) {
                        existenPersonajes = false;
                    }
                }
            }
        } while (existenPersonajes && cont != 2);

        if (!existenPersonajes) {
            Consola.EnterContinuar();
            tienda.IniciarTienda();
        } else{
            Consola.LimpiarPantalla();
            System.out.println("Personajes seleccionados");
            System.out.println("Personaje 1: " + personajesJugar[0].getPersonaje());
            Consola.EnterContinuar();
            personajesJugar[0].caracteristicas();
            Consola.EnterContinuar();
            System.out.println("Personaje 2: " + personajesJugar[1].getPersonaje());
            Consola.EnterContinuar();
            personajesJugar[1].caracteristicas();
            Consola.EnterContinuar();
        }
        
    }
}
