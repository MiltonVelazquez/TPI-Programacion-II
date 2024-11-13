package menus;

import conexion.ConexionColumna;
import utilidades.Utilidades;

public class MenuTrabajarConCampo {
    static int opcion = 0;
    public static void correrMenu(String baseSeleccionada){
        do {
            System.out.println("++++++++++++++++++++++++++++++++++");
            menu();
            opcion = Utilidades.tomarOpcion();
            switch (opcion) {
                case 1:
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    ConexionColumna.crearColumna(baseSeleccionada);
                    break;
                case 2:
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    ConexionColumna.listarColumna(baseSeleccionada);
                    break;
                case 3:
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    ConexionColumna.modificarColumna(baseSeleccionada);
                    break;
                case 4:
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    ConexionColumna.eliminarColumna(baseSeleccionada);
                    break;
                case 5:
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    MenuTrabajarConBase.correrMenu(baseSeleccionada);
                    break;
            }
        } while (opcion != 6);
        Utilidades.salir();

    }
    public static void menu(){
        System.out.println("*** Trabajar con Campos ***");
        System.out.println("1 - Crear campo");
        System.out.println("2 - Listar campos");
        System.out.println("3 - Modificar campo");
        System.out.println("4 - Eliminar campo");
        System.out.println("5 - Volver atras");
        System.out.println("6 - Salir");
    }
}
