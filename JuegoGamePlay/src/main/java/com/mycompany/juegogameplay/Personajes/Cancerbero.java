package com.mycompany.juegogameplay.Personajes;

public class Cancerbero extends Enemigos{
    
    private int vida = 400;
    private int daño = 45;

    public Cancerbero() {
        super.caracter = "E";
        super.caracterImpreso = (red+caracter+reset);
        super.movimientoMax = 1;
        super.personaje = "Cancerbero";
        super.vida = vida;
        super.daño = daño;
        super.tipoMovimiento = "Tierra, un cuadro por turno";
        super.tipoAtaque = "Incendia todo a su alrededor, en un rango de un cuadro";
    }

    //Modificación para el tipo de ataque
    @Override
    public Jugables[] ataquePersonaje(String[][] tablero, Jugables[] personajesJugar){

        // Ataque hacia la izquierda
        if (ataqueValido(tablero, xfila, ycolumna - 1)) {
            // Entonces realiza el ataque
            int obj = 0;
            for (int i = 0; i < personajesJugar.length; i++) {
                if (personajesJugar[i].getXfila() == xfila && personajesJugar[i].getYcolumna() == (ycolumna - 1)) {
                    obj = i;
                }
            }
            personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
        } else {
            // Coordenada incorrecta, no hace nada
        }
        
        // Ataque hacia arriba
        if (ataqueValido(tablero, xfila - 1, ycolumna)) {
            // Entonces realiza el ataque
            int obj = 0;
            for (int i = 0; i < personajesJugar.length; i++) {
                if (personajesJugar[i].getXfila() == (xfila - 1) && personajesJugar[i].getYcolumna() == ycolumna) {
                    obj = i;
                }
            }
            personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
        } else {
            // Coordenada incorrecta, no hace nada
        }

        // Ataque hacia abajo
        if (ataqueValido(tablero, xfila + 1, ycolumna)) {
            // Entonces realiza el ataque
            int obj = 0;
            for (int i = 0; i < personajesJugar.length; i++) {
                if (personajesJugar[i].getXfila() == (xfila + 1) && personajesJugar[i].getYcolumna() == ycolumna) {
                    obj = i;
                }
            }
            personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
        } else {
            // Coordenada incorrecta, no hace nada
        }

        // Ataque hacia la derecha
        if (ataqueValido(tablero, xfila, ycolumna + 1)) {
            // Entonces realiza el ataque
            int obj = 0;
            for (int i = 0; i < personajesJugar.length; i++) {
                if (personajesJugar[i].getXfila() == xfila && personajesJugar[i].getYcolumna() == (ycolumna + 1)) {
                    obj = i;
                }
            }
            personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
        } else {
            // Coordenada incorrecta, no hace nada
        }

        // Ataque hacia arriba derecha
        if (ataqueValido(tablero, xfila - 1, ycolumna + 1)) {
            // Entonces realiza el ataque
            int obj = 0;
            for (int i = 0; i < personajesJugar.length; i++) {
                if (personajesJugar[i].getXfila() == (xfila - 1) && personajesJugar[i].getYcolumna() == (ycolumna + 1)) {
                    obj = i;
                }
            }
            personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
        } else {
            // Coordenada incorrecta, no hace nada
        }


        // Ataque hacia arriba izquierda
        if (ataqueValido(tablero, xfila - 1, ycolumna - 1)) {
            // Entonces realiza el ataque
            int obj = 0;
            for (int i = 0; i < personajesJugar.length; i++) {
                if (personajesJugar[i].getXfila() == (xfila - 1) && personajesJugar[i].getYcolumna() == (ycolumna - 1)) {
                    obj = i;
                }
            }
            personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
        } else {
            // Coordenada incorrecta, no hace nada
        }

        // Ataque hacia abajo derecha
        if (ataqueValido(tablero, xfila + 1, ycolumna + 1)) {
            // Entonces realiza el ataque
            int obj = 0;
            for (int i = 0; i < personajesJugar.length; i++) {
                if (personajesJugar[i].getXfila() == (xfila + 1) && personajesJugar[i].getYcolumna() == (ycolumna + 1)) {
                    obj = i;
                }
            }
            personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
        } else {
            // Coordenada incorrecta, no hace nada
        }

        // Ataque hacia abajo izquierda
        if (ataqueValido(tablero, xfila + 1, ycolumna - 1)) {
            // Entonces realiza el ataque
            int obj = 0;
            for (int i = 0; i < personajesJugar.length; i++) {
                if (personajesJugar[i].getXfila() == (xfila + 1) && personajesJugar[i].getYcolumna() == (ycolumna - 1)) {
                    obj = i;
                }
            }
            personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
        } else {
            // Coordenada incorrecta, no hace nada
        }

        return personajesJugar;
    }
}
