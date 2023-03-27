package com.mycompany.juegogameplay.Personajes;

public class FlorCarnivora extends Enemigos{
    
    private int vida = 250;
    private int daño = 30;

    public FlorCarnivora() {
        super.caracter = "F";
        super.caracterImpreso = (red+caracter+reset);
        super.movimientoMax = 0;
        super.personaje = "Flor carnívora";
        super.vida = vida;
        super.daño = daño; 
        super.tipoMovimiento = "Tierra, no se mueve";
        super.tipoAtaque = "Golpea con sus raíces a todos los personajes que estén en una línea en un rango de tres casillas. Si el jugador está a un cuadro de la flor, esta se lo comerá, matando así al personaje";
    }

    //Modificación para que no se pueda mover
    @Override
    public String[][] movimientoPersonajes(String[][] tablero){
        System.out.println("El enemigo intento mover a " + personaje + "\ntal parece no se puede mover una flor carnívora");
        return tablero;
    }
}
