package com.mycompany.juegogameplay.Menu;

public class Tablero {

    public Tablero(){
        System.out.println("Creando Tablero");
    }

    // Colores
    String black = "\033[30m";
    String red = "\033[31m";
    String green = "\033[32m";
    String yellow = "\033[33m";
    String blue = "\033[34m";
    String purple = "\033[35m";
    String cyan = "\033[36m";
    String white = "\033[37m";
    String reset = "\u001B[0m";

    //Tipos de casillas
    private String planicie = "_";
    private String planicieImpreso = reset+planicie+reset;
    private String arbol = "T";
    private String arbolImpreso = green+arbol+reset;
    private String agua = "~";
    private String aguaImpreso = blue+agua+reset;
    private String lava = "$";
    private String lavaImpreso = yellow+lava+reset;

    //Valores para el tablero
    private int alto;
    public int getAlto() {
        return alto;
    }

    private int[] porcentajes;

    private String[][] tableroBatalla;

    public String[][] getTableroBatalla() {
        return tableroBatalla;
    }

    public void setTableroBatalla(String[][] tableroBatalla) {
        this.tableroBatalla = tableroBatalla;
    }

    public void IniciarTablero (){
        // Seleccion del mapa
        int opcion = 0;
        porcentajes = new int[4];
        do {
            Consola.LimpiarPantalla();
            Consola.Titulo("Tableros");
            System.out.println("1| Mapa 8x8");
            System.out.println("2| Personalizado");
            opcion = Consola.readInt("Seleccione un mapa");
            // Ya elegido el mapa, se crea mapa
            //Valores predeterminados para los porcentajes
            porcentajes[3] = 60;
            porcentajes[0] = 25;
            porcentajes[1] = 10;
            porcentajes[2] = 5;

            if (opcion == 1) {
                alto = 8;
                construccionTablero();
            } else if (opcion == 2) {
                boolean porcentajeCorrecto = true;
                do {
                    alto = Consola.readInt("Ingrese el alto que desea para el tablero");
                    porcentajes[3] = Consola.readInt("Ingrese el porcentaje para las casillas planicie");
                    porcentajes[0] = Consola.readInt("Ingrese el porcentaje para las casillas árbol");
                    porcentajes[1] = Consola.readInt("Ingrese el porcentaje para las casillas agua");
                    porcentajes[2] = Consola.readInt("Ingrese el porcentaje para las casillas lava");
                    porcentajeCorrecto = true;
                    if ((porcentajes[0] + porcentajes[1] + porcentajes[2] + porcentajes[3]) != 100){
                        System.out.println("Asegurate de que los porcentajes sumen 100");
                        porcentajeCorrecto = false;
                    }
                } while (!porcentajeCorrecto);
                construccionTablero();
            }
        } while (opcion != 1 && opcion != 2);
    }

    public void construccionTablero(){
        //Le asignamos valores iniciales al tablero
        //Se le suma una casilla más para las coordenadas, de esta manera si es 8*8, dará uno de 9*9 para los espacios de las coordenadas
        tableroBatalla = new String[alto+1][alto+1];
        for (int fila = 0; fila < tableroBatalla.length; fila++) {
            for (int columna = 0; columna < tableroBatalla.length; columna++) {
                if (fila == 0) {
                    if (columna > 0) {
                        //tableroBatalla[fila][columna] = String.valueOf("| "+columna+" |");
                        tableroBatalla[fila][columna] = ("| "+columna+(columna<10? " |":"|"));
                    } else {
                        tableroBatalla[fila][columna] = "|   |";
                    }
                } else {
                    tableroBatalla[fila][columna] = "|   |";
                }
            }
            if (fila != 0){
                //Si tiene más de 1 dígito elimina un espacio para que el tablero sea homogeneo
                tableroBatalla[fila][0] = ("| "+fila+(fila<10? " |":"|"));
            }
        }        

        imprimirTablero();
    }

    public void casillasAleatorias() {
        // Ya con el tablero construído, procedemos a asignar los tipos de casillas
        int cantidadCasillas;
        int contCasillas = 0;
        String caracter;
        boolean terminado = false;

        // Creación de todas las casillas
        //Dejamos la probabilidad de casillas planicie al final, ya que es la que terminará de llenar el tablero
        for (int i = 0; i < 4; i++) {
            // Obtenemos cúantas casillas se deben crear, además se divide dentro de 100 el
            // porcentaje, para obtener un decimal
            cantidadCasillas = (int) Math.floor(alto * alto * (this.porcentajes[i] / 100.0));
            // Se hace un ciclo para la creación de los tipos de casilla, el cual se repite
            // si en dado caso no se llega a la cantidad deseada
            caracter = switch (i) {
                case 3 -> planicieImpreso;
                case 0 -> arbolImpreso;
                case 1 -> aguaImpreso;
                case 2 -> lavaImpreso;
                default -> planicieImpreso;
            };
            //Reiniciamos el contador y el verificador
            contCasillas = 0;
            terminado = false;
            do {
                for (int fila = 1; fila < tableroBatalla.length; fila++) {
                    for (int columna = 1; columna < tableroBatalla.length; columna++) {
                        // Si es 1, modifica, si es 0, no
                        int modificar = Consola.numeroAleatorio(5, 0);
                        //Si el espacio está vacío, se modificará
                        if (tableroBatalla[fila][columna] == "|   |") {
                            //Dejamos la planicie al final, ya que con los otros caracteres cumplidos, este solo tiene la función de llenado
                            if (caracter == planicieImpreso) {
                                tableroBatalla[fila][columna] = "| " + caracter + " |";
                                terminado = true;
                            } else if (contCasillas == cantidadCasillas) {
                                // Si ya se tiene la cantidad necesaria de casillas se rompe el ciclo
                                terminado = true;
                                break;
                            } else if (modificar == 0) {
                                if(caracter != aguaImpreso){
                                    tableroBatalla[fila][columna] = "| " + caracter + " |";
                                    contCasillas = contCasillas + 1;
                                } else{
                                    if (columna == 1 || columna == (tableroBatalla.length-1) || tableroBatalla[fila][columna-1] == aguaImpreso || tableroBatalla[fila][columna+1] == aguaImpreso) {
                                        tableroBatalla[fila][columna] = "| " + caracter + " |";
                                        contCasillas = contCasillas + 1;
                                    }
                                }  
                            }
                        }
                    }
                }
            } while (!terminado);

        }
    }

    public void edicionTablero(int x, int y, String caracter){
        tableroBatalla[x][y] = "| "+caracter+" |";
    }

    public void imprimirTablero() {
        //Se imprime cada valor del tablero en pantalla
        for (int i = 0; i < tableroBatalla.length; i++) {
            for (int j = 0; j < tableroBatalla.length; j++) {
                System.out.print(tableroBatalla[i][j]);
            }
            System.out.println();
        }
        Consola.EnterContinuar();
    }
}

