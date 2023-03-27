package com.mycompany.juegogameplay.Personajes;

import com.mycompany.juegogameplay.Casillas.Casillas;
import com.mycompany.juegogameplay.Menu.Consola;

public class Personajes{

    protected String caracter;
    public String getCaracter() {
        return caracter;
    }

    protected String caracterImpreso;
    public String getCaracterImpreso() {
        return caracterImpreso;
    }

    protected String personaje;
    public String getPersonaje(){
        return personaje;
    }

    protected int movimientoMax = 1;

    protected String tipoMovimiento;
    protected String tipoAtaque;

    // Colores
    String black = "\033[30m";
    String red = "\033[31m";
    String green = "\033[32m";
    String yellow = "\033[33m";
    String blue = "\033[34m";
    String purple = "\033[35m";
    String cyan = "\033[36m";
    String white = "\033[37m";
    String reset = "\u001B[0m";

    //Variables de coordenadas de posición
    protected int xfila;
    public int getXfila() {
        return xfila;
    }

    public void setXfila(int xfila) {
        this.xfila = xfila;
    }

    protected int ycolumna;

    public int getYcolumna() {
        return ycolumna;
    }

    public void setYcolumna(int ycolumna) {
        this.ycolumna = ycolumna;
    }

    //Características
    protected int vida;
    protected int daño;

    //Espacio sobre el que se situa
    protected String casillaOriginal = "| "+reset+"_"+reset+" |";

    public String getCasiilaOriginal(){
        return casillaOriginal;
    }

    public void setCasillaOriginal(String casillaOriginal){
        this.casillaOriginal = casillaOriginal;
    }

    // Variables en uso para el movimiento de los personajes
    protected boolean movimientoValido = true;
    protected int moverContador = 1;
    protected boolean movimientoTerminado = false;

    //Movimiento de los personajes
    public String[][] movimientoPersonajes(String[][] tablero) {
        String movimientoTeclado = "";
        boolean caracterValido = true;
        do {
            movimientoTeclado = Consola.readString("Mueva al " + personaje + " usando AWSD");
            movimientoTeclado = movimientoTeclado.toUpperCase();
            caracterValido = true;
            movimientoValido = true;
            movimientoTerminado = false;
            moverContador = 1;
            switch (movimientoTeclado) {
                case "A":
                    do {
                        /*if (movimientoPersonajeValido(tablero, xfila, ycolumna - 1)) {
                            tablero[xfila][ycolumna] = casillaOriginal;
                            ycolumna = ycolumna - 1;
                            casillaOriginal = tablero[xfila][ycolumna];
                            tablero[xfila][ycolumna] = "| " + caracterImpreso + " |";
                            int opcion = 0;
                            do {
                                if (moverContador < movimientoMax) {
                                    opcion = Consola.readInt(
                                            "¿Desea mover +1 de " + moverContador + " movimiento/s?  1| Sí   2| No");
                                    if (opcion == 1) {
                                        moverContador = moverContador + 1;
                                    } else if (opcion == 2) {
                                        movimientoTerminado = true;
                                    }
                                } else {
                                    movimientoTerminado = true;
                                }
                            } while (opcion != 1 && opcion != 2 && !movimientoTerminado);
                        } else {
                            movimientoValido = false;
                            if (moverContador > 1) {
                                movimientoTerminado = true;
                            }
                        }*/

                        movimientoPersonajeValido(tablero, xfila, ycolumna - 1);
                    } while (!movimientoTerminado && movimientoValido);
                    break;
                case "W":
                    do {
                        /*if (movimientoPersonajeValido(tablero, xfila - 1, ycolumna)) {
                            tablero[xfila][ycolumna] = casillaOriginal;
                            xfila = xfila - 1;
                            casillaOriginal = tablero[xfila][ycolumna];
                            tablero[xfila][ycolumna] = "| " + caracterImpreso + " |";
                            int opcion = 0;
                            do {
                                if (moverContador < movimientoMax) {
                                    opcion = Consola.readInt(
                                            "¿Desea mover +1 de " + moverContador + " movimiento/s?  1| Sí   2| No");
                                    if (opcion == 1) {
                                        moverContador = moverContador + 1;
                                    } else if (opcion == 2) {
                                        movimientoTerminado = true;
                                    }
                                } else {
                                    movimientoTerminado = true;
                                }

                            } while (opcion != 1 && opcion != 2 && !movimientoTerminado);
                        } else {
                            movimientoValido = false;
                        }*/

                        movimientoPersonajeValido(tablero, xfila - 1, ycolumna);
                    } while (moverContador <= movimientoMax && !movimientoTerminado && movimientoValido);
                    break;
                case "S":
                    do {
                        /*if (movimientoPersonajeValido(tablero, xfila + 1, ycolumna)) {
                            tablero[xfila][ycolumna] = casillaOriginal;
                            xfila = xfila + 1;
                            casillaOriginal = tablero[xfila][ycolumna];
                            tablero[xfila][ycolumna] = "| " + caracterImpreso + " |";
                            int opcion = 0;
                            do {
                                if (moverContador < movimientoMax) {
                                    opcion = Consola.readInt(
                                            "¿Desea mover +1 de " + moverContador + " movimiento/s?  1| Sí   2| No");
                                    if (opcion == 1) {
                                        moverContador = moverContador + 1;
                                    } else if (opcion == 2) {
                                        movimientoTerminado = true;
                                    }
                                } else {
                                    movimientoTerminado = true;
                                }

                            } while (opcion != 1 && opcion != 2 && !movimientoTerminado);
                        } else {
                            movimientoValido = false;
                        }*/

                        movimientoPersonajeValido(tablero, xfila + 1, ycolumna);
                    } while (moverContador <= movimientoMax && !movimientoTerminado && movimientoValido);
                    break;
                case "D":
                    do {
                        /*if (movimientoPersonajeValido(tablero, xfila, ycolumna + 1)) {
                            tablero[xfila][ycolumna] = casillaOriginal;
                            ycolumna = ycolumna + 1;
                            casillaOriginal = tablero[xfila][ycolumna];
                            tablero[xfila][ycolumna] = "| " + caracterImpreso + " |";
                            int opcion = 0;
                            do {
                                if (moverContador < movimientoMax) {
                                    opcion = Consola.readInt(
                                            "¿Desea mover +1 de " + moverContador + " movimiento/s?  1| Sí   2| No");
                                    if (opcion == 1) {
                                        moverContador = moverContador + 1;
                                    } else if (opcion == 2) {
                                        movimientoTerminado = true;
                                    }
                                } else {
                                    movimientoTerminado = true;
                                }

                            } while (opcion != 1 && opcion != 2 && !movimientoTerminado);
                        } else {
                            movimientoValido = false;
                        }*/

                        movimientoPersonajeValido(tablero, xfila, ycolumna + 1);
                    } while (moverContador <= movimientoMax && !movimientoTerminado && movimientoValido);
                    break;
                default:
                    movimientoValido = false;
                    break;
            }
            if (!movimientoValido) {
                System.out.println("Movimiento inválido");
            }
        } while (!caracterValido || !movimientoTerminado);
        return tablero;
    }

    public void movimientoPersonajeValido(String[][] tablero, int destinoX, int destinoY) {
        // Verificación que el movimiento sea válido, primero que este dentro del
        // tablero y que sea a una casilla válida
        if ((destinoX > 0 && destinoY > 0 && destinoX < tablero.length && destinoY < tablero.length) &&
            (tablero[destinoX][destinoY].equals("| " + reset + "_" + reset + " |") ||
            tablero[destinoX][destinoY].equals("| " + yellow + "$" + reset + " |"))) {

            // Realizamos el cambio de las casillas originales y movemos al personaje
            tablero[xfila][ycolumna] = casillaOriginal;
            xfila = destinoX;
            ycolumna = destinoY;
            casillaOriginal = tablero[xfila][ycolumna];
            tablero[xfila][ycolumna] = "| " + caracterImpreso + " |";
            int opcion = 0;
            do {
                if (moverContador < movimientoMax) {
                    opcion = Consola.readInt(
                            "¿Desea moverse +1 casillas de " + moverContador + " movidas?  1| Sí   2| No");
                    if (opcion == 1) {
                        moverContador = moverContador + 1;
                    } else if (opcion == 2) {
                        movimientoTerminado = true;
                    }
                } else {
                    movimientoTerminado = true;
                }
            } while (opcion != 1 && opcion != 2 && !movimientoTerminado);
        } else {
            movimientoValido = false;
            if (moverContador > 1) {
                movimientoTerminado = true;
            }
        }
    }
}
