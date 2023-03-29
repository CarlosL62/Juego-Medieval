package com.mycompany.juegogameplay.Personajes;

import com.mycompany.juegogameplay.Menu.Consola;

public class Arquero extends Jugables {

    private boolean disponible = false;
    private int vida = 150;
    private int daño = 100;
    private int movimientoMax = 3;

    public Arquero() {
        super.caracter = "A";
        super.caracterImpreso = (purple + caracter + reset);
        super.disponible = disponible;
        super.movimientoMax = movimientoMax;
        super.personaje = "Arquero";
        super.vida = vida;
        super.daño = daño;
        super.tipoMovimiento = "Tierra, tres cuadros por turno";
        super.tipoAtaque = "Dispara una flecha a cualquier punto en un rango de tres casillas, en cualquiera de las líneas";
    }

    // Modificación para el tipo de ataque
    @Override
    public Enemigos[] ataquePersonaje(String[][] tablero, Enemigos[] enemigos) {
        boolean coordenadaCorrecta = true;

        do {
            coordenadaCorrecta = true;

            // Solicitud de coordenadas de ataque
            System.out.println("Ingrese la coordenada que desea atacar");
            int xAtaque = Consola.readInt("Ingrese la fila");
            int yAtaque = Consola.readInt("Ingrese la columna");

            if ((xAtaque == xfila || xAtaque == (xfila + 1) || xAtaque == (xfila + 2) || xAtaque == (xfila + 3)
                    || xAtaque == (xfila - 1)
                    || xAtaque == (xfila - 2) || xAtaque == (xfila - 3))
                    && (yAtaque == ycolumna || yAtaque == (ycolumna + 1) || yAtaque == (ycolumna + 2)
                            || yAtaque == (ycolumna + 3)
                            || yAtaque == (ycolumna - 1) || yAtaque == (ycolumna - 2) || yAtaque == (ycolumna - 3))) {
                // Verificación de coordenada válida
                if (ataqueValido(tablero, xAtaque, yAtaque)) {
                    if (tablero[xAtaque][yAtaque].equals("| " + green + "T" + reset + " |")) {
                        tablero[xAtaque][yAtaque] = ("| " + reset + "_" + reset + " |");
                    } else {
                        // Entonces realiza el ataque
                        int obj = 0;
                        for (int i = 0; i < enemigos.length; i++) {
                            if (enemigos[i].getXfila() == xAtaque && enemigos[i].getYcolumna() == yAtaque) {
                                obj = i;
                            }
                        }
                        enemigos[obj].setVida(enemigos[obj].getVida() - daño);
                    }

                } else {
                    // Coordenada incorrecta
                    System.out.println("Coordenada inválida");
                    coordenadaCorrecta = false;
                }
            } else {
                coordenadaCorrecta = false;
            }
        } while (!coordenadaCorrecta);
        return enemigos;
    }
}
