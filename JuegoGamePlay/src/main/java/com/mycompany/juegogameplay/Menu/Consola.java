package com.mycompany.juegogameplay.Menu;

import java.util.Scanner;

public class Consola {
    private static Scanner scanner = new Scanner(System.in);
    
    //static Moneda moneda;

    //Método para leer la respuesta del usuario a tipo String
    public static String readString(String message) {
        String response;
        System.out.print(message + " ");
        response = scanner.nextLine();
        return response;
    }

    //Método para leer la respuesta del usuario a tipo Int
    public static int readInt(String message) {
        int response = 0;
        boolean error = false;
        do{
            error = false;

            String texto = readString(message);
            if (texto.equals("")) {
                error = true;
            } else{
                for (int i = 0; i < texto.length(); i++) {
                    char caracter = texto.charAt(i);
                    if (!Character.isDigit(caracter)) {
                        error = true;
                    }
                }
            }
            
            if(error){
                Consola.Invalido();
            } else{
                response = Integer.parseInt(texto);
            }
        } while (error);
        return response;
    }

    //Método para mostrar un valor inválido
    public static void Invalido(){
        System.out.println("Valor ingresado inválido, intente de nuevo");
    }

    //Método para imprimir títulos
    public static void Titulo(String message){
        System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        System.out.println("    " + message.toUpperCase());
        System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
    }

    //Método para que continue al presionar una tecla
    public static void EnterContinuar(){
        readString("Enter para continuar");
    }

    public static void LimpiarPantalla(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static int numeroAleatorio(int mayor, int menor){
        int numeroAleatorio = (int) Math.floor(Math.random()*(mayor-menor+1)+menor);
        return numeroAleatorio;
    }
}
