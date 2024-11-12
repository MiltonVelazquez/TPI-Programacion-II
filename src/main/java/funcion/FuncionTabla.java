package funcion;

import menus.MenuTrabajarConBase;
import utilidades.Utilidades;

import java.util.*;

public class FuncionTabla {
    static int opcion = 0;
    static Scanner teclado = new Scanner(System.in);

    public static String crearCampo(String baseSeleccionada) {
            StringBuilder campos = new StringBuilder();
            do {
                preguntarCampo();
                opcion = Utilidades.tomarOpcion();
                switch (opcion) {
                    case 1:
                        String resultado = opcionCampo();
                        if (campos.length() > 0) {
                            campos.append(",\n");
                        }
                        campos.append(resultado);
                        break;
                    case 2:
                       break;
                    default:
                        System.out.println("Opción inválida, intenta nuevamente.");
                }
            } while (opcion != 2);

            return campos.toString().trim();
        }



    public static String opcionCampo() {
        String nombre;
        System.out.print("Ingrese el nombre del campo: ");
        nombre = teclado.nextLine();
        Map<String, List<String>> campos = new HashMap<>();

        String atributo = valorCampo();
        campos.computeIfAbsent(nombre, k -> new ArrayList<>()).add(atributo);
        String tipoCampo = tipoCampo();
        campos.computeIfAbsent(nombre, k -> new ArrayList<>()).add(tipoCampo);
        String nulo = nuloNo();
        campos.computeIfAbsent(nombre, k -> new ArrayList<>()).add(nulo);
        StringBuilder concatenado = new StringBuilder();
        for (Map.Entry<String, List<String>> entrada : campos.entrySet()) {
            concatenado.append(entrada.getKey()).append(" ");
            List<String> valores = entrada.getValue();
            for (int i = 0; i < valores.size(); i++) {
                concatenado.append(valores.get(i));
                if (i < valores.size() - 1) {
                    concatenado.append(" ");
                }
            }
        }
        String resultado = concatenado.toString().trim();
         return resultado;
    }
    public static String valorCampo(){
        System.out.println("Ingrese que tipo de dato quiere en el campo: ");
        System.out.println("1 - Varchar de 50 caracteres");
        System.out.println("2 - Varchar de 100 caracteres");
        System.out.println("3 - Numero entero");
        System.out.println("4 - Fecha (En formato Año/Mes/Dia)");
        opcion = Utilidades.tomarOpcion();
        String valor = "";
        switch(opcion){
            case 1:
                valor = "VARCHAR(50)";
                break;
            case 2:
                valor = "VARCHAR(100)";
                break;
            case 3:
                valor = "INT";
                break;
            case 4:
                valor = "DATE";
                break;
        }
        return valor;
    }
    public static String tipoCampo(){
        System.out.println("*** ¿Que tipo de dato desea? ***");
        System.out.println("1 - Unico");
        System.out.println("2 - No unico");
        String tipoCampo = "";
        opcion = Utilidades.tomarOpcion();
        switch (opcion){
            case 1:
                tipoCampo = "UNIQUE";
                break;
            case 2:
                tipoCampo = "";
                break;
        }
        return tipoCampo;
    }
    public static String nuloNo(){
        String autoCampo = "";
        System.out.println("*** ¿Desea que su campo permita valores nulos? ***");
        System.out.println("1 - Si");
        System.out.println("2 - No");
        opcion = Utilidades.tomarOpcion();
        switch (opcion){
            case 1:
                autoCampo = "NULL";
                break;
            case 2:
                autoCampo = "NOT NULL";
                break;
        }
        return autoCampo;
    }*/
    public static void preguntarCampo(){
        System.out.println("*** ¿Desea crear un nuevo campo? ***");
        System.out.println("1 - Si");
        System.out.println("2 - No");
    }
}
