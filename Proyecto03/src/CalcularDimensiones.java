package proyecto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CalcularDimensiones {
    
    public static int calcularX(ArchivoCSV archivoCSV) throws IOException {
        int ejex = 0;
        System.out.println(archivoCSV.nombre);
        System.out.println(archivoCSV.ruta);
        BufferedReader archivoOrigen = new BufferedReader(new FileReader(archivoCSV.getArchivoCSV()));
        ejex = Herramientas.contarPalabras(archivoOrigen.readLine());
//        try {
//            BufferedReader archivoOrigen = new BufferedReader(new FileReader(archivoCSV.getArchivoCSV()));
//            ejex = Herramientas.contarPalabras(archivoOrigen.readLine());
//            
//        } catch (FileNotFoundException ex) {
//            System.out.println("Archivo no encontrado al momento de calcular la dimensión");
//        }
    return ejex;
    }
    
    public static int calcularY(ArchivoCSV archivoCSV) throws IOException {
        int contador = 0;
        try{
            BufferedReader archivoOrigen = new BufferedReader(new FileReader(archivoCSV.getArchivoCSV()));
            while(archivoOrigen.readLine() != null){
                contador = contador+1;
            }
            archivoOrigen.close();
        }catch(IOException e){
            System.out.println("Archivo no encontrado"); 
        }return contador;
    }
}
