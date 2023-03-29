package com.mycompany.juegogameplay.Personajes;

import com.mycompany.juegogameplay.Menu.Consola;

public class Gargola extends Enemigos {

    private int vida = 150;
    private int daño = 100;

    public Gargola() {
        super.caracter = "K";
        super.caracterImpreso = (red + caracter + reset);
        super.movimientoMax = 3;
        super.personaje = "Gargola";
        super.vida = vida;
        super.daño = daño;
        super.tipoMovimiento = "Vuela, hasta tres cuadros a la vez";
        super.tipoAtaque = "Lanza una bola de fuego en una línea en un rango de dos cuadros, que impacta con el primer personaje del jugador que encuentre";
    }

    // Modificación para que tome en cuenta que vuela
    @Override
    public void movimientoPersonajeValido(String[][] tablero, int destinoX, int destinoY) {
        // Verificación que el movimiento sea válido, primero que este dentro del
        // tablero y que sea a una casilla válida
        if ((destinoX > 0 && destinoY > 0 && destinoX < tablero.length && destinoY < tablero.length) &&
                (tablero[destinoX][destinoY].equals("| " + reset + "_" + reset + " |") ||
                        tablero[destinoX][destinoY].equals("| " + yellow + "$" + reset + " |") ||
                        tablero[destinoX][destinoY].equals("| " + green + "T" + reset + " |") ||
                        tablero[destinoX][destinoY].equals("| " + blue + "~" + reset + " |"))) {

            // Realizamos el cambio de las casillas originales y movemos al personaje
            tablero[xfila][ycolumna] = casillaOriginal;
            xfila = destinoX;
            ycolumna = destinoY;
            casillaOriginal = tablero[xfila][ycolumna];
            tablero[xfila][ycolumna] = "| " + caracterImpreso + " |";

            // De forma aleatoria, el enemigo se moverá más o no
            if (moverContador < movimientoMax) {
                int opcion = Consola.numeroAleatorio(2, 1);
                if (opcion == 1) {
                    moverContador = moverContador + 1;
                } else if (opcion == 2) {
                    movimientoTerminado = true;
                }
            } else {
                movimientoTerminado = true;
            }
        } else {
            movimientoValido = false;
            if (moverContador > 1) {
                movimientoTerminado = true;
            }
        }
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
                for (int pcolumna = ycolumna; pcolumna >= (ycolumna - 2); pcolumna--) {
                    // Verificación de coordenada válida
                    if (ataqueValido(tablero, xfila, pcolumna)) {
                        if (tablero[xfila][pcolumna].equals("| " + green + "T" + reset + " |")) {
                            tablero[xfila][pcolumna] = ("| " + reset + "_" + reset + " |");
                        } else {
                            // Entonces realiza el ataque
                            int obj = 0;
                            for (int i = 0; i < personajesJugar.length; i++) {
                                if (personajesJugar[i].getXfila() == xfila
                                        && personajesJugar[i].getYcolumna() == pcolumna) {
                                    obj = i;
                                }
                            }
                            personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
                            break;
                        }

                    } else {
                        // Coordenada incorrecta y continua
                    }
                }
                break;
            case "W":
                for (int pfila = xfila; pfila >= (xfila - 2); pfila--) {
                    // Verificación de coordenada válida
                    if (ataqueValido(tablero, pfila, ycolumna)) {
                        if (tablero[pfila][ycolumna].equals("| " + green + "T" + reset + " |")) {
                            tablero[pfila][ycolumna] = ("| " + reset + "_" + reset + " |");
                        } else {
                            // Entonces realiza el ataque
                            int obj = 0;
                            for (int i = 0; i < personajesJugar.length; i++) {
                                if (personajesJugar[i].getXfila() == pfila
                                        && personajesJugar[i].getYcolumna() == ycolumna) {
                                    obj = i;
                                }
                            }
                            personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
                            break;
                        }

                    } else {
                        // Coordenada incorrecta y continua
                    }
                }
                break;
            case "S":
                for (int pfila = xfila; pfila <= (xfila + 2); pfila++) {
                    // Verificación de coordenada válida
                    if (ataqueValido(tablero, pfila, ycolumna)) {
                        if (tablero[pfila][ycolumna].equals("| " + green + "T" + reset + " |")) {
                            tablero[pfila][ycolumna] = ("| " + reset + "_" + reset + " |");
                        } else {
                            // Entonces realiza el ataque
                            int obj = 0;
                            for (int i = 0; i < personajesJugar.length; i++) {
                                if (personajesJugar[i].getXfila() == pfila
                                        && personajesJugar[i].getYcolumna() == ycolumna) {
                                    obj = i;
                                }
                            }
                            personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
                            break;
                        }

                    } else {
                        // Coordenada incorrecta y continua
                    }
                }
                break;
            case "D":
                for (int pcolumna = ycolumna; pcolumna <= (pcolumna + 2); pcolumna++) {
                    // Verificación de coordenada válida
                    if (ataqueValido(tablero, xfila, pcolumna)) {
                        if (tablero[xfila][pcolumna].equals("| " + green + "T" + reset + " |")) {
                            tablero[xfila][pcolumna] = ("| " + reset + "_" + reset + " |");
                        } else {
                            // Entonces realiza el ataque
                            int obj = 0;
                            for (int i = 0; i < personajesJugar.length; i++) {
                                if (personajesJugar[i].getXfila() == xfila
                                        && personajesJugar[i].getYcolumna() == pcolumna) {
                                    obj = i;
                                }
                            }
                            personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
                            break;
                        }

                    } else {
                        // Coordenada incorrecta y continua
                    }
                }
                break;
            default:

                break;
        }
        return personajesJugar;
    }
}
