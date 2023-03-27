package com.mycompany.juegogameplay.Personajes;

import com.mycompany.juegogameplay.Menu.*;

public class Enemigos extends Personajes{

    @Override
    //Movimiento de los enemigos
    public String[][] movimientoPersonajes(String[][] tablero) {
        String movimientoTeclado = "";
        System.out.println(personaje + " en fila: " + xfila + " columna: " + ycolumna + " se está moviendo...");
        do {
            //Los movimientos serán aleatorios
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
                        movimientoPersonajeValido(tablero, xfila, ycolumna - 1);
                    } while (moverContador <= movimientoMax && !movimientoTerminado && movimientoValido);
                    break;
                case "W":
                    do {
                        movimientoPersonajeValido(tablero, xfila - 1, ycolumna);
                    } while (moverContador <= movimientoMax && !movimientoTerminado && movimientoValido);
                    break;
                case "S":
                    do {
                        movimientoPersonajeValido(tablero, xfila + 1, ycolumna);
                    } while (moverContador <= movimientoMax && !movimientoTerminado && movimientoValido);
                    break;
                case "D":
                    do {
                        movimientoPersonajeValido(tablero, xfila, ycolumna + 1);
                    } while (moverContador <= movimientoMax && !movimientoTerminado && movimientoValido);
                    break;
                default:
                    movimientoValido = false;
                    break;
            }
            if (!movimientoValido) {
                //Movimiento inváldio
            }
        } while (!movimientoTerminado);
        System.out.println(personaje + " se movilizó a fila: " + xfila + " columna: " + ycolumna);
        return tablero;
    }

    @Override
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

            //De forma aleatoria, el enemigo se moverá más o no
            if (moverContador < movimientoMax) {
                int opcion = Consola.numeroAleatorio(2, 1);
                if (opcion == 1) {
                    moverContador = moverContador + 1;
                } else if (opcion == 2) {
                    movimientoTerminado = true;
                }
            } else {
                movimientoTerminado = true;
            }
        } else {
            movimientoValido = false;
            if (moverContador > 1) {
                movimientoTerminado = true;
            }
        }
    }
}
