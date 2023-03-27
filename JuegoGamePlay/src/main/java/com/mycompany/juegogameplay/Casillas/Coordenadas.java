package com.mycompany.juegogameplay.Casillas;

public class Coordenadas extends Casillas{

    public Coordenadas(){
        super.caracter = "|   |";
    }

    private Casillas coordenadas;

    public Casillas obtenerCoordenadas(int fila, int columna){
        coordenadas = new Coordenadas();
        if (fila == 0) {
            if (columna > 0) {
                coordenadas.caracter = ("| "+columna+(columna<10? " |":"|"));
            } else {
                coordenadas.caracter = "|   |";
            }
        } else {
            if (columna == 0) {
                // Si tiene más de 1 dígito elimina un espacio para que el tablero sea homogeneo
                coordenadas.caracter = ("| " + fila + (fila < 10 ? " |" : "|"));
            }
        }
        return coordenadas;
    }
    
    public Casillas[][] crearCoordenadas(Casillas[][] tablero){
        for (int fila = 0; fila < tablero.length; fila ++) {
            for (int columna = 0; columna < 1; columna++) {
                tablero[fila][columna] = obtenerCoordenadas(fila, columna);
            }
        }
        return tablero;
    }
    
}
