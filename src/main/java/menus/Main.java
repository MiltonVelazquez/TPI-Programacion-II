package menus;

import conexion.Conexion;
import conexion.ConexionBases;
import utilidades.Utilidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        correrMenu();
    }
    public static void menuPrincipal(){

        System.out.println("****** Menu de Base de Datos ******");
        System.out.println("1 - Crear base de datos");
        System.out.println("2 - Eliminar base de datos");
        System.out.println("3 - Listar bases de datos");
        System.out.println("4 - Salir");
    }

    public static void correrMenu(){
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("++++++++++++++++++++++++++++++++++");
            menuPrincipal();
            opcion = Utilidades.tomarOpcion();
            switch(opcion){
                case 1:
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    System.out.print("Ingrese el nombre de la base de datos a crear: ");
                    String nombreA = teclado.nextLine();
                    ConexionBases.crearBaseDatos(nombreA);
                    break;
                case 2:
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    ConexionBases.borrarBaseDatos();
                    break;
                case 3:
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    MenuSeleccionBases.correrMenu();
                    break;
                default:
                    if (opcion != 4) {
                        System.out.println("Ese numero no existe");
                    }
            }
        } while(opcion != 4);
        Utilidades.salir();
    }
}

