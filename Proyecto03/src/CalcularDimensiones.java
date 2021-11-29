

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CalcularDimensiones {
    
    public static int CalcularX(ArchivoCSV archivoCSV) throws IOException {
        int ejex = 0;
        try {
            BufferedReader archivoOrigen = new BufferedReader(new FileReader(archivoCSV.getArchivoCSV()));
            ejex = contarPalabras(archivoOrigen.readLine());
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        }
    return ejex;
    }
    
    public static int contarPalabras(String palabra)
    {
        String[] s = palabra.split(",");
        return s.length -1;
    }
    
    public static int CalcularY(ArchivoCSV archivoCSV) throws IOException {
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
