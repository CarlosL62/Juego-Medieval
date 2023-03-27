package com.tictactoeapp;

import java.util.Scanner;

public class Consola {
    private static Scanner scanner = new Scanner(System.in);

    public static String readString(String message){
        String response;
        System.out.print(message+ " ");
        response = scanner.nextLine();
        return response;
    }

    public static int readInt(String message){
        int response=0;
        boolean error = false;

        do {
            try {
                response = Integer.parseInt(readString(message));
                error = false;
            } catch (Exception e) {
                error = true;
            }
        } while (error);

        return response;
    }

    public static void printTitle(String message){
        System.out.println("      "+message.toUpperCase());
        System.out.println("##############################################\n");
    }

    public static void printLine(String message){
        System.out.println(message);
    }

    public static void printWhiteLine(){
        System.out.println();
    }

    public static void enterContinuar(){
        readString("Enter para continuar . . . ");
    }

    public static void limpiarPantalla(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
    }
}
