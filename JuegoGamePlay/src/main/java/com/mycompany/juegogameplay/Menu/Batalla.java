package com.mycompany.juegogameplay.Menu;

import com.mycompany.juegogameplay.Objetos.Objetos;
import com.mycompany.juegogameplay.Personajes.*;

public class Batalla {

    private Tienda tienda;
    private Tablero tablero;
    private Jugador jugador;
    private Jugables[] jugables;
    private Objetos[] objetos;

    private int dificultad;

    private Jugables personajesJugar[];
    private Enemigos enemigosPartida[];
    private int cantidadEnemigos;
    
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
        tablero.iniciarTablero();
        
        //Se empieza la partida y la construcción del tablero
        //Se solicita al usuario colocar al combatiente en el campo
        System.out.println("Ingrese la posición para enviar a su combatiente principal");
        boolean movimientoCorrecto = false;
        do {
            personajesJugar[0].setXfila(Consola.readInt("Ingrese el número de fila"));
            personajesJugar[0].setYcolumna(Consola.readInt("Ingrese el número de columna"));
            if (personajesJugar[0].getXfila() > 0 && personajesJugar[0].getYcolumna() > 0 && personajesJugar[0].getXfila() < tablero.getTableroBatalla().length && personajesJugar[0].getYcolumna() < tablero.getTableroBatalla().length) {
                movimientoCorrecto = true;
            } else{
                System.out.println("Casilla fuera del campo, intenta de nuevo");
            }
        } while (!movimientoCorrecto);
        
        tablero.edicionTablero(personajesJugar[0].getXfila(), personajesJugar[0].getYcolumna(), personajesJugar[0].getCaracterImpreso());

        //Generación de enemigos aleatorios
        enemigosAleatorios();

        for (int i = 0; i < enemigosPartida.length; i++) {
            enemigosPartida[i].setXfila(Consola.numeroAleatorio(tablero.getAlto(), 1));
            enemigosPartida[i].setYcolumna(Consola.numeroAleatorio(tablero.getAlto(), 1));
            tablero.edicionTablero(enemigosPartida[i].getXfila(), enemigosPartida[i].getYcolumna(), enemigosPartida[i].getCaracterImpreso());
        }

        //Se imprimen al azar las casillas
        tablero.casillasAleatorias();
        tablero.imprimirTablero();
        

        int terminar = 0;
        do {
            //Jugables
            tablero.setTableroBatalla(personajesJugar[0].movimientoPersonajes(tablero.getTableroBatalla()));
            tablero.imprimirTablero();

            //Enemigos
            int enemigoOn = Consola.numeroAleatorio(cantidadEnemigos-1, 0);
            tablero.setTableroBatalla(enemigosPartida[enemigoOn].movimientoPersonajes(tablero.getTableroBatalla()));
            tablero.imprimirTablero();

            terminar = Consola.readInt("Terminar -1");
        } while (terminar != 1);
        
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
            tienda.iniciarTienda();
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

    public void enemigosAleatorios(){
        Consola.Titulo("Selección de dificultad");
        dificultad = Consola.readInt("1| Dificil    2| Extremo    3| Insano");
        do {
            switch (dificultad) {
                case 1:
                    cantidadEnemigos = 2;
                    break;
                case 2:
                    cantidadEnemigos = 3;
                    break;
                case 3:
                    cantidadEnemigos = 4;
                    break;
                default:
                    Consola.Invalido();
                    break;
            }
        } while (dificultad != 1 && dificultad != 2 && dificultad !=3);

        enemigosPartida = new Enemigos[cantidadEnemigos];

        for (int i = 0; i < cantidadEnemigos; i++) {
            int aleatorio = Consola.numeroAleatorio(5, 1);
            enemigosPartida[i] = switch (aleatorio) {
                case 1 -> new Ogro();
                case 2 -> new Gargola();
                case 3 -> new Bruja();
                case 4 -> new Cancerbero();
                case 5 -> new FlorCarnivora();
                default -> new Ogro();
            };
        }
    }
}
