package com.mycompany.juegogameplay.Menu;

import com.mycompany.juegogameplay.Objetos.Objetos;
import com.mycompany.juegogameplay.Personajes.*;

public class Inventario {
    
    private Jugador jugador;
    private Jugables jugables[];
    private Objetos objetos[];

    public Inventario(Jugador jugador, Jugables[] jugables, Objetos[] objetos){
        System.out.println("Creando Inventario");
        this.jugador = jugador;
        this.jugables = jugables;
        this.objetos = objetos;
    }

    public void IniciarInventario(){
        int opcion = 0;
        do {
            Consola.LimpiarPantalla();
            Consola.Titulo("Inventario");
            System.out.println("Seleccione una opción al ingresar el número");
            System.out.println("1| Objetos");
            System.out.println("2| Personajes");
            System.out.println("3| Cerrar");

            // Se le solicita al usuario su opción
            opcion = Consola.readInt("Opción número: ");
            // Se valida la respuesta
            switch (opcion) {
                case 1:
                    Consola.LimpiarPantalla();
                    detallesObjetos();
                    break;
                case 2:
                    Consola.LimpiarPantalla();
                    String personaje = personajesDisponibles();
                    if (personaje != "") {
                        detallesPersonajes(personaje);
                    } else{
                        Consola.EnterContinuar();
                    }
                    break;
                case 3:
                    System.out.println("Cerrando...");
                    break;
                default:
                    Consola.Invalido();
                    break;
            }
        } while (opcion != 3);
    }

    private void detallesObjetos() {
        int opcion = 0;
        do {
            // Se abre la tienda de objetos
            Consola.LimpiarPantalla();
            Consola.Titulo("Objetos para batalla");
            System.out.println("1| Semilla de la vida");
            System.out.println("2| Elixir verde");
            System.out.println("3| Capa de movilidad");
            System.out.println("4| Regresar");
            opcion = Consola.readInt("Selecciona un objeto para ver más información");
            switch (opcion) {
                case 1:
                    objetos[0].caracteristicas();
                    jugador.setOro(objetos[0].vender(jugador.getOro()));
                    break;
                case 2:
                    objetos[1].caracteristicas();
                    jugador.setOro(objetos[1].vender(jugador.getOro()));
                    break;
                case 3:
                    objetos[2].caracteristicas();
                    jugador.setOro(objetos[2].vender(jugador.getOro()));
                    break;
                case 4:
                    System.out.println("Regresando...");
                    break;
                default:
                    Consola.Invalido();
                    break;
            }
        } while (opcion != 4);
    }

    public String personajesDisponibles() {
        String opcionLista[] = new String[5];
        int cont = 1;
        int opcion = 0;
        Consola.LimpiarPantalla();
        Consola.Titulo("Combatientes en el equipo");
        for (int i = 0; i < jugables.length; i++) {
            if (!jugables[i].personajeDisponible().equals("")) {
                System.out.println(cont + jugables[i].personajeDisponible());
                opcionLista[(cont-1)] = jugables[i].getCaracter();
                cont = cont + 1;
            }
        }
        if (opcionLista[0] == null) {
            System.out.println("Primero adquiere un combatiente");
            return opcionLista[0] = "";
        } else{
            opcion = Consola.readInt("Seleccione un personaje para ver su información");
            return opcionLista[(opcion-1)];
        }
    }

    private void detallesPersonajes(String personaje) {
        switch (personaje) {
            case "C":
                jugables[0].caracteristicas();
                Consola.EnterContinuar();
                break;
            case "A":
                jugables[1].caracteristicas();
                Consola.EnterContinuar();
                break;
            case "M":
                jugables[2].caracteristicas();
                Consola.EnterContinuar();
                break;
            case "G":
                jugables[3].caracteristicas();
                Consola.EnterContinuar();
                break;
            case "D":
                jugables[4].caracteristicas();
                Consola.EnterContinuar();
                break;
            default:
                Consola.Invalido();
                break;
        }

    }

}
