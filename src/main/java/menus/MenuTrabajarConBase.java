package menus;

import conexion.ConexionTabla;
import utilidades.Utilidades;

import javax.rmi.CORBA.Util;
import java.util.Scanner;

public class MenuTrabajarConBase {
    private static final Scanner teclado = new Scanner(System.in);

    public static void correrMenu(String baseSeleccionada) {
        int opcion;
        do {
            System.out.println("++++++++++++++++++++++++++++++++++");
            menuBase();
            opcion = Utilidades.tomarOpcion();

            switch (opcion) {
                case 1:
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    MenuTrabajarConTabla.correrMenu(baseSeleccionada);
                    break;
                case 2:
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    MenuTrabajarConCampo.correrMenu(baseSeleccionada);
                    break;
                case 3:
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    MenuTrabajarConDato.correrMenu(baseSeleccionada);
                    break;
                case 4:
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    MenuSeleccionBases.correrMenu();
                    return;
            }
        } while (opcion != 5);
        Utilidades.salir();
    }

    public static void menuBase() {
        System.out.println("****** Trabajar con una base de datos ******");
        System.out.println("1 - Trabajar con tablas.");
        System.out.println("2 - Trabajar con columnas.");
        System.out.println("3 - Trabajar con datos.");
        System.out.println("4 - Volver atras.");
        System.out.println("5 - Salir.");
    }
}
