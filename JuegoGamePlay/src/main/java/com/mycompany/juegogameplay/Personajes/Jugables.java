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

}
