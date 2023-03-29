package com.mycompany.juegogameplay.Personajes;

public class Caballero extends Jugables {

    private boolean disponible = false;
    private int vida = 300;
    private int daño = 45;
    private int movimientoMax = 1;

    public Caballero() {
        super.caracter = "C";
        super.caracterImpreso = (purple + caracter + reset);
        super.disponible = disponible;
        super.movimientoMax = movimientoMax;
        super.personaje = "Caballero";
        super.vida = vida;
        super.daño = daño;
        super.tipoMovimiento = "Tierra, un cuadro por turno";
        super.tipoAtaque = "Golpea con su espada a todos a su alrededor";
    }

    // Modificación para el tipo de ataque
    @Override
    public Enemigos[] ataquePersonaje(String[][] tablero, Enemigos[] enemigos) {

        // Ataque hacia la izquierda
        if (ataqueValido(tablero, xfila, ycolumna - 1)) {
            if (tablero[xfila][ycolumna - 1].equals("| " + green + "T" + reset + " |")) {
                tablero[xfila][ycolumna - 1] = ("| " + reset + "_" + reset + " |");
            } else {
                // Entonces realiza el ataque
                int obj = 0;
                for (int i = 0; i < enemigos.length; i++) {
                    if (enemigos[i].getXfila() == xfila && enemigos[i].getYcolumna() == (ycolumna - 1)) {
                        obj = i;
                    }
                }
                enemigos[obj].setVida(enemigos[obj].getVida() - daño);
            }
        } else {
            // Coordenada incorrecta, no hace nada
        }

        // Ataque hacia arriba
        if (ataqueValido(tablero, xfila - 1, ycolumna)) {
            if (tablero[xfila - 1][ycolumna].equals("| " + green + "T" + reset + " |")) {
                tablero[xfila - 1][ycolumna] = ("| " + reset + "_" + reset + " |");
            } else {
                // Entonces realiza el ataque
                int obj = 0;
                for (int i = 0; i < enemigos.length; i++) {
                    if (enemigos[i].getXfila() == (xfila - 1) && enemigos[i].getYcolumna() == ycolumna) {
                        obj = i;
                    }
                }
                enemigos[obj].setVida(enemigos[obj].getVida() - daño);
            }
        } else {
            // Coordenada incorrecta, no hace nada
        }

        // Ataque hacia abajo
        if (ataqueValido(tablero, xfila + 1, ycolumna)) {
            if (tablero[xfila + 1][ycolumna].equals("| " + green + "T" + reset + " |")) {
                tablero[xfila + 1][ycolumna] = ("| " + reset + "_" + reset + " |");
            } else {
                // Entonces realiza el ataque
                int obj = 0;
                for (int i = 0; i < enemigos.length; i++) {
                    if (enemigos[i].getXfila() == (xfila + 1) && enemigos[i].getYcolumna() == ycolumna) {
                        obj = i;
                    }
                }
                enemigos[obj].setVida(enemigos[obj].getVida() - daño);
            }

        } else {
            // Coordenada incorrecta, no hace nada
        }

        // Ataque hacia la derecha
        if (ataqueValido(tablero, xfila, ycolumna + 1)) {
            if (tablero[xfila][ycolumna + 1].equals("| " + green + "T" + reset + " |")) {
                tablero[xfila][ycolumna + 1] = ("| " + reset + "_" + reset + " |");
            } else {
                // Entonces realiza el ataque
                int obj = 0;
                for (int i = 0; i < enemigos.length; i++) {
                    if (enemigos[i].getXfila() == xfila && enemigos[i].getYcolumna() == (ycolumna + 1)) {
                        obj = i;
                    }
                }
                enemigos[obj].setVida(enemigos[obj].getVida() - daño);
            }

        } else {
            // Coordenada incorrecta, no hace nada
        }

        // Ataque hacia arriba derecha
        if (ataqueValido(tablero, xfila - 1, ycolumna + 1)) {
            // Entonces realiza el ataque
            int obj = 0;
            for (int i = 0; i < enemigos.length; i++) {
                if (enemigos[i].getXfila() == (xfila - 1) && enemigos[i].getYcolumna() == (ycolumna + 1)) {
                    obj = i;
                }
            }
            enemigos[obj].setVida(enemigos[obj].getVida() - daño);
        } else {
            // Coordenada incorrecta, no hace nada
        }

        // Ataque hacia arriba izquierda
        if (ataqueValido(tablero, xfila - 1, ycolumna - 1)) {
            if (tablero[xfila - 1][ycolumna - 1].equals("| " + green + "T" + reset + " |")) {
                tablero[xfila - 1][ycolumna - 1] = ("| " + reset + "_" + reset + " |");
            } else {
                // Entonces realiza el ataque
                int obj = 0;
                for (int i = 0; i < enemigos.length; i++) {
                    if (enemigos[i].getXfila() == (xfila - 1) && enemigos[i].getYcolumna() == (ycolumna - 1)) {
                        obj = i;
                    }
                }
                enemigos[obj].setVida(enemigos[obj].getVida() - daño);
            }

        } else {
            // Coordenada incorrecta, no hace nada
        }

        // Ataque hacia abajo derecha
        if (ataqueValido(tablero, xfila + 1, ycolumna + 1)) {
            if (tablero[xfila + 1][ycolumna + 1].equals("| " + green + "T" + reset + " |")) {
                tablero[xfila + 1][ycolumna + 1] = ("| " + reset + "_" + reset + " |");
            } else {
                // Entonces realiza el ataque
                int obj = 0;
                for (int i = 0; i < enemigos.length; i++) {
                    if (enemigos[i].getXfila() == (xfila + 1) && enemigos[i].getYcolumna() == (ycolumna + 1)) {
                        obj = i;
                    }
                }
                enemigos[obj].setVida(enemigos[obj].getVida() - daño);
            }

        } else {
            // Coordenada incorrecta, no hace nada
        }

        // Ataque hacia abajo izquierda
        if (ataqueValido(tablero, xfila + 1, ycolumna - 1)) {
            if (tablero[xfila + 1][ycolumna - 1].equals("| " + green + "T" + reset + " |")) {
                tablero[xfila + 1][ycolumna - 1] = ("| " + reset + "_" + reset + " |");
            } else {
                // Entonces realiza el ataque
                int obj = 0;
                for (int i = 0; i < enemigos.length; i++) {
                    if (enemigos[i].getXfila() == (xfila + 1) && enemigos[i].getYcolumna() == (ycolumna - 1)) {
                        obj = i;
                    }
                }
                enemigos[obj].setVida(enemigos[obj].getVida() - daño);
            }

        } else {
            // Coordenada incorrecta, no hace nada
        }

        return enemigos;
    }

}
