package conexion;

import menus.MenuBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConexionTabla {
    static Scanner teclado = new Scanner(System.in);
    static int opcion = 0;
    public static void crearTabla(){
        System.out.print("Ingrese el nombre de la tabla a crear: ");
        String nombre = teclado.nextLine();
        try (Connection conn = DriverManager.getConnection(Conexion.url, Conexion.usuario, Conexion.contra);Statement stmt = conn.createStatement()){
            crearCampo();
            String sql = "CREATE TABLE" + nombre + "(";
            stmt.executeUpdate(sql);

        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void crearCampo(){

        do{
            preguntarCampo();
            tomarOpcion();
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion){
                case 1:
                    opcionCampo();
                    break;
                case 2:
                    MenuBase.opciones();
                    break;
            }

        } while(opcion != 10);
    }
    public static void opcionCampo(){
        String nombre;
        System.out.print("Ingrese el nombre del campo: ");
        nombre = teclado.nextLine();
        Map<String, List<String>> campos = new HashMap <>();
        valorCampo();

    }
    public static String valorCampo(){
        System.out.println("Ingrese que tipo de dato quiere en el campo: ");
        System.out.println("1 - Varchar de 50 caracteres");
        System.out.println("2 - Varchar de 100 caracteres");
        System.out.println("3 - Numero entero");
        System.out.println("4 - Fecha (En formato Año/Mes/Dia)");
        tomarOpcion();
        opcion = teclado.nextInt();
        teclado.nextLine();
        return valores()
    }
    public static void preguntarCampo(){
        System.out.println("*** ¿Desea crear un nuevo campo? ***");
        System.out.println("1 - Si");
        System.out.println("2 - No");
    }
    public static void tomarOpcion(){
        System.out.print("Ingrese una opcion dependiendo del numero: ");
    }
    public static void eliminarTabla(){}
    public static void modificarTabla(){}

}
