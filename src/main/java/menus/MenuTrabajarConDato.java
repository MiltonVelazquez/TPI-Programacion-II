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
            menuPrincipal();
            opcion = Utilidades.tomarOpcion();
            switch(opcion){
                case 1:
                    ConexionDato.crearDato(baseSeleccionada);
                    break;
                case 2:
                    ConexionDato.listarDatos(baseSeleccionada);
                    break;
                case 3:
                    ConexionDato.actualizarDato(baseSeleccionada);
                    break;
                case 4:
                    ConexionDato.eliminarDato(baseSeleccionada);
                    break;
                case 5:
                    MenuTrabajarConBase.correrMenu(baseSeleccionada);
                    break;
            }
        } while (opcion != 6);
        Utilidades.salir();
    }
}
