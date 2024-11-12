package menus;

import conexion.ConexionBases;
import utilidades.Utilidades;

import java.util.List;
import java.util.Scanner;

public class MenuSeleccionBases {
    private static final List<String> basesDatos = ConexionBases.listarBases();
    private static final Scanner teclado = new Scanner(System.in);

    public static void correrMenu() {
        int opcion;
        do {
            menuBases();
            System.out.print("Ingrese una opcion o con que base desea trabajar: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            if (opcion > 0 && opcion <= basesDatos.size()){
                String baseSeleccionada = basesDatos.get(opcion - 1);
                System.out.println("Seleccionaste: " + baseSeleccionada);
                ConexionBases.conectarBaseDatos(baseSeleccionada);
                MenuTrabajarConBase.correrMenu(baseSeleccionada);

            } else if (opcion == basesDatos.size() + 1) {
                return;
            } else {
                System.out.println("Esa base de datos no existe.");
            }
        } while (opcion != basesDatos.size() + 2);
        Utilidades.salir();
    }

    public static void menuBases() {
        for (int i = 0; i < basesDatos.size(); i++) {
            System.out.println((i + 1) + " - " + basesDatos.get(i));
        }
        System.out.println((basesDatos.size() + 1) + " - Volver al menu principal");
        System.out.println((basesDatos.size() + 2) + " - Salir");
    }
}
