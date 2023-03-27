package com.tictactoeapp.jugador;

import com.tictactoeapp.Consola;

public class AdminJugadores {

  private Jugador[] jugadores = new Jugador[5];

  public AdminJugadores() {
    System.out.println("creando admin jugadores");
  }

  public void menu() {
    int opcionMenu = 0;
    do {
      Consola.limpiarPantalla();
      Consola.printTitle("Administración de jugadores");
      Consola.printLine("1) Listar jugadores");
      Consola.printLine("2) Agregar jugador");
      Consola.printLine("3) salir");
      opcionMenu = Consola.readInt("Ingrese la opción seleccionada");
      if (opcionMenu == 1) {
        listarJugadores();
      }
      if (opcionMenu == 2) {
        agregarJugador();
      }
      if (opcionMenu < 1 && opcionMenu > 3) {
        Consola.printLine("seleccione una opción valida");
      }
    } while (opcionMenu != 3);
    Consola.printLine("terminando menu");
  }

  public void listarJugadores(){
    Consola.limpiarPantalla();
    Consola.printTitle("Listando jugadores");
    int contadorJugadores = 0;
    for (int i = 0; i < jugadores.length; i++) {
      if (jugadores[i]!=null){
        Consola.printLine(jugadores[i].toString());
        contadorJugadores++;
      }
    }
    if (contadorJugadores==0){
      Consola.printLine("No hay jugadores registrados");
    }
    Consola.enterContinuar();
  }

  public void agregarJugador(){
    Consola.limpiarPantalla();
    Consola.printTitle("Agregando Jugador");
    int posJugador = -1;
    for (int i = 0; i < jugadores.length; i++) {
        if (jugadores[i]== null){
          posJugador = i;
          break;
        }
    }
    if (posJugador < 0){
      posJugador = jugadores.length -1;
    }
    int tipoJugador = getTipoDeJugador();
    String nombreJugador = Consola.readString("Ingrese el nombre del jugador");
    if (tipoJugador ==1){
      jugadores[posJugador] = new Humano(nombreJugador);
    }
    else{
      if(tipoJugador == 2){
        jugadores[posJugador] = new Computadora(nombreJugador);
      }
      else{
        jugadores[posJugador] = new Mujer(nombreJugador);
      }
    }
    Consola.printLine("Jugador creado");
    Consola.enterContinuar();

  }

  /*
   * 1 = Humano
   * 2 = Computadora
   */
  public int getTipoDeJugador(){
    int tipoJugador = 0;
    do {
      Consola.printTitle("Seleccione el tipo de jugador");
      Consola.printLine("1) Humano");
      Consola.printLine("2) Computadora");
      Consola.printLine("3) Mujer");
      tipoJugador = Consola.readInt("Seleccione el tipo de jugador");
    } while (tipoJugador<1 || tipoJugador>3);
    return tipoJugador;
  }

public int dimeCuantosJugadoresHay() {
  int cantidad = 0;
    for (Jugador jugador : jugadores) {
      if (jugador == null){
        break;
      }
      cantidad++;
    }
    return cantidad;
}

public Jugador[] seleccionarDosJugadores() {
    return null;
}
}
