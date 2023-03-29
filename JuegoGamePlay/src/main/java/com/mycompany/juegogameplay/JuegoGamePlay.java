package com.mycompany.juegogameplay;

import com.mycompany.juegogameplay.Menu.Consola;
import com.mycompany.juegogameplay.Menu.Menu;

/**
 *
 * @author carlos
 */
public class JuegoGamePlay {

    
    public static void main(String[] args) {

        Consola.LimpiarPantalla();
        Consola.Titulo("La aventura del aventurero");
        Consola.EnterContinuar();
        Menu menu = new Menu();
        menu.mostrarMenu();

    }
}
