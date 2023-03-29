package com.mycompany.juegogameplay.Personajes;

import com.mycompany.juegogameplay.Menu.Consola;

public class Mago extends Jugables {

    private boolean disponible = false;
    private int vida = 100;
    private int daño = 60;
    private int movimientoMax = 2;

    public Mago() {
        super.caracter = "M";
        super.caracterImpreso = (purple + caracter + reset);
        super.disponible = disponible;
        super.movimientoMax = movimientoMax;
        super.personaje = "Mago";
        super.vida = vida;
        super.daño = daño;
        super.tipoMovimiento = "Vuela, hasta tres cuadros por turno";
        super.tipoAtaque = "Dispara un hechizo hacía el final de una línea que impacta en el primer enemigo/obstáculo que se encuentre";
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
            int opcion = 0;
            do {
                if (moverContador < movimientoMax) {
                    opcion = Consola.readInt(
                            "¿Desea moverse +1 casillas de " + moverContador + " movidas?  1| Sí   2| No");
                    if (opcion == 1) {
                        moverContador = moverContador + 1;
                    } else if (opcion == 2) {
                        movimientoTerminado = true;
                    }
                } else {
                    movimientoTerminado = true;
                }
            } while (opcion != 1 && opcion != 2 && !movimientoTerminado);
        } else {
            movimientoValido = false;
            if (moverContador > 1) {
                movimientoTerminado = true;
            }
        }
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
                    for (int pcolumna = ycolumna; pcolumna > 0; pcolumna--) {
                        // Verificación de coordenada válida
                        if (ataqueValido(tablero, xfila, pcolumna)) {
                            if (tablero[xfila][pcolumna].equals("| " + green + "T" + reset + " |")) {
                                tablero[xfila][pcolumna] = ("| " + reset + "_" + reset + " |");
                                break;
                            } else {
                                // Entonces realiza el ataque
                                int obj = 0;
                                for (int i = 0; i < enemigos.length; i++) {
                                    if (enemigos[i].getXfila() == xfila && enemigos[i].getYcolumna() == pcolumna) {
                                        obj = i;
                                    }
                                }
                                enemigos[obj].setVida(enemigos[obj].getVida() - daño);
                                break;
                            }

                        } else {
                            // Coordenada incorrecta y continua
                            if (pcolumna == 1) {
                                System.out.println("Ataque fallido");
                            }
                        }
                    }
                    break;
                case "W":
                    for (int pfila = xfila; pfila > 0; pfila--) {
                        if (tablero[pfila][ycolumna].equals("| " + green + "T" + reset + " |")) {
                            tablero[pfila][ycolumna] = ("| " + reset + "_" + reset + " |");
                            break;
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
                                break;
                            } else {
                                // Coordenada incorrecta y continua
                                if (ycolumna == 1) {
                                    System.out.println("Ataque fallido");
                                }
                            }
                        }
                    }
                    break;
                case "S":
                    for (int pfila = xfila; pfila < tablero.length; pfila++) {
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
                                break;

                            } else {
                                // Coordenada incorrecta y continua
                                if (ycolumna == 1) {
                                    System.out.println("Ataque fallido");
                                }
                            }
                        }
                    }
                    break;
                case "D":
                    for (int pcolumna = ycolumna; pcolumna < tablero.length; pcolumna++) {
                        if (tablero[xfila][pcolumna].equals("| " + green + "T" + reset + " |")) {
                            tablero[xfila][pcolumna] = ("| " + reset + "_" + reset + " |");
                        } else {

                        }
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
                            break;
                        } else {
                            // Coordenada incorrecta y continua
                            if (pcolumna == 1) {
                                System.out.println("Ataque fallido");
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
