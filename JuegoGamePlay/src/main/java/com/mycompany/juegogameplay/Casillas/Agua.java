package com.mycompany.juegogameplay.Casillas;

public class Agua extends Casillas{
    
    public Agua(){
        super.caracter = "~";
        super.casillaTipo = blue+caracter+reset;
    }

    @Override
    public Casillas crearCasilla(){
        Casillas agua = new Agua();
        return agua;
    }
}
