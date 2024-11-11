package menus;
import conexion.ConexionTabla;
import utilidades.Utilidades;

import java.util.*;

public class MenuTrabajarConTabla{
    static int opcion = 0;
    public static void opciones(String baseSeleccionada){
        do {
            menuTabla();
            opcion = Utilidades.tomarOpcion();
            switch (opcion){
                case 1:
                    ConexionTabla.crearTabla(baseSeleccionada);
                    break;
                case 2:
                    ConexionTabla.listarTabla(baseSeleccionada);
                    break;
                case 3:
                    ConexionTabla.eliminarTabla(baseSeleccionada);
                    break;
                case 4:
                    ConexionTabla.modificarTabla(baseSeleccionada);
                    break;
                case 5:
                    MenuTrabajarConBase.opciones(baseSeleccionada);
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
