package com.mycompany.juegogameplay.Personajes;

import com.mycompany.juegogameplay.Menu.Consola;
import com.mycompany.juegogameplay.Menu.Jugador;

public class Dragon extends Jugables {
    
    private boolean disponible = false;
    private int vida = 150;
    private int daño = 100;
    private int movimientoMax = 3;

    public Dragon() {
        super.caracter = "D";
        super.caracterImpreso = (purple+caracter+reset);
        super.disponible = disponible;
        super.movimientoMax = movimientoMax;
        super.personaje = "Dragon";
        super.vida = vida;
        super.daño = daño;
        super.tipoMovimiento = "Vuela, hasta tres cuadros por turno";
        super.tipoAtaque = "En línea y en un rango de dos cuadros a todo lo que esté en dicho rango";
    }

    //Modificación para que tome en cuenta que vuela
    @Override
    public void movimientoPersonajeValido(String[][] tablero, int destinoX, int destinoY) {
        // Verificación que el movimiento sea válido, primero que este dentro del
        // tablero y que sea a una casilla válida
        if((destinoX > 0 && destinoY > 0 && destinoX < tablero.length && destinoY < tablero.length) && 
        (tablero[destinoX][destinoY].equals("| "+reset+"_"+reset+" |") || 
        tablero[destinoX][destinoY].equals("| "+yellow+"$"+reset+" |") ||
        tablero[destinoX][destinoY].equals("| " + green + "T" + reset + " |") || 
        tablero[destinoX][destinoY].equals("| " + blue + "~" + reset + " |"))){

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

    
    /*@Override
    public boolean movimientoPersonajeValido(String[][] tablero, int destinoX, int destinoY){
        boolean dentroArea = false;
        //Verificación que el movimiento sea válido, primero que este dentro del tablero y que sea a una casilla válida
        if((destinoX > 0 && destinoY > 0 && destinoX < tablero.length && destinoY < tablero.length) && 
        (tablero[destinoX][destinoY].equals("| "+reset+"_"+reset+" |") || 
        tablero[destinoX][destinoY].equals("| "+yellow+"$"+reset+" |") ||
        tablero[destinoX][destinoY].equals("| " + green + "T" + reset + " |") || 
        tablero[destinoX][destinoY].equals("| " + blue + "~" + reset + " |"))){
            
            dentroArea = true;
        }

        return dentroArea;
    }*/
}
