package conexion;

import funcion.FuncionCampo;
import funcion.FuncionTabla;
import menus.MenuTrabajarConCampo;
import utilidades.Utilidades;

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
            MenuTrabajarConCampo.correrMenu(baseSeleccionada);
        }
    }
    public static void listarColumna(String baseSeleccionada){
        try(Connection conn = DriverManager.getConnection(Conexion.url + baseSeleccionada, Conexion.usuario, Conexion.contra); Statement stmt = conn.createStatement()){
            String saberColumnas = FuncionCampo.saberTabla(baseSeleccionada);
            String sql = "DESCRIBE " + saberColumnas;
            ResultSet resultado = stmt.executeQuery(sql);
            System.out.println("Columnas de la tabla " + saberColumnas);
            while (resultado.next()){
                System.out.println(resultado.getString(1));
            }
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
            MenuTrabajarConCampo.correrMenu(baseSeleccionada);
        }
    }
    public static void modificarColumna(String baseSeleccionada){
        try(Connection conn = DriverManager.getConnection(Conexion.url + baseSeleccionada, Conexion.usuario, Conexion.contra); Statement stmt = conn.createStatement()){
            String saberColumnas = FuncionCampo.saberTabla(baseSeleccionada);
            String sql = "DESCRIBE " + saberColumnas;
            ResultSet resultado = stmt.executeQuery(sql);
            System.out.println("Columnas de la tabla " + saberColumnas);
            while (resultado.next()){
                System.out.println(resultado.getString(1));
            }
            System.out.print("Ingrese el nombre del campo que desea modificar: ");
            String nombreCampo = teclado.nextLine();
            System.out.println("*** Modificar campo ***");
            System.out.println("1 - Cambiar nombre y tipo de dato");
            System.out.println("2 - Cambiar solo nombre");
            System.out.println("3 - Cambiar solo tipo");
            int opcion = Utilidades.tomarOpcion();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre del campo: ");
                    String nombreCambiarTodo = teclado.nextLine();
                    String campo = FuncionTabla.valorCampo();
                    String sqlCambiarTodo = "ALTER TABLE " + saberColumnas + " CHANGE COLUMN " + nombreCampo + " " + nombreCambiarTodo + " " + campo;
                    System.out.println(sqlCambiarTodo);
                    stmt.executeUpdate(sqlCambiarTodo);
                    break;
                case 2:
                    System.out.print("Ingrese el nuevo nombre del campo: ");
                    String nombreSolo = teclado.nextLine();
                    String tipoDatoSolo = obtenerTipoDato(saberColumnas, nombreCampo, baseSeleccionada);
                    String sqlSolo = "ALTER TABLE " + saberColumnas + " CHANGE COLUMN " + nombreCampo + " " + nombreSolo + " " + tipoDatoSolo;
                    System.out.println(sqlSolo);
                    stmt.executeUpdate(sqlSolo);
                    break;
                case 3:
                    String nuevoCampo = FuncionTabla.valorCampo();
                    String sqlCampo = "ALTER TABLE " + saberColumnas + " MODIFY COLUMN " + nombreCampo + " " + nuevoCampo;
                    System.out.println(sqlCampo);
                    stmt.executeUpdate(sqlCampo);
                    break;
            }

        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
            MenuTrabajarConCampo.correrMenu(baseSeleccionada);
        }


    }
    public static void eliminarColumna(String baseSeleccionada){
        try(Connection conn = DriverManager.getConnection(Conexion.url + baseSeleccionada, Conexion.usuario, Conexion.contra); Statement stmt = conn.createStatement()){
            String nombreTabla = FuncionCampo.saberTabla(baseSeleccionada);
            String sql = "DESCRIBE " + nombreTabla;
            ResultSet resultado = stmt.executeQuery(sql);
            System.out.println("Columnas de la tabla " + nombreTabla);
            while (resultado.next()){
                System.out.println(resultado.getString(1));
            }
            System.out.print("Ingrese el nombre del campo que desea eliminar: ");
            String campoEliminar = teclado.nextLine();
            String sqlEliminar = "ALTER TABLE " + nombreTabla + " DROP COLUMN " + campoEliminar;
            System.out.println(sqlEliminar);
            stmt.executeUpdate(sqlEliminar);
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
            MenuTrabajarConCampo.correrMenu(baseSeleccionada);
        }
    }

    public static String obtenerTipoDato(String tabla, String columna, String baseSeleccionada){
        try(Connection conn = DriverManager.getConnection(Conexion.url + baseSeleccionada, Conexion.usuario, Conexion.contra); Statement stmt = conn.createStatement()){
            String tipoDato = "";
            String sql = "SHOW COLUMNS FROM " + tabla + " LIKE '" + columna + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                tipoDato = rs.getString("Type");
            } rs.close();
            return tipoDato;
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return "";
    }

}
