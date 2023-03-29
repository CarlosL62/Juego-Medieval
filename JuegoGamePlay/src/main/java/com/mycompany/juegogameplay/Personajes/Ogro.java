package com.mycompany.juegogameplay.Personajes;

import com.mycompany.juegogameplay.Menu.Consola;

public class Ogro extends Enemigos{
    
    private int vida = 300;
    private int daño = 50;

    public Ogro() {
        super.caracter = "O";
        super.caracterImpreso = (red+caracter+reset);
        super.movimientoMax = 1;
        super.personaje = "Ogro";
        super.vida = vida;
        super.daño = daño;
        super.tipoMovimiento = "Tierra, un cuadro a la vez";
        super.tipoAtaque = "Golpea con su bastón a un punto en un rango de un cuadro a su alrededor";
    }

    // Modificación para el tipo de ataque
    @Override
    public Jugables[] ataquePersonaje(String[][] tablero, Jugables[] personajesJugar) {

        switch (Consola.numeroAleatorio(8, 1)) {
            case 1:
                // Ataque hacia la izquierda
                if (ataqueValido(tablero, xfila, ycolumna - 1)) {
                    // Entonces realiza el ataque
                    int obj = 0;
                    for (int i = 0; i < personajesJugar.length; i++) {
                        if (personajesJugar[i].getXfila() == xfila
                                && personajesJugar[i].getYcolumna() == (ycolumna - 1)) {
                            obj = i;
                        }
                    }
                    personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
                } else {
                    // Coordenada incorrecta, no hace nada
                }
                break;
            case 2:
                // Ataque hacia arriba
                if (ataqueValido(tablero, xfila - 1, ycolumna)) {
                    // Entonces realiza el ataque
                    int obj = 0;
                    for (int i = 0; i < personajesJugar.length; i++) {
                        if (personajesJugar[i].getXfila() == (xfila - 1)
                                && personajesJugar[i].getYcolumna() == ycolumna) {
                            obj = i;
                        }
                    }
                    personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
                } else {
                    // Coordenada incorrecta, no hace nada
                }
                break;
            case 3:
                // Ataque hacia abajo
                if (ataqueValido(tablero, xfila + 1, ycolumna)) {
                    // Entonces realiza el ataque
                    int obj = 0;
                    for (int i = 0; i < personajesJugar.length; i++) {
                        if (personajesJugar[i].getXfila() == (xfila + 1)
                                && personajesJugar[i].getYcolumna() == ycolumna) {
                            obj = i;
                        }
                    }
                    personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
                } else {
                    // Coordenada incorrecta, no hace nada
                }
                break;
            case 4:
                // Ataque hacia la derecha
                if (ataqueValido(tablero, xfila, ycolumna + 1)) {
                    // Entonces realiza el ataque
                    int obj = 0;
                    for (int i = 0; i < personajesJugar.length; i++) {
                        if (personajesJugar[i].getXfila() == xfila
                                && personajesJugar[i].getYcolumna() == (ycolumna + 1)) {
                            obj = i;
                        }
                    }
                    personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
                } else {
                    // Coordenada incorrecta, no hace nada
                }
                break;
            case 5:
                // Ataque hacia arriba derecha
                if (ataqueValido(tablero, xfila - 1, ycolumna + 1)) {
                    // Entonces realiza el ataque
                    int obj = 0;
                    for (int i = 0; i < personajesJugar.length; i++) {
                        if (personajesJugar[i].getXfila() == (xfila - 1)
                                && personajesJugar[i].getYcolumna() == (ycolumna + 1)) {
                            obj = i;
                        }
                    }
                    personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
                } else {
                    // Coordenada incorrecta, no hace nada
                }
                break;
            case 6:
                // Ataque hacia arriba izquierda
                if (ataqueValido(tablero, xfila - 1, ycolumna - 1)) {
                    // Entonces realiza el ataque
                    int obj = 0;
                    for (int i = 0; i < personajesJugar.length; i++) {
                        if (personajesJugar[i].getXfila() == (xfila - 1)
                                && personajesJugar[i].getYcolumna() == (ycolumna - 1)) {
                            obj = i;
                        }
                    }
                    personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
                } else {
                    // Coordenada incorrecta, no hace nada
                }
                break;
            case 7:
                // Ataque hacia abajo derecha
                if (ataqueValido(tablero, xfila + 1, ycolumna + 1)) {
                    // Entonces realiza el ataque
                    int obj = 0;
                    for (int i = 0; i < personajesJugar.length; i++) {
                        if (personajesJugar[i].getXfila() == (xfila + 1)
                                && personajesJugar[i].getYcolumna() == (ycolumna + 1)) {
                            obj = i;
                        }
                    }
                    personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
                } else {
                    // Coordenada incorrecta, no hace nada
                }
                break;
            case 8:
                // Ataque hacia abajo izquierda
                if (ataqueValido(tablero, xfila + 1, ycolumna - 1)) {
                    // Entonces realiza el ataque
                    int obj = 0;
                    for (int i = 0; i < personajesJugar.length; i++) {
                        if (personajesJugar[i].getXfila() == (xfila + 1)
                                && personajesJugar[i].getYcolumna() == (ycolumna - 1)) {
                            obj = i;
                        }
                    }
                    personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
                } else {
                    // Coordenada incorrecta, no hace nada
                }
                break;
            default:
                break;
        }

        return personajesJugar;
    }
}
