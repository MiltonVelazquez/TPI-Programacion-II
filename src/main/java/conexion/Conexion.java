package conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import utilidades.credenciales;
import java.util.Scanner;

public class Conexion {
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
    public static void crearBaseDatos(String baseDatos){
        try (Connection conn = DriverManager.getConnection(url, usuario, contra); Statement stmt = conn.createStatement()){
            String sql = "CREATE DATABASE " + baseDatos;
            stmt.executeUpdate(sql);
            System.out.println("Base de datos " + baseDatos + " creada con exito");
        } catch (SQLException e){
            System.out.println("Se ha producido un error: " + e.toString());
        }
    }

    public static void conectarBaseDatos(String baseDatos){
        Connection conexion = null;
        try(Connection conn = DriverManager.getConnection(url + baseDatos, usuario, contra)){
            if (conn != null){
                System.out.println("Conexion exitosa");
            } else {
                System.out.println("Fallo en la conexion");
            }
        } catch(SQLException e){
            System.out.println("Error al conectarse a la base de datos: " + e.toString());
        }
    }

    public static List<String> listarBases(){
        List<String> basesDatos = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, usuario, contra); Statement stmt = conn.createStatement()){
            String sql = "SELECT schema_name FROM information_schema.schemata WHERE schema_name NOT IN ('mysql', 'information_schema', 'performance_schema', 'phpmyadmin', 'test')";
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("Bases de datos del usuario: ");
            while (rs.next()){
                basesDatos.add((rs.getString("schema_name")));
            }
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return basesDatos;
    }

    public static void borrarBaseDatos(String nombre){
        try (Connection conn = DriverManager.getConnection(url, usuario, contra); Statement stmt = conn.createStatement()){
            System.out.println("DROP DATABASE " + nombre);
            String sql = "DROP DATABASE " + nombre;
            stmt.executeUpdate(sql);
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }


}
