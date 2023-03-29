package com.mycompany.juegogameplay.Personajes;

import com.mycompany.juegogameplay.Menu.Consola;

public class Gargola extends Enemigos{
    
    private int vida = 150;
    private int daño = 100;

    public Gargola() {
        super.caracter = "K";
        super.caracterImpreso = (red+caracter+reset);
        super.movimientoMax = 3;
        super.personaje = "Gargola";
        super.vida = vida;
        super.daño = daño;
        super.tipoMovimiento = "Vuela, hasta tres cuadros a la vez";
        super.tipoAtaque = "Lanza una bola de fuego en una línea en un rango de dos cuadros, que impacta con el primer personaje del jugador que encuentre";
    }

    //Modificación para que tome en cuenta que vuela
    @Override
    public void movimientoPersonajeValido(String[][] tablero, int destinoX, int destinoY) {
        // Verificación que el movimiento sea válido, primero que este dentro del
        // tablero y que sea a una casilla válida
        if ((destinoX > 0 && destinoY > 0 && destinoX < tablero.length && destinoY < tablero.length) &&
            (tablero[destinoX][destinoY].equals("| " + reset + "_" + reset + " |") ||
            tablero[destinoX][destinoY].equals("| " + yellow + "$" + reset + " |") ||
            tablero[destinoX][destinoY].equals("| " + green + "T" + reset + " |") ||
            tablero[destinoX][destinoY].equals("| " + blue + "~" + reset + " |"))) {

            // Realizamos el cambio de las casillas originales y movemos al personaje
            tablero[xfila][ycolumna] = casillaOriginal;
            xfila = destinoX;
            ycolumna = destinoY;
            casillaOriginal = tablero[xfila][ycolumna];
            tablero[xfila][ycolumna] = "| " + caracterImpreso + " |";

            // De forma aleatoria, el enemigo se moverá más o no
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
