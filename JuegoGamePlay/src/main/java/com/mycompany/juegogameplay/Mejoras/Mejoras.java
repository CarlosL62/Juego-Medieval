package com.mycompany.juegogameplay.Mejoras;

import com.mycompany.juegogameplay.Menu.*;
import com.mycompany.juegogameplay.Personajes.*;

public class Mejoras {

    protected String nombreMejora;
    protected String descripcion;
    protected int precio;
    protected Jugables jugables[];

    // Características de cada mejora
    public void caracteristicas() {
        Consola.LimpiarPantalla();
        System.out.println(nombreMejora);
        System.out.println("Precio: " + precio);
        System.out.println("Descripción: " + descripcion);
    }

    // Compra de mejoras
    public int comprar(int oro, String personaje) {
        int opcion = 0;
        System.out.println("Oro disponible: " + oro);
        do {
            opcion = Consola.readInt("¿Desea comprar " + nombreMejora + " por " + precio + " de oro?\n1| Sí\n2| No\n");
            // Se valida la respuesta
            switch (opcion) {
                case 1:
                    if (oro < precio) {
                        System.out.println("No tienes suficiente oro");
                    } else {
                        // Se descuenta el oro gastado
                        oro -= precio;
                        System.out.println(nombreMejora + " adquirida");
                        mejoraAAPlicar(personaje);
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
        return oro;
    }

    public void mejoraAAPlicar(String personaje){
        switch (personaje) {
            case "C":
                //jugables[0].mejora();
                break;
            case "A":
                //jugables[1].mejora();
                break;
            case "M":
                //jugables[2].mejora);
                break;
            case "G":
                //jugables[3].mejora();
                break;
            case "D":
                //jugables[4].mejora();
                break;
            default:
                //Invalido
                break;
        }
    }
}
