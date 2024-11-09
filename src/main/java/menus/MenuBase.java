package menus;

import conexion.ConexionTabla;

import java.util.Scanner;

public class MenuBase {
    public static void main(String[] args){
        opciones();
    }

    public static void opciones(){
        Scanner teclado = new Scanner(System.in);
        int opcion;
        do {
            menuBase();
            System.out.print("Ingrese una opcion dependiendo del numero: ");
            opcion = teclado.nextInt();

        } while (opcion != 5);
    }
    public static void menuBase(){
        System.out.println("****** Trabajar con una base de datos ******");
        System.out.println("1 - Trabajar con tablas.");
        System.out.println("2 - Trabajar con columnas.");
        System.out.println("3 - Trabajar con datos.");
        System.out.println("4 - Volver atras.");
        System.out.println("5 - Salir.");
    }

    public static void opcion(){
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        do {
            menuBase();
            System.out.print("Ingrese una opcion dependiendo del numero: ");
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion){
                case 1:
                    ConexionTabla.crearTabla();
                    break;
                case 2:
                    //MenuColumnas.opcion();
                    System.out.println("Menu columnas");
                    break;
                case 3:
                    //MenuDatos.opcion();
                    System.out.println("Menu datos");
                    break;
                case 4:
                    MenuBases.opciones();
                    break;

            }
        } while(opcion != 5);
        System.out.println("Que tenga buen dia.");
        System.exit(0);
    }
}
