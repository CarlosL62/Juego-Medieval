package com.mycompany.juegogameplay.Objetos;

import com.mycompany.juegogameplay.Menu.*;

public class Objetos {

    protected String nombreObjeto;
    protected String descripcion;
    protected int cantidadDisponible;
    protected int precio;

    // Características de cada objeto
    public void caracteristicas() {
        Consola.LimpiarPantalla();
        System.out.println(nombreObjeto);
        System.out.println("Precio: " + precio);
        System.out.println("Descripción: " + descripcion);
        System.out.println(nombreObjeto + " en inventario: " + cantidadDisponible);
    }

    
    //Compra de objeto
    public int comprar(int oro) {
        int opcion = 0;
        System.out.println("Oro disponible: " + oro);
        do {
            opcion = Consola.readInt("¿Desea comprar " + nombreObjeto + " por " + precio + " de oro?\n1| Sí\n2| No\n");
            // Se valida la respuesta
            switch (opcion) {
                case 1:
                    if (oro < precio) {
                        System.out.println("No tienes suficiente oro");
                    } else {
                        // Se descuenta el oro gastado
                        oro -= precio;
                        System.out.println(nombreObjeto + " adquirido");
                        cantidadDisponible += 1;
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

    public int vender(int oro){
        int opcion = 0;
        System.out.println("Oro disponible: " + oro);
        do {
            opcion = Consola.readInt("¿Desea vender " + nombreObjeto + " por " + precio + " de oro?\n1| Sí\n2| No\n");
            // Se valida la respuesta
            switch (opcion) {
                case 1:
                    if (cantidadDisponible < 1) {
                        System.out.println("No tienes " + nombreObjeto + " en tu inventario");
                    } else {
                        // Se suma el oro de la venta
                        oro += precio;
                        System.out.println(nombreObjeto + " vendido");
                        cantidadDisponible -= 1;
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

}
