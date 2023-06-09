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

    public Batalla(Tienda tienda, Tablero tablero, Jugador jugador, Jugables[] jugables, Objetos[] objetos) {
        this.tienda = tienda;
        this.tablero = tablero;
        this.jugador = jugador;
        this.jugables = jugables;
        this.objetos = objetos;
    }

    public void iniciarBatalla() {
        // Se abre la selección de personajes
        this.personajesJugar = new Jugables[2];
        int[] vidaInicial = new int[2];
        seleccionDePersonajes();
        // Obtenemos los valores iniciales de vida
        vidaInicial[0] = personajesJugar[0].getVida();
        vidaInicial[1] = personajesJugar[1].getVida();

        // Se abre la selección de mapas
        tablero.iniciarTablero();

        // Se empieza la partida y la construcción del tablero
        // Se solicita al usuario colocar al combatiente en el campo
        System.out.println("Ingrese la posición para enviar a su combatiente principal");
        boolean movimientoCorrecto = false;
        do {
            personajesJugar[0].setXfila(Consola.readInt("Ingrese el número de fila"));
            personajesJugar[0].setYcolumna(Consola.readInt("Ingrese el número de columna"));
            if (personajesJugar[0].getXfila() > 0 && personajesJugar[0].getYcolumna() > 0
                    && personajesJugar[0].getXfila() < tablero.getTableroBatalla().length
                    && personajesJugar[0].getYcolumna() < tablero.getTableroBatalla().length) {
                movimientoCorrecto = true;
            } else {
                System.out.println("Casilla fuera del campo, intenta de nuevo");
            }
        } while (!movimientoCorrecto);

        // Se solicita al usuario colocar al segundo combatiente en el campo
        System.out.println("Ingrese la posición para enviar a su combatiente secundario");
        movimientoCorrecto = false;
        do {
            personajesJugar[1].setXfila(Consola.readInt("Ingrese el número de fila"));
            personajesJugar[1].setYcolumna(Consola.readInt("Ingrese el número de columna"));
            if (personajesJugar[1].getXfila() > 0 && personajesJugar[1].getYcolumna() > 0
                    && personajesJugar[1].getXfila() < tablero.getTableroBatalla().length
                    && personajesJugar[1].getYcolumna() < tablero.getTableroBatalla().length) {
                movimientoCorrecto = true;
            } else {
                System.out.println("Casilla fuera del campo, intenta de nuevo");
            }
        } while (!movimientoCorrecto);

        // Añadimos los combatientes al campo de batalla
        tablero.edicionTablero(personajesJugar[0].getXfila(), personajesJugar[0].getYcolumna(),
                personajesJugar[0].getCaracterImpreso());
        tablero.edicionTablero(personajesJugar[1].getXfila(), personajesJugar[1].getYcolumna(),
                personajesJugar[1].getCaracterImpreso());

        // Generación de enemigos aleatorios
        enemigosAleatorios();

        for (int i = 0; i < enemigosPartida.length; i++) {
            enemigosPartida[i].setXfila(Consola.numeroAleatorio(tablero.getAlto(), 1));
            enemigosPartida[i].setYcolumna(Consola.numeroAleatorio(tablero.getAlto(), 1));
            tablero.edicionTablero(enemigosPartida[i].getXfila(), enemigosPartida[i].getYcolumna(),
                    enemigosPartida[i].getCaracterImpreso());
        }

        // Se imprimen al azar las casillas
        tablero.casillasAleatorias();
        tablero.imprimirTablero();

        int terminar = 0;
        int contEnemigosEliminados = 0;
        boolean enemigosEliminados = false;
        do {
            int personajeOn = 0;
            System.out.println("Seleccione el jugador a utilizar");
            System.out.println("1| " + personajesJugar[0].getPersonaje());
            System.out.println("2| " + personajesJugar[1].getPersonaje());
            int opcion = Consola.readInt("Personaje número:");
            do {
                // Uso de la semilla de la vida
                if (objetos[0].getCantidadDisponible() > 0) {
                    if (personajesJugar[0].getVida() <= 0) {
                        System.out.println("¿Deseas usar una Semillas de la vida para revivir a "
                                + personajesJugar[0].getPersonaje());
                        int opcionSV = Consola.readInt("1| Sí   2| No");
                        if (opcionSV == 1) {
                            System.out.println("Reviviendo a " + personajesJugar[0].getPersonaje());
                            personajesJugar[0].setVida(vidaInicial[0]);
                        }
                    }
                }
                if (objetos[1].getCantidadDisponible() > 0) {
                    if (personajesJugar[1].getVida() <= 0) {
                        System.out.println("¿Deseas usar una Semillas de la vida para revivir a "
                                + personajesJugar[1].getPersonaje());
                        int opcionSV = Consola.readInt("1| Sí   2| No");
                        if (opcionSV == 1) {
                            System.out.println("Reviviendo a " + personajesJugar[1].getPersonaje());
                            personajesJugar[1].setVida(vidaInicial[1]);
                        }
                    }
                }

                // PERSONAJE ACTIVO
                if (opcion == 1) {
                    personajeOn = 0;
                } else if (opcion == 2) {
                    personajeOn = 1;
                } else {
                    Consola.Invalido();
                }
            } while (opcion != 1 && opcion != 2);

            // ACCIONES
            int opcion2 = 0;
            do {
                System.out.println("Seleccione la acción a realizar");
                System.out.println("1| Mover");
                System.out.println("2| Atacar");
                System.out.println("3| Objetos");
                opcion2 = Consola.readInt("Acción número:");
                if (opcion2 == 1) {
                    // Jugables | Movimiento
                    tablero.setTableroBatalla(
                            personajesJugar[personajeOn].movimientoPersonajes(tablero.getTableroBatalla()));
                } else if (opcion2 == 2) {
                    // Jugables | Ataque
                    enemigosPartida = personajesJugar[personajeOn].ataquePersonaje(tablero.getTableroBatalla(),
                            enemigosPartida);
                } else if (opcion2 == 3) {
                    System.out.println("Selecciona un objeto");
                    System.out.println("1| Elixir verde");
                    System.out.println("2| Capa de movilidad");
                    System.out.println("3| Regresar");
                    int opcion3 = Consola.readInt("Objeto a usar:");
                    switch (opcion3) {
                        case 1:
                            if (objetos[1].getCantidadDisponible() > 0) {
                                objetos[1].setCantidadDisponible(objetos[1].getCantidadDisponible() - 1);
                                personajesJugar[personajeOn].setVida(personajesJugar[personajeOn].getVida() + 50);
                                System.out.println(
                                        personajesJugar[personajeOn].getPersonaje() + " ha recuperado 50 de vida");
                            } else {
                                System.out.println("No tienes elíxir verde");
                            }
                            break;
                        case 2:
                            if (objetos[2].getCantidadDisponible() > 0) {
                                objetos[2].setCantidadDisponible(objetos[2].getCantidadDisponible() - 1);
                                // Guardamos el movimiento máximo del personaje
                                int movMax = personajesJugar[personajeOn].getMovimientoMax();
                                // Setteamos el movimiento máximo como 1, para que el objeto realice cumpla su
                                // función
                                personajesJugar[personajeOn].movimientoPersonajes(tablero.getTableroBatalla());
                                // Una vez realizado el movimiento, regresamos el valor de movimiento máximo del
                                // personaje
                                personajesJugar[personajeOn].setMovimientoMax(movMax);
                            } else {
                                System.out.println("No tienes capa de movilidad");
                            }
                            break;
                        default:
                            break;
                    }
                } else {
                    Consola.Invalido();
                }
            } while (opcion2 != 1 && opcion2 != 2);

            // Mostramos el estado de cada personaje
            estadoPersonajes();
            Consola.EnterContinuar();

            if (Consola.numeroAleatorio(2, 1) == 1) {
                // Enemigos | Movimiento
                boolean enemigoVivo = false;
                do {
                    int enemigoOn = Consola.numeroAleatorio(cantidadEnemigos - 1, 0);
                    if (enemigosPartida[enemigoOn].getVida() > 0) {
                        tablero.setTableroBatalla(
                        enemigosPartida[enemigoOn].movimientoPersonajes(tablero.getTableroBatalla()));
                        enemigoVivo = true;
                    }
                    contEnemigosEliminados = 0;
                    for (int i = 0; i < cantidadEnemigos; i++) {
                        if (enemigosPartida[i].getVida() <= 0) {
                            contEnemigosEliminados = contEnemigosEliminados + 1;
                        }
                    }
                    if (contEnemigosEliminados == cantidadEnemigos) {
                        enemigosEliminados = true;
                    }
                } while (!enemigoVivo && !enemigosEliminados);
            } else {
                // Enemigos | Ataque
                boolean enemigoVivo = false;
                do {
                    int enemigoOn = Consola.numeroAleatorio(cantidadEnemigos - 1, 0);
                    if (enemigosPartida[enemigoOn].getVida() > 0) {
                        personajesJugar = enemigosPartida[enemigoOn].ataquePersonaje(tablero.getTableroBatalla(),
                                personajesJugar);
                        enemigoVivo = true;
                    }
                    contEnemigosEliminados = 0;
                    for (int i = 0; i < cantidadEnemigos; i++) {
                        if (enemigosPartida[i].getVida() <= 0) {
                            contEnemigosEliminados = contEnemigosEliminados + 1;
                        }
                    }
                    if (contEnemigosEliminados == cantidadEnemigos) {
                        enemigosEliminados = true;
                    }
                } while (!enemigoVivo && !enemigosEliminados);
            }

            // Mostramos el estado de cada personaje
            estadoPersonajes();
            Consola.EnterContinuar();

            // Se muestra el tablero
            tablero.imprimirTablero();

            if (enemigosEliminados) {
                Consola.Titulo("¡¡¡Felicidades " + jugador.getUser() + ", has ganado!!!");
                System.out.println("Tu recompensa son 200 de oro");
                jugador.setOro(jugador.getOro() + 200);
                System.out.println("Oro disponible: " + jugador.getOro());
                Consola.EnterContinuar();
            }

            if (!enemigosEliminados) {
                terminar = Consola.readInt("¿Continuar?    1| Sí   2| No");
            }

        } while (terminar == 1 && !enemigosEliminados);

        // Luego de terminar la batalla, renovamos la vida de cada personaje jugable
        personajesJugar[0].setVida(vidaInicial[0]);
        personajesJugar[1].setVida(vidaInicial[1]);

    }

    public void estadoPersonajes() {
        Consola.Titulo("Estado de los personajes");
        // Estado de cada combatiente
        tablero.setTableroBatalla(personajesJugar[0].estado(tablero.getTableroBatalla()));
        tablero.setTableroBatalla(personajesJugar[1].estado(tablero.getTableroBatalla()));

        // Estado de cada enemigo
        for (int i = 0; i < cantidadEnemigos; i++) {
            tablero.setTableroBatalla(enemigosPartida[i].estado(tablero.getTableroBatalla()));
        }
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
            // Si ya hay dos personajes seleccionados
            if (cont == 2) {
                if (personajesJugar[0].getPersonaje() == personajesJugar[1].getPersonaje()) {
                    System.out.println("Seleccione personajes diferentes");
                    cont -= 1;
                    int opcion = Consola.readInt("¿Deseas abrir la tienda? \n1| Sí \n2| No\n");
                    if (opcion == 1) {
                        existenPersonajes = false;
                    }
                }
            }
        } while (existenPersonajes && cont != 2);

        if (!existenPersonajes) {
            Consola.EnterContinuar();
            tienda.iniciarTienda();
        } else {
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

    public void enemigosAleatorios() {
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
        } while (dificultad != 1 && dificultad != 2 && dificultad != 3);

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
