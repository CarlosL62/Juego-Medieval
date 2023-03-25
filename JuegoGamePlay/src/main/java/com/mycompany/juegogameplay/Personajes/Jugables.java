package com.mycompany.juegogameplay.Personajes;

import com.mycompany.juegogameplay.Menu.*;

public class Jugables {

    protected String caracter;
    public String getCaracter() {
        return caracter;
    }

    protected String caracterImpreso;
    public String getCaracterImpreso() {
        return caracterImpreso;
    }

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

    protected boolean disponible = false;
    protected String personaje;
    public String getPersonaje(){
        return personaje;
    }
    
    protected int vida;
    protected int daño;
    protected String tipoMovimiento;
    protected String tipoAtaque;

    //Variables de coordenadas de posición
    protected int xfila;
    protected int ycolumna;

    public void setXfila(int xfila) {
        this.xfila = xfila;
    }

    public void setYcolumna(int ycolumna) {
        this.ycolumna = ycolumna;
    }

    //Variables de tipo
    //0= computadora, 1 = humano 
    protected int tipoPersonaje;

    // Características de cada personaje
    public void caracteristicas(){
        Consola.LimpiarPantalla();
        System.out.println(personaje + "\nVida: " + vida + "\nDaño: " + daño + "\nTipo de movimiento: " + tipoMovimiento + "\nTipo de ataque: " + tipoAtaque);
    }

    // Compra de personaje
    public int comprar(int oro){
        int opcion = 0;
        System.out.println("Oro disponible: " + oro);
        if (disponible) {
            System.out.println("Ya adquiriste a este personaje");
            Consola.EnterContinuar();
        } else {
            do {
                opcion = Consola.readInt("¿Desea comprar a " + personaje + " por 200 de oro?\n1| Sí\n2| No\n");
                // Se valida la respuesta
                switch (opcion) {
                    case 1:
                        if (oro < 200) {
                            System.out.println("No tienes suficiente oro");
                        } else {
                            // Se descuenta el oro gastado
                            oro = oro - 200;
                            System.out.println(personaje + " adquirido");
                            disponible = true;
                        }
                        Consola.EnterContinuar();
                        break;
                    case 2:
                        System.out.println("Regresando...");
                    default:
                        Consola.Invalido();
                        break;
                }
            } while (opcion != 1 && opcion != 2);
        }
        return oro;
    }

    public void mejorarVida(){
        vida = vida + 50;
    }

    public void mejorarDaño(){
        daño = daño + 10;
    }

    public void mejorarMovilidad(){
        //Casilla extra de movimiento
    }

    //Personajes disponibles
    public String personajeDisponible() {
        String texto = null;
        if (!disponible) {
            texto = "";
        } else {
            texto = ("| " + personaje);
        }
        return texto;
    }

    //Movimiento de los personajes
    public String[][] movimientoPersonajes(String[][] tablero){
        boolean movimientoValido = true;
        String movimientoTeclado = "";
        do {
            movimientoTeclado = Consola.readString("Mueva al "+ personaje +" usando AWSD");
            movimientoTeclado = movimientoTeclado.toUpperCase();
            int lim = tablero.length;

            switch (movimientoTeclado) {
                case "A":
                    if(tablero[xfila][ycolumna-1] == "|   |"){

                    }


                    //Se elimina el primer espacio donde estaba el caracter
                    tablero[xfila][ycolumna] = "|   |";
                    //Se crea la nueva ubicación de caracter
                    ycolumna -= 1;
                    tablero[xfila][ycolumna] = "| "+caracterImpreso+" |";
                    break;
                case "W":
                    tablero[xfila][ycolumna] = "|   |";
                    tablero[xfila-1][ycolumna] = "| "+caracterImpreso+" |";
                    break;
                case "S":
                    tablero[xfila][ycolumna] = "|   |";
                    tablero[xfila+1][ycolumna] = "| "+caracterImpreso+" |";
                    break;
                case "D":
                    tablero[xfila][ycolumna] = "|   |";
                    tablero[xfila][ycolumna+1] = "| "+caracterImpreso+" |";
                    break;
                default:
                    System.out.println("Movimiento inválido");
                    movimientoValido = false;
                    break;
            }
        } while (!movimientoValido);
        return tablero;
    }

}
