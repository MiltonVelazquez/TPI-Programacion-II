import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Prueba {
    public static void main(String[] args) {
        // Crear el mapa con múltiples claves y valores
        Map<String, List<String>> multiValueMap = new HashMap<>();
        multiValueMap.computeIfAbsent("frutas", k -> new ArrayList<>()).add("manzana");
        multiValueMap.computeIfAbsent("frutas", k -> new ArrayList<>()).add("banana");
        multiValueMap.computeIfAbsent("frutas", k -> new ArrayList<>()).add("cereza");
        multiValueMap.computeIfAbsent("vegetales", k -> new ArrayList<>()).add("zanahoria");
        multiValueMap.computeIfAbsent("vegetales", k -> new ArrayList<>()).add("lechuga");

        // Recorrer y imprimir todas las claves y sus valores
        for (Map.Entry<String, List<String>> entry : multiValueMap.entrySet()) {
            String clave = entry.getKey();
            List<String> valores = entry.getValue();
            System.out.print(clave + ": ");
            for (int i = 0; i < valores.size(); i++) {
                System.out.print(valores.get(i));
                if (i < valores.size() - 2) {
                    System.out.print(", ");
                } else if (i == valores.size() - 2) {
                    System.out.print(" y ");
                }
            }
            System.out.println(".");
        }
    }
}
