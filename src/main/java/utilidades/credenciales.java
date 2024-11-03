package utilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class credenciales {
    public static HashMap<String, String> getVarEnt(String file){
        File ent = new File("entorno" + File.separator + file + File.separator + "credenciales.env");

        HashMap<String, String> varEnt = new HashMap<>();

        try(Scanner sc = new Scanner(ent)){
            while (sc.hasNextLine()){
                String data = sc.nextLine();
                String[] particion = data.split("=", 2);
                String clave = particion[0].trim();
                String valor = particion[1].trim();
                varEnt.put(clave, valor);
            }
        } catch (FileNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }
        return varEnt;
    }

    /*public static void main(String[] args){
        //Definir carpeta a leer
        String carpeta = "desarrollo";
        //Obtengo el hashmap, o sea la lista de variables
        HashMap<String, String> listaVar = credenciales.getVarEnt(carpeta);
        //Obtengo el valor de la variable que necesito, pasando como parametro su nombre
        String url = listaVar.get("url");
        //Trabajo con la variable
        System.out.println("URL: " + url);
    }*/
}
