package menus;

import conexion.Conexion;
import conexion.ConexionBases;

import java.util.List;
import java.util.Scanner;

public class MenuBases {
    static List<String> basesDatos = ConexionBases.listarBases();
    /*public static void main(String[] args){
        opciones();
    }*/
    public static void opciones(){
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        do {
            menuBases();
            System.out.print("Ingrese una opcion o con que base desea trabajar: ");
            opcion = teclado.nextInt();
            teclado.nextLine();
            if (opcion > 0 && opcion <= basesDatos.size()){
                String baseSeleccionada = basesDatos.get(opcion - 1);
                System.out.println("Seleccionaste: " + baseSeleccionada);
                ConexionBases.conectarBaseDatos(baseSeleccionada);
                MenuBase.opcion();
            } else if (opcion == (basesDatos.size() + 1)) {
                MenuUno.opciones();
            } else {
                System.out.println("Esa base de datos no existe.");
            }


        } while (opcion != basesDatos.size() + 2);
        System.out.println("Que tenga buen dia.");
        System.exit(0);
    }
    public static void menuBases(){
        for (int i = 0; i < basesDatos.size(); i++) {
            System.out.println((i + 1) + " - " + basesDatos.get(i));
        }
        System.out.println((basesDatos.size() + 1) + " - Volver al menu principal");
    }
}
