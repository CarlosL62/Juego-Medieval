package com.mycompany.juegogameplay.Personajes;

import com.mycompany.juegogameplay.Menu.Consola;

public class Bruja extends Enemigos{
    
    private int vida = 150;
    private int daño = 45;

    public Bruja() {
        super.caracter = "B";
        super.caracterImpreso = (red+caracter+reset);
        super.personaje = "Bruja";
        super.vida = vida;
        super.daño = daño;
        super.tipoMovimiento = "Vuela, hasta en un línea";
        super.tipoAtaque = "Lanza un hechizo en toda una línea, que impacta con el primer personaje o árbol que encuentre";
    }

    // Modificación para que pueda moverse en línea
    /*@Override
    // Movimiento de los enemigos
    public String[][] movimientoPersonajes(String[][] tablero) {
        boolean movimientoValido = true;
        String movimientoTeclado = "";
        int moverContador = 1;
        boolean movimientoTerminado = false;
        System.out.println(personaje + " se está moviendo...");
        do {
            // Los movimientos serán aleatorios
            movimientoTeclado = switch (Consola.numeroAleatorio(4, 1)) {
                case 1 -> "A";
                case 2 -> "W";
                case 3 -> "S";
                case 4 -> "D";
                default -> "A";
            };
            movimientoValido = true;
            movimientoTerminado = false;
            moverContador = 1;
            switch (movimientoTeclado) {
                case "A":
                    do {
                        if (movimientoPersonajeValido(tablero, xfila, ycolumna - 1)) {
                            tablero[xfila][ycolumna] = casillaOriginal;
                            ycolumna = ycolumna - 1;
                            casillaOriginal = tablero[xfila][ycolumna];
                            tablero[xfila][ycolumna] = "| " + caracterImpreso + " |";
                            // De forma aleatoria, decidirá si detenerse, si llega a toparse con algún elemento donde no tenga permitido ubicarse, se detendrá automáticamente
                            int opcion = Consola.numeroAleatorio(2, 1);
                            if (opcion == 1) {
                                moverContador = moverContador + 1;
                            } else if (opcion == 2) {
                                movimientoTerminado = true;
                            }
                        } else {
                            movimientoValido = false;
                        }
                    } while (!movimientoTerminado && movimientoValido);
                    break;
                case "W":
                    do {
                        if (movimientoPersonajeValido(tablero, xfila - 1, ycolumna)) {
                            tablero[xfila][ycolumna] = casillaOriginal;
                            xfila = xfila - 1;
                            casillaOriginal = tablero[xfila][ycolumna];
                            tablero[xfila][ycolumna] = "| " + caracterImpreso + " |";
                            int opcion = Consola.numeroAleatorio(2, 1);
                            if (opcion == 1) {
                                moverContador = moverContador + 1;
                            } else if (opcion == 2) {
                                movimientoTerminado = true;
                            }
                        } else {
                            movimientoValido = false;
                        }
                    } while (!movimientoTerminado && movimientoValido);
                    break;
                case "S":
                    do {
                        if (movimientoPersonajeValido(tablero, xfila + 1, ycolumna)) {
                            tablero[xfila][ycolumna] = casillaOriginal;
                            xfila = xfila + 1;
                            casillaOriginal = tablero[xfila][ycolumna];
                            tablero[xfila][ycolumna] = "| " + caracterImpreso + " |";
                            int opcion = Consola.numeroAleatorio(2, 1);
                            if (opcion == 1) {
                                moverContador = moverContador + 1;
                            } else if (opcion == 2) {
                                movimientoTerminado = true;
                            }
                        } else {
                            movimientoValido = false;
                        }
                    } while (!movimientoTerminado && movimientoValido);
                    break;
                case "D":
                    do {
                        if (movimientoPersonajeValido(tablero, xfila, ycolumna + 1)) {
                            tablero[xfila][ycolumna] = casillaOriginal;
                            ycolumna = ycolumna + 1;
                            casillaOriginal = tablero[xfila][ycolumna];
                            tablero[xfila][ycolumna] = "| " + caracterImpreso + " |";
                            int opcion = Consola.numeroAleatorio(2, 1);
                            if (opcion == 1) {
                                moverContador = moverContador + 1;
                            } else if (opcion == 2) {
                                movimientoTerminado = true;
                            }
                        } else {
                            movimientoValido = false;
                        }
                    } while (!movimientoTerminado && movimientoValido);
                    break;
                default:
                    movimientoValido = false;
                    break;
            }
            if (!movimientoValido) {
                // Movimiento inváldio
            }
        } while (!movimientoValido);
        System.out.println(personaje + " se movilizó a fila: " + xfila + " columna: " + ycolumna);
        return tablero;
    }*/
    

    //Modificación para que tome en cuenta que vuela y que se pueda mover en línea
    @Override
    public void movimientoPersonajeValido(String[][] tablero, int destinoX, int destinoY) {
        // Verificación que el movimiento sea válido, primero que este dentro del
        // tablero y que sea a una casilla válida
        if ((destinoX > 0 && destinoY > 0 && destinoX < tablero.length && destinoY < tablero.length) &&
            (tablero[destinoX][destinoY].equals("| " + reset + "_" + reset + " |") ||
            tablero[destinoX][destinoY].equals("| " + yellow + "$" + reset + " |") ||
            tablero[destinoX][destinoY].equals("| " + green + "T" + reset + " |") ||
            tablero[destinoX][destinoY].equals("| " + blue + "~" + reset + " |"))) {

            tablero[xfila][ycolumna] = casillaOriginal;
            xfila = destinoX;
            ycolumna = destinoY;
            casillaOriginal = tablero[xfila][ycolumna];
            tablero[xfila][ycolumna] = "| " + caracterImpreso + " |";
            // De forma aleatoria, decidirá si detenerse, si llega a toparse con algún elemento donde no tenga permitido ubicarse, se detendrá automáticamente
            int opcion = Consola.numeroAleatorio(2, 1);
            if (opcion == 1) {
                moverContador = moverContador + 1;
            } else if (opcion == 2) {
                movimientoTerminado = true;
            }
        } else {
            movimientoValido = false;
        }    
    }

}
