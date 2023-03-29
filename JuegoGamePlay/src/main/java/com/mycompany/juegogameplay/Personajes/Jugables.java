package com.mycompany.juegogameplay.Personajes;

import com.mycompany.juegogameplay.Menu.*;

public class Jugables extends Personajes{

    protected boolean disponible = false;
    

    // Características de cada personaje
    public void caracteristicas(){
        Consola.LimpiarPantalla();
        System.out.println(personaje + "\nVida: " + vida + "\nDaño: " + daño + "\nTipo de movimiento: " + tipoMovimiento + "\nCasillas de movimiento máxima: " + movimientoMax + "\nTipo de ataque: " + tipoAtaque);
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
        movimientoMax = movimientoMax + 1;
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

    public Enemigos[] ataquePersonaje(String[][] tablero, Enemigos[] enemigos){
        boolean coordenadaCorrecta = true;

        do {
            coordenadaCorrecta = true;

            //Solicitud de coordenadas de ataque
            System.out.println("Ingrese la coordenada que desea atacar");
            int xAtaque = Consola.readInt("Ingrese la fila");
            int yAtaque = Consola.readInt("Ingrese la columna");

            // Verificación de coordenada válida
            if ((xAtaque > 0 && yAtaque > 0 && xAtaque < tablero.length && yAtaque < tablero.length) && (tablero[xAtaque][yAtaque].equals("| "+red+"O"+reset+" |") || tablero[xAtaque][yAtaque].equals("| "+red+"K"+reset+" |") || tablero[xAtaque][yAtaque].equals("| "+red+"B"+reset+" |") || tablero[xAtaque][yAtaque].equals("| "+red+"E"+reset+" |") || tablero[xAtaque][yAtaque].equals("| "+red+"F"+reset+" |"))) {
                // Entonces realiza el ataque
                int obj = 0;
                for (int i = 0; i < enemigos.length; i++) {
                    if (enemigos[i].getXfila() == xAtaque && enemigos[i].getYcolumna() == yAtaque) {
                        obj = i;
                    }
                }
                enemigos[obj].setVida(enemigos[obj].getVida()-daño);
            } else {
                // Coordenada incorrecta
                System.out.println("Coordenada inválida");
                coordenadaCorrecta = false;
            } 
        } while (!coordenadaCorrecta);
        return enemigos;
    }
}
