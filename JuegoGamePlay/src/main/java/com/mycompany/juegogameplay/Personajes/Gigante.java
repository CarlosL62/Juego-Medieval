package com.mycompany.juegogameplay.Personajes;

import com.mycompany.juegogameplay.Menu.Consola;

public class Gigante extends Jugables {

    private boolean disponible = false;
    private int vida = 150;
    private int daño = 100;
    private int movimientoMax = 1;

    public Gigante() {
        super.caracter = "G";
        super.caracterImpreso = (purple + caracter + reset);
        super.disponible = disponible;
        super.movimientoMax = movimientoMax;
        super.personaje = "Gigante";
        super.vida = vida;
        super.daño = daño;
        super.tipoMovimiento = "Tierra, un cuadro por turno";
        super.tipoAtaque = "Golpea con su brazo, lo que le hace daño a todos los enemigos/obstáculos en una línea en un rango de 3 cuadros";
    }

    // Modificación para el tipo de ataque
    @Override
    public Enemigos[] ataquePersonaje(String[][] tablero, Enemigos[] enemigos) {
        boolean coordenadaCorrecta = true;

        do {
            coordenadaCorrecta = true;

            // Solicitud de coordenadas de ataque
            System.out.println("Ingrese la dirección que desea atacar usando AWSD");
            String opcion = Consola.readString("Dirección para atacar");
            opcion = opcion.toUpperCase();
            switch (opcion) {
                case "A":
                    for (int pcolumna = ycolumna; pcolumna >= (ycolumna - 3); pcolumna--) {
                        if (tablero[xfila][pcolumna].equals("| " + green + "T" + reset + " |")) {
                            tablero[xfila][pcolumna] = ("| " + reset + "_" + reset + " |");
                        } else {
                            // Verificación de coordenada válida
                            if (ataqueValido(tablero, xfila, pcolumna)) {
                                // Entonces realiza el ataque
                                int obj = 0;
                                for (int i = 0; i < enemigos.length; i++) {
                                    if (enemigos[i].getXfila() == xfila && enemigos[i].getYcolumna() == pcolumna) {
                                        obj = i;
                                    }
                                }
                                enemigos[obj].setVida(enemigos[obj].getVida() - daño);
                            } else {
                                // Coordenada incorrecta y continua
                            }
                        }

                    }
                    break;
                case "W":
                    for (int pfila = xfila; pfila >= (xfila - 3); pfila--) {
                        if (tablero[pfila][ycolumna].equals("| " + green + "T" + reset + " |")) {
                            tablero[pfila][ycolumna] = ("| " + reset + "_" + reset + " |");
                        } else {
                            // Verificación de coordenada válida
                            if (ataqueValido(tablero, pfila, ycolumna)) {
                                // Entonces realiza el ataque
                                int obj = 0;
                                for (int i = 0; i < enemigos.length; i++) {
                                    if (enemigos[i].getXfila() == pfila && enemigos[i].getYcolumna() == ycolumna) {
                                        obj = i;
                                    }
                                }
                                enemigos[obj].setVida(enemigos[obj].getVida() - daño);
                            } else {
                                // Coordenada incorrecta y continua
                            }
                        }

                    }
                    break;
                case "S":
                    for (int pfila = xfila; pfila <= (xfila + 3); pfila++) {
                        if (tablero[pfila][ycolumna].equals("| " + green + "T" + reset + " |")) {
                            tablero[pfila][ycolumna] = ("| " + reset + "_" + reset + " |");
                        } else {
                            // Verificación de coordenada válida
                            if (ataqueValido(tablero, pfila, ycolumna)) {
                                // Entonces realiza el ataque
                                int obj = 0;
                                for (int i = 0; i < enemigos.length; i++) {
                                    if (enemigos[i].getXfila() == pfila && enemigos[i].getYcolumna() == ycolumna) {
                                        obj = i;
                                    }
                                }
                                enemigos[obj].setVida(enemigos[obj].getVida() - daño);
                            } else {
                                // Coordenada incorrecta y continua
                            }
                        }

                    }
                    break;
                case "D":
                    for (int pcolumna = ycolumna; pcolumna <= (ycolumna + 3); pcolumna++) {
                        if (tablero[xfila][pcolumna].equals("| " + green + "T" + reset + " |")) {
                            tablero[xfila][pcolumna] = ("| " + reset + "_" + reset + " |");
                        } else {
                            // Verificación de coordenada válida
                            if (ataqueValido(tablero, xfila, pcolumna)) {
                                // Entonces realiza el ataque
                                int obj = 0;
                                for (int i = 0; i < enemigos.length; i++) {
                                    if (enemigos[i].getXfila() == xfila && enemigos[i].getYcolumna() == pcolumna) {
                                        obj = i;
                                    }
                                }
                                enemigos[obj].setVida(enemigos[obj].getVida() - daño);
                            } else {
                                // Coordenada incorrecta y continua
                                if (pcolumna == 1) {
                                    System.out.println("Ataque fallido");
                                }
                            }
                        }

                    }
                    break;
                default:
                    coordenadaCorrecta = false;
                    break;
            }
        } while (!coordenadaCorrecta);
        return enemigos;
    }
}
