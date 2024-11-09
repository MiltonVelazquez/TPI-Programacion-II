package conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import utilidades.credenciales;
import java.util.Scanner;

public class Conexion {
    public Conexion() throws SQLException {
    }

    public static void main(String[] args) {
        /*Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la DB: ");
        String baseDatos = teclado.nextLine();
        crearBaseDatos(baseDatos);
        conectarBaseDatos(baseDatos);
        listarBases();*/


    }

    static String carpeta = "desarrollo";
    static HashMap<String, String> listaVar = credenciales.getVarEnt(carpeta);
    static String url = listaVar.get("url");
    static String usuario = listaVar.get("usuario");
    static String contra = listaVar.get("contra");

}
