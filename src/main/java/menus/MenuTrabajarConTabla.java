package menus;
import conexion.ConexionTabla;
import utilidades.Utilidades;

import java.util.*;

public class MenuTrabajarConTabla{
    static int opcion = 0;
    public static void correrMenu(String baseSeleccionada){
        do {
            System.out.println("++++++++++++++++++++++++++++++++++");
            menuTabla();
            opcion = Utilidades.tomarOpcion();
            switch (opcion){
                case 1:
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    ConexionTabla.crearTabla(baseSeleccionada);
                    break;
                case 2:
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    ConexionTabla.listarTabla(baseSeleccionada);
                    break;
                case 3:
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    ConexionTabla.eliminarTabla(baseSeleccionada);
                    break;
                case 4:
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    ConexionTabla.modificarTabla(baseSeleccionada);
                    break;
                case 5:
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    MenuTrabajarConBase.correrMenu(baseSeleccionada);
                    break;

            }
        } while (opcion != 6);
        Utilidades.salir();
    }

    public static void menuTabla(){
        System.out.println("*** Trabajar con tablas ***");
        System.out.println("1 - Crear Tabla");
        System.out.println("2 - Listar tablas");
        System.out.println("3 - Eliminar tabla");
        System.out.println("4 - Modificar tabla");
        System.out.println("5 - Volver atras");
        System.out.println("6 - Salir");
    }

}
