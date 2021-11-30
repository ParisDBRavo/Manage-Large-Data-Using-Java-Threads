
package proyecto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class LeeryCrear {
   
    static void leer(String nombreArchivo, String ruta) throws IOException{
       ArchivoCSV f = new ArchivoCSV(nombreArchivo, ruta);//crea un objeto tipo ArchivoCSV
        
        f.setEjex(CalcularDimensiones.calcularX(f));
        f.setEjey(CalcularDimensiones.calcularY(f));
        BufferedReader archivoOrigen = new BufferedReader(new FileReader(f.getArchivoCSV()));
        String fila = archivoOrigen.readLine();
        String campos[] = fila.split(""+f.getSeparadorCampo());
        f.imprimirAtributos();
        imprimirCampos(campos);
        Particion particion = new Particion(f);
        
    }
    
    static void imprimirCampos(String[] campos){
        System.out.println("Las columnas que contiene tu archivo son:");
        System.out.println("-->");
        for(int i=0; i < campos.length ;i++){
            System.out.print("|"+i+". "+campos[i]);
        }
        System.out.println("|");
        System.out.println("-->");
    }
    
        
}
