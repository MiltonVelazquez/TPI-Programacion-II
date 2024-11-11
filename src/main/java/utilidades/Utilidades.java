package utilidades;

import java.util.Scanner;

public class Utilidades {
    static Scanner teclado = new Scanner(System.in);
    public static int tomarOpcion(){
        System.out.print("Ingrese una opcion dependiendo del numero: ");
        int opcion = teclado.nextInt();
        return opcion;
    }
    public static void salir(){
        System.out.println("Que tenga buen dia.");
        System.exit(0);
    }
}
