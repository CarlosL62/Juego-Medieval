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
        super.tipoMovimiento = "Vuela, hasta en una línea";
        super.tipoAtaque = "Lanza un hechizo en toda una línea, que impacta con el primer personaje o árbol que encuentre";
    }

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
