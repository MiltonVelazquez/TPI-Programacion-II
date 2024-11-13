package menus;

import conexion.ConexionDato;
import utilidades.Utilidades;

import java.util.Scanner;

public class MenuTrabajarConDato {
    public static void menuPrincipal(){
        System.out.println("****** Menu de Datos ******");
        System.out.println("1 - Crear datos");
        System.out.println("2 - Listar datos");
        System.out.println("3 - Actualizar datos");
        System.out.println("4 - Eliminar datos");
        System.out.println("5 - Volver atras");
        System.out.println("6 - Salir");
    }
    public static void correrMenu(String baseSeleccionada){
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("++++++++++++++++++++++++++++++++++");
            menuPrincipal();
            opcion = Utilidades.tomarOpcion();
            switch(opcion){
                case 1:
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    ConexionDato.crearDato(baseSeleccionada);
                    break;
                case 2:
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    ConexionDato.listarDatos(baseSeleccionada);
                    break;
                case 3:
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    ConexionDato.actualizarDato(baseSeleccionada);
                    break;
                case 4:
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    ConexionDato.eliminarDato(baseSeleccionada);
                    break;
                case 5:
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    MenuTrabajarConBase.correrMenu(baseSeleccionada);
                    break;
            }
        } while (opcion != 6);
        Utilidades.salir();
    }
}
