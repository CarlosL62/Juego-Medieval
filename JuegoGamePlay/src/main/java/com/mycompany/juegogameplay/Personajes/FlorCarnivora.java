package com.mycompany.juegogameplay.Personajes;

import com.mycompany.juegogameplay.Menu.Consola;

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

    // Modificación para el tipo de ataque
    @Override
    public Jugables[] ataquePersonaje(String[][] tablero, Jugables[] personajesJugar) {

        // Direccion de ataque aleatoria
        int opcion = Consola.numeroAleatorio(4, 1);
        String direccion = switch (opcion) {
            case 1 -> "A";
            case 2 -> "W";
            case 3 -> "S";
            case 4 -> "D";
            default -> "A";
        };

        switch (direccion) {
            case "A":
                for (int pcolumna = ycolumna; pcolumna >= (ycolumna - 3); pcolumna--) {
                    if (pcolumna == (ycolumna + 1)) {
                        // Verificación de coordenada válida
                        if (ataqueValido(tablero, xfila, pcolumna)) {
                            // Entonces realiza la muerte instantanea
                            int obj = 0;
                            for (int i = 0; i < personajesJugar.length; i++) {
                                if (personajesJugar[i].getXfila() == xfila
                                        && personajesJugar[i].getYcolumna() == pcolumna) {
                                    obj = i;
                                }
                            }
                            personajesJugar[obj].setVida(0);
                        }
                    } else {
                        // Verificación de coordenada válida
                        if (ataqueValido(tablero, xfila, pcolumna)) {
                            // Entonces realiza el ataque
                            int obj = 0;
                            for (int i = 0; i < personajesJugar.length; i++) {
                                if (personajesJugar[i].getXfila() == xfila
                                        && personajesJugar[i].getYcolumna() == pcolumna) {
                                    obj = i;
                                }
                            }
                            personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
                        } else {
                            // Coordenada incorrecta y continua
                        }
                    }
                }
                break;
            case "W":
                for (int pfila = xfila; pfila >= (xfila - 3); pfila--) {
                    if (pfila == (xfila - 1)) {
                        // Verificación de coordenada válida
                        if (ataqueValido(tablero, pfila, ycolumna)) {
                            // Entonces realiza la muerte instantanea
                            int obj = 0;
                            for (int i = 0; i < personajesJugar.length; i++) {
                                if (personajesJugar[i].getXfila() == pfila
                                        && personajesJugar[i].getYcolumna() == ycolumna) {
                                    obj = i;
                                }
                            }
                            personajesJugar[obj].setVida(0);
                        }
                    } else {
                        // Verificación de coordenada válida
                        if (ataqueValido(tablero, pfila, ycolumna)) {
                            // Entonces realiza el ataque
                            int obj = 0;
                            for (int i = 0; i < personajesJugar.length; i++) {
                                if (personajesJugar[i].getXfila() == pfila
                                        && personajesJugar[i].getYcolumna() == ycolumna) {
                                    obj = i;
                                }
                            }
                            personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
                        } else {
                            // Coordenada incorrecta y continua
                        }
                    }

                }
                break;
            case "S":
                for (int pfila = xfila; pfila <= (xfila + 3); pfila++) {
                    if (pfila == (xfila + 1)) {
                        // Verificación de coordenada válida
                        if (ataqueValido(tablero, pfila, ycolumna)) {
                            // Entonces realiza la muerte instantanea
                            int obj = 0;
                            for (int i = 0; i < personajesJugar.length; i++) {
                                if (personajesJugar[i].getXfila() == pfila
                                        && personajesJugar[i].getYcolumna() == ycolumna) {
                                    obj = i;
                                }
                            }
                            personajesJugar[obj].setVida(0);
                        }
                    } else {
                        // Verificación de coordenada válida
                        if (ataqueValido(tablero, pfila, ycolumna)) {
                            // Entonces realiza el ataque
                            int obj = 0;
                            for (int i = 0; i < personajesJugar.length; i++) {
                                if (personajesJugar[i].getXfila() == pfila
                                        && personajesJugar[i].getYcolumna() == ycolumna) {
                                    obj = i;
                                }
                            }
                            personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
                        } else {
                            // Coordenada incorrecta y continua
                        }
                    }

                }
                break;
            case "D":
                for (int pcolumna = ycolumna; pcolumna <= (pcolumna + 3); pcolumna++) {
                    if (pcolumna == (pcolumna + 1)) {
                        // Verificación de coordenada válida
                        if (ataqueValido(tablero, xfila, pcolumna)) {
                            // Entonces realiza la muerte instantanea
                            int obj = 0;
                            for (int i = 0; i < personajesJugar.length; i++) {
                                if (personajesJugar[i].getXfila() == xfila
                                        && personajesJugar[i].getYcolumna() == pcolumna) {
                                    obj = i;
                                }
                            }
                            personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
                        }
                    } else {
                        // Verificación de coordenada válida
                        if (ataqueValido(tablero, xfila, pcolumna)) {
                            // Entonces realiza el ataque
                            int obj = 0;
                            for (int i = 0; i < personajesJugar.length; i++) {
                                if (personajesJugar[i].getXfila() == xfila
                                        && personajesJugar[i].getYcolumna() == pcolumna) {
                                    obj = i;
                                }
                            }
                            personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
                        } else {
                            // Coordenada incorrecta y continua
                        }
                    }

                }
                break;
            default:

                break;
        }
        return personajesJugar;
    }
}
