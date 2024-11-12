package conexion;

import menus.Main;
import menus.MenuTrabajarConCampo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConexionBases {
    public static void crearBaseDatos(String baseDatos){

        try (Connection conn = DriverManager.getConnection(Conexion.url, Conexion.usuario, Conexion.contra); Statement stmt = conn.createStatement()){
            String sql = "CREATE DATABASE " + baseDatos;
            stmt.executeUpdate(sql);
            System.out.println("Base de datos " + baseDatos + " creada con exito");
        } catch (SQLException e){
            System.out.println("Se ha producido un error: " + e.toString());
            Main.correrMenu();
        }
    }
    public static void conectarBaseDatos(String baseDatos){
        Connection conexion = null;
        try(Connection conn = DriverManager.getConnection(Conexion.url + baseDatos, Conexion.usuario, Conexion.contra)){
            if (conn != null){
                System.out.println("Conexion exitosa");
            } else {
                System.out.println("Fallo en la conexion");
            }
        } catch(SQLException e){
            System.out.println("Error al conectarse a la base de datos: " + e.toString());
            Main.correrMenu();
        }
    }
    public static List<String> listarBases(){
        List<String> basesDatos = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(Conexion.url, Conexion.usuario, Conexion.contra); Statement stmt = conn.createStatement()){
            String sql = "SELECT schema_name FROM information_schema.schemata WHERE schema_name NOT IN ('mysql', 'information_schema', 'performance_schema', 'phpmyadmin', 'test')";
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("Bases de datos del usuario: ");
            while (rs.next()){
                basesDatos.add((rs.getString("schema_name")));
            }
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            Main.correrMenu();
        }
        return basesDatos;
    }
    public static void borrarBaseDatos(String nombre){
        try (Connection conn = DriverManager.getConnection(Conexion.url, Conexion.usuario, Conexion.contra); Statement stmt = conn.createStatement()){
            System.out.println("DROP DATABASE " + nombre);
            String sql = "DROP DATABASE " + nombre;
            stmt.executeUpdate(sql);
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            Main.correrMenu();
        }
    }
}
