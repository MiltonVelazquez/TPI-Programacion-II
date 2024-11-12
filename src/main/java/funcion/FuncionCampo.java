package funcion;

import conexion.ConexionTabla;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class FuncionCampo {
    static Scanner teclado = new Scanner(System.in);
    public static String crearCampo(){
        return FuncionTabla.opcionCampo();
    }
    public static String saberTabla(String baseSeleccionada){
        ConexionTabla.listarTabla(baseSeleccionada);
        System.out.print("Ingrese el nombre de la tabla con la que desea trabajar: ");
        String saberColumnas = teclado.nextLine();
        return saberColumnas;
    }

}
