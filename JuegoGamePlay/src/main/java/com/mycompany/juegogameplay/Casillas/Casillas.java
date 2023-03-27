package com.mycompany.juegogameplay.Casillas;

public class Casillas {
    
    // Colores
    protected String black = "\033[30m";
    protected String red = "\033[31m";
    protected String green = "\033[32m";
    protected String yellow = "\033[33m";
    protected String blue = "\033[34m";
    protected String purple = "\033[35m";
    protected String cyan = "\033[36m";
    protected String white = "\033[37m";
    protected String reset = "\u001B[0m";

    //Tipos de casillas
    protected String caracter;
    protected String casillaTipo;

    public String getCasillaTipo() {
        return casillaTipo;
    }

    public Casillas crearCasilla(){
        Casillas casillas = new Casillas();
        return casillas;
    }

    public void funcionCasilla(){

    }
}
