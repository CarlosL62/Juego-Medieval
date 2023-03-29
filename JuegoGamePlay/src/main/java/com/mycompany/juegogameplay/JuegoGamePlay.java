package com.mycompany.juegogameplay;

import com.mycompany.juegogameplay.Menu.Consola;
import com.mycompany.juegogameplay.Menu.Menu;

//import org.fusesource.jansi.AnsiConsole;

/**
 *
 * @author carlos
 */
public class JuegoGamePlay {

    // Colores
    public static final String black = "\033[30m";
    public static final String red = "\033[31m";
    public static final String green = "\033[32m";
    public static final String yellow = "\033[33m";
    public static final String blue = "\033[34m";
    public static final String purple = "\033[35m";
    public static final String cyan = "\033[36m";
    public static final String white = "\033[37m";
    public static final String reset = "\u001B[0m";

    
    public static void main(String[] args) {

        //AnsiConsole.systemInstall();

        Consola.LimpiarPantalla();
        Consola.Titulo("La aventura del aventurero");
        Consola.EnterContinuar();
        Menu menu = new Menu();
        menu.mostrarMenu();

        //AnsiConsole.systemUninstall();

    }
}
