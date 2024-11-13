package utilidades;

import java.util.Scanner;

public class Utilidades {
    static Scanner teclado = new Scanner(System.in);

    public static int tomarOpcion(){
        int opcion = 0;
        boolean valido = false;
        while(!valido){
            System.out.print("Ingrese una opcion dependiendo del numero: ");
            if (teclado.hasNextInt()){
                opcion = teclado.nextInt();
                valido = true;
            } else {
                System.out.println("No has ingresado un numero correcto. Intente nuevamente");
                teclado.next();
            }
        }
        return opcion;
    }
    public static void salir(){
        System.out.println("Que tenga buen dia.");
        System.exit(0);
    }
}
