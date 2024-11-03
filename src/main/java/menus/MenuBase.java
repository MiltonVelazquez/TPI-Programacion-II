package menus;

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
}
