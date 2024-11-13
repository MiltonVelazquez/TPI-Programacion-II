package conexion;

import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;
import funcion.FuncionCampo;
import menus.MenuTrabajarConDato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConexionDato {
    static Scanner teclado = new Scanner(System.in);
    public static void crearDato(String baseSeleccionada) {
        try (Connection conn = DriverManager.getConnection(Conexion.url + baseSeleccionada, Conexion.usuario, Conexion.contra);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            String tabla = FuncionCampo.saberTabla(baseSeleccionada);
            String sql = "DESCRIBE " + tabla;
            ResultSet resultado = stmt.executeQuery(sql);
            System.out.println("Ingrese los datos de cada columna: ");
            StringBuilder sqlCrear = new StringBuilder("INSERT INTO " + tabla + " (");
            resultado.last();
            int size = resultado.getRow();
            resultado.beforeFirst();
            int i = 0;
            while (resultado.next()) {
                String nombre = resultado.getString("Field");
                if (!nombre.equals("id")) {
                    sqlCrear.append(nombre);
                    if (i < size - 1) {
                        sqlCrear.append(", ");
                    }
                }
                i++;
            }

            sqlCrear.append(") VALUES (");
            resultado.beforeFirst();
            i = 0;
            while (resultado.next()) {
                String nombre = resultado.getString("Field");
                String tipo = resultado.getString("Type");
                if (!nombre.equals("id")) {
                    System.out.print("Ingrese un valor para " + nombre + "(" + tipo + "): ");
                    String ingreso = teclado.nextLine();
                    sqlCrear.append("'");
                    sqlCrear.append(ingreso);
                    sqlCrear.append("'");
                    if (i < size - 1) {
                        sqlCrear.append(", ");
                    }
                }
                i++;
            }

            sqlCrear.append(")");

            System.out.println(sqlCrear.toString().trim());
            stmt.executeUpdate(sqlCrear.toString().trim());
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            MenuTrabajarConDato.correrMenu(baseSeleccionada);
        }

    }
    public static String listarDatos(String baseSeleccionada){
        try(Connection conn = DriverManager.getConnection(Conexion.url + baseSeleccionada, Conexion.usuario, Conexion.contra); Statement stmt = conn.createStatement()){
            String tabla = FuncionCampo.saberTabla(baseSeleccionada);
            String sql = "SELECT * FROM " + tabla;
            ResultSet resultado = stmt.executeQuery(sql);
            int cantidadColumnas = resultado.getMetaData().getColumnCount();
            String[] nombreColumnas = new String[cantidadColumnas];
            for (int i = 1; i <= cantidadColumnas; i++){
                nombreColumnas[i - 1] = resultado.getMetaData().getColumnName(i );
            }
            List<String[]> filas = new ArrayList<>();
            while (resultado.next()){
                String[] fila = new String[cantidadColumnas];
                for (int i = 1; i <= cantidadColumnas; i++){
                    fila[i - 1] = resultado.getString(i);
                }
                filas.add(fila);
            }
            Object[][] filasArray = new Object[filas.size()][cantidadColumnas];
            for (int i = 0; i < filas.size(); i++){
                filasArray[i] = filas.get(i);
            }
            String tablaArmada = AsciiTable.getTable(nombreColumnas, filasArray);
            System.out.println(tablaArmada);
            return tabla;
        } catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            MenuTrabajarConDato.correrMenu(baseSeleccionada);
        }
        return "";
    }
    public static void actualizarDato(String baseSeleccionada) {
        try (Connection conn = DriverManager.getConnection(Conexion.url + baseSeleccionada, Conexion.usuario, Conexion.contra);
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            String tabla = FuncionCampo.saberTabla(baseSeleccionada);
            String sql = "DESCRIBE " + tabla;
            ResultSet resultado = stmt.executeQuery(sql);
            System.out.println("Ingrese los datos de cada columna a modificar");
            StringBuilder sqlActualizar = new StringBuilder("UPDATE " + tabla + " SET ");
            resultado.last();
            int size = resultado.getRow();
            resultado.beforeFirst();
            int i = 0;
            System.out.print("Ingrese el id del campo que desea modificar: ");
            int id = teclado.nextInt();
            teclado.nextLine();


            while (resultado.next()) {
                String nombre = resultado.getString("Field");
                String tipo = resultado.getString("Type");
                if (!nombre.equals("id")) {
                    System.out.print("Ingrese un valor para " + nombre + "(" + tipo + "): ");
                    String ingreso = teclado.nextLine();
                    sqlActualizar.append(nombre);
                    sqlActualizar.append(" = ");
                    sqlActualizar.append("'");
                    sqlActualizar.append(ingreso);
                    sqlActualizar.append("'");

                    if (i < size - 1) {
                        sqlActualizar.append(", ");
                    }
                }
                i++;
            }

            sqlActualizar.append(" WHERE id = ");
            sqlActualizar.append(id);


            System.out.println(sqlActualizar.toString().trim());
            stmt.executeUpdate(sqlActualizar.toString().trim());
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            MenuTrabajarConDato.correrMenu(baseSeleccionada);
        }
    }
    public static void eliminarDato(String baseSeleccionada){
        try(Connection conn = DriverManager.getConnection(Conexion.url + baseSeleccionada, Conexion.usuario, Conexion.contra); Statement stmt = conn.createStatement()){
            String tabla = listarDatos(baseSeleccionada);
            System.out.print("Ingrese el id del campo que desea eliminar: ");
            int id = teclado.nextInt();
            String sql = "DELETE FROM " + tabla + " WHERE "id = " + id;
            stmt.executeUpdate(sql);
            teclado.nextLine();
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
            MenuTrabajarConDato.correrMenu(baseSeleccionada);
        }

    }
}
