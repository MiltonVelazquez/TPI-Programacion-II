import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Prueba {
    public static void main(String[] args) {
        // Crear el mapa con múltiples claves y valores
        Map<String, List<String>> mapa = new HashMap<>();
        mapa.computeIfAbsent("frutas", k -> new ArrayList<>()).add("manzana");
        mapa.computeIfAbsent("frutas", k -> new ArrayList<>()).add("banana");
        mapa.computeIfAbsent("frutas", k -> new ArrayList<>()).add("cereza");
        mapa.computeIfAbsent("vegetales", k -> new ArrayList<>()).add("zanahoria");
        mapa.computeIfAbsent("vegetales", k -> new ArrayList<>()).add("lechuga");

        StringBuilder concatenado = new StringBuilder();
        // Recorrer y imprimir todas las claves y sus valores
        for (Map.Entry<String, List<String>> entrada : mapa.entrySet()) {
            List<String> valores = entrada.getValue();
            concatenado.append(entrada.getKey());
            concatenado.append(" ");
            for (String valor : valores) {
                concatenado.append(valor);
                concatenado.append(" ");
            }
            concatenado.append(",\n");
        }

            /*String clave = entrada.getKey();
            List<String> valores = entrada.getValue();
            System.out.print(clave + ": ");
            for (int i = 0; i < valores.size(); i++) {
                System.out.print(valores.get(i));
                if (i < valores.size() - 2) {
                    System.out.print(", ");
                } else if (i == valores.size() - 2) {
                    System.out.print(" y ");
                }
            }
            System.out.println(".");*/
        }
        //String resultado = concatenado.toString().trim();
        //System.out.println(resultado);
    }

