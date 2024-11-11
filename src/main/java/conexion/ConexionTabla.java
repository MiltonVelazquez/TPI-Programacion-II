package conexion;

import funcion.FuncionTabla;
import menus.MenuTrabajarConTabla;
import java.sql.*;
import java.util.*;

public class ConexionTabla {
    static Scanner teclado = new Scanner(System.in);

    public static void crearTabla(String baseSeleccionada) {
        System.out.print("Ingrese el nombre de la tabla a crear: ");
        String nombre = teclado.nextLine();
        try (Connection conn = DriverManager.getConnection(Conexion.url + baseSeleccionada, Conexion.usuario, Conexion.contra); Statement stmt = conn.createStatement()) {
            String campos = FuncionTabla.crearCampo(baseSeleccionada);
            String sql = "CREATE TABLE " + nombre + " (`id` INT NOT NULL AUTO_INCREMENT, " + campos + ", PRIMARY KEY (`id`))";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            System.out.println("Tabla " + nombre + " creada con exito");


        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void listarTabla(String baseSeleccionada){
        try (Connection conn = DriverManager.getConnection(Conexion.url + baseSeleccionada, Conexion.usuario, Conexion.contra); Statement stmt = conn.createStatement()) {
            String sql = "SHOW TABLES";
            ResultSet resultado = stmt.executeQuery(sql);
            System.out.println("Tablas en la base de datos: ");
            while (resultado.next()) {
                System.out.println(resultado.getString(1));
            }
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void eliminarTabla(String baseSeleccionada) {
        try (Connection conn = DriverManager.getConnection(Conexion.url + baseSeleccionada, Conexion.usuario, Conexion.contra); Statement stmt = conn.createStatement()){
            System.out.print("Ingrese el nombre de la tabla a eliminar: ");
            String nombreE = teclado.nextLine();
            String sqlE = "DROP TABLE " + nombreE;
            stmt.executeUpdate(sqlE);
            System.out.println("Tabla " + nombreE + " eliminada con exito.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public static void modificarTabla(String baseSeleccionada) {
        try (Connection conn = DriverManager.getConnection(Conexion.url + baseSeleccionada, Conexion.usuario, Conexion.contra); Statement stmt = conn.createStatement()){
            System.out.print("Ingrese el nombre de la tabla a modificar: ");
            String nombreModificar = teclado.nextLine();
            System.out.print("Ingrese el nuevo nombre de la tabla: ");
            String nombreNuevo = teclado.nextLine();
            String sqlModificar = "ALTER TABLE " + nombreModificar + " RENAME TO " + nombreNuevo;
            stmt.executeUpdate(sqlModificar);
            System.out.println("El nombre de la tabla " + nombreModificar + " cambiado a " + nombreNuevo);
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

}
