package funcion;

import conexion.ConexionTabla;

public class FuncionCampo {
    public static String crearCampo(){
        return FuncionTabla.opcionCampo();
    }
    public static String saberTabla(String baseSeleccionada){
        ConexionTabla.listarTabla(baseSeleccionada);
        System.out.print("Ingrese el nombre de la tabla con la que desea trabajar: ");
        String saberColumnas = teclado.nextLine();
        return saberColumnas;
    }
}
