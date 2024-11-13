package funcion;

import conexion.ConexionColumna;
import conexion.ConexionTabla;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class FuncionCampo {
    static Scanner teclado = new Scanner(System.in);
    public static String crearCampo(){
        return FuncionTabla.opcionCampo();
    }
    public static String saberTabla(String baseSeleccionada){
        String nombreTabla = "";
        boolean tablaValida = false;
        List<String> tablas = ConexionTabla.listarTabla(baseSeleccionada);
        while(!tablaValida){
            System.out.print("Ingres el nombre de la tabla con la que desea trabajar: ");
            nombreTabla = teclado.nextLine();

            if(tablas.contains((nombreTabla))){
                tablaValida = true;
            } else {
                System.out.println("La tabla ingresada no existe");
            }

        }
        return nombreTabla;
    }


}
