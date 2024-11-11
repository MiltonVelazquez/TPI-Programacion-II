package conexion;

import funcion.FuncionCampo;

import java.sql.*;
import java.util.Scanner;

public class ConexionColumna {
    static Scanner teclado = new Scanner(System.in);
    public static void crearColumna(String baseSeleccionada){
        try(Connection conn = DriverManager.getConnection(Conexion.url + baseSeleccionada, Conexion.usuario, Conexion.contra); Statement stmt = conn.createStatement()){
            ConexionTabla.listarTabla(baseSeleccionada);
            System.out.print("Ingrese el nombre de la tabla en la que desea crear el campo: ");
            String nombreTabla = teclado.nextLine();
            String campos = FuncionCampo.crearCampo();
            String sql = "ALTER TABLE " + nombreTabla + " ADD " + campos;
            System.out.println(sql);
            stmt.executeUpdate(sql);
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void listarColumna(String baseSeleccionada){
        try(Connection conn = DriverManager.getConnection(Conexion.url + baseSeleccionada, Conexion.usuario, Conexion.contra); Statement stmt = conn.createStatement()){
            ConexionTabla.listarTabla(baseSeleccionada);
            System.out.print("Ingrese el nombre de la tabla de la que desea ver las columnas: ");
            String saberColumnas = teclado.nextLine();
            String sql = "DESCRIBE " + saberColumnas;
            ResultSet resultado = stmt.executeQuery(sql);
            System.out.println("Columnas de la tabla " + saberColumnas);
            while (resultado.next()){
                System.out.println(resultado.getString(1));
            }
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void modificarColumna(String baseSeleccionada){
        listarColumna(baseSeleccionada);

    }
    public static void eliminarColumna(String baseSeleccionada){}
}
