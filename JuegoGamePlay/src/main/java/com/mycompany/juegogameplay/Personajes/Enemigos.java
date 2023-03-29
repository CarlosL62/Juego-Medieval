package com.mycompany.juegogameplay.Personajes;

import com.mycompany.juegogameplay.Menu.*;

public class Enemigos extends Personajes{

    @Override
    //Movimiento de los enemigos
    public String[][] movimientoPersonajes(String[][] tablero) {
        if (vivo()) {
            String movimientoTeclado = "";
            System.out.println(personaje + " en fila: " + xfila + " columna: " + ycolumna + " se está moviendo...");
            do {
                // Los movimientos serán aleatorios
                movimientoTeclado = switch (Consola.numeroAleatorio(4, 1)) {
                    case 1 -> "A";
                    case 2 -> "W";
                    case 3 -> "S";
                    case 4 -> "D";
                    default -> "A";
                };
                movimientoValido = true;
                movimientoTerminado = false;
                moverContador = 1;
                switch (movimientoTeclado) {
                    case "A":
                        do {
                            movimientoPersonajeValido(tablero, xfila, ycolumna - 1);
                        } while (moverContador <= movimientoMax && !movimientoTerminado && movimientoValido);
                        break;
                    case "W":
                        do {
                            movimientoPersonajeValido(tablero, xfila - 1, ycolumna);
                        } while (moverContador <= movimientoMax && !movimientoTerminado && movimientoValido);
                        break;
                    case "S":
                        do {
                            movimientoPersonajeValido(tablero, xfila + 1, ycolumna);
                        } while (moverContador <= movimientoMax && !movimientoTerminado && movimientoValido);
                        break;
                    case "D":
                        do {
                            movimientoPersonajeValido(tablero, xfila, ycolumna + 1);
                        } while (moverContador <= movimientoMax && !movimientoTerminado && movimientoValido);
                        break;
                    default:
                        movimientoValido = false;
                        break;
                }
                if (!movimientoValido) {
                    // Movimiento inváldio
                }
            } while (!movimientoTerminado);
            System.out.println(personaje + " se movilizó a fila: " + xfila + " columna: " + ycolumna);
        } else{
            //No hace nada porque ya está muerto
        }
        
        return tablero;
    }

    @Override
    public void movimientoPersonajeValido(String[][] tablero, int destinoX, int destinoY) {
        // Verificación que el movimiento sea válido, primero que este dentro del
        // tablero y que sea a una casilla válida
        if ((destinoX > 0 && destinoY > 0 && destinoX < tablero.length && destinoY < tablero.length) &&
            (tablero[destinoX][destinoY].equals("| " + reset + "_" + reset + " |") ||
            tablero[destinoX][destinoY].equals("| " + yellow + "$" + reset + " |"))) {

            // Realizamos el cambio de las casillas originales y movemos al personaje
            tablero[xfila][ycolumna] = casillaOriginal;
            xfila = destinoX;
            ycolumna = destinoY;
            casillaOriginal = tablero[xfila][ycolumna];
            tablero[xfila][ycolumna] = "| " + caracterImpreso + " |";

            //De forma aleatoria, el enemigo se moverá más o no
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

    public Jugables[] ataquePersonaje(String[][] tablero, Jugables[] personajesJugar){
        boolean coordenadaCorrecta = true;

        do {
            coordenadaCorrecta = true;

            // Valores aleatorios
            int xAtaque = Consola.numeroAleatorio(2, 1);
            int yAtaque = Consola.numeroAleatorio(2, 1);

            // Verificación de coordenada válida
            if (ataqueValido(tablero, xAtaque, yAtaque)) {
                if (tablero[xAtaque][yAtaque].equals("| " + green + "T" + reset + " |")) {
                    tablero[xAtaque][yAtaque] = ("| " + reset + "_" + reset + " |");
                } else {
                    // Entonces realiza el ataque
                    int obj = 0;
                    for (int i = 0; i < personajesJugar.length; i++) {
                        if (personajesJugar[i].getXfila() == xAtaque && personajesJugar[i].getYcolumna() == yAtaque) {
                            obj = i;
                        }
                    }
                    personajesJugar[obj].setVida(personajesJugar[obj].getVida() - daño);
                }
            } else {
                // Coordenada incorrecta
                System.out.println("Coordenada inválida");
                coordenadaCorrecta = false;
            } 
        } while (!coordenadaCorrecta);
        return personajesJugar;
    }

    public boolean ataqueValido(String[][] tablero, int xAtaque, int yAtaque){
        boolean ataqueValido = false;
        if ((xAtaque > 0 && yAtaque > 0 && xAtaque < tablero.length && yAtaque < tablero.length)
                && (tablero[xAtaque][yAtaque].equals("| " + purple + "C" + reset + " |")
                        || tablero[xAtaque][yAtaque].equals("| " + purple + "A" + reset + " |")
                        || tablero[xAtaque][yAtaque].equals("| " + purple + "M" + reset + " |")
                        || tablero[xAtaque][yAtaque].equals("| " + purple + "G" + reset + " |")
                        || tablero[xAtaque][yAtaque].equals("| " + purple + "D" + reset + " |")
                        || tablero[xAtaque][yAtaque].equals("| " + green + "T" + reset + " |"))) {
                            //Probabilidad de 60 % de acertar un golpe
                            if (Consola.numeroAleatorio(100, 1) <= 60) {
                                ataqueValido = true;
                                System.out.println(personaje + " atacando");
                            } else {
                                System.out.println(personaje + " falló el golpe");
                            }
        }
        return ataqueValido;
    }
}
