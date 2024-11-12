package conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import utilidades.credenciales;
import java.util.Scanner;

public class Conexion {

    static String carpeta = "desarrollo";
    static HashMap<String, String> listaVar = credenciales.getVarEnt(carpeta);
    static String url = listaVar.get("url");
    static String usuario = listaVar.get("usuario");
    static String contra = listaVar.get("contra");

}
