
package proyecto;
import java.io.*;
import java.util.Scanner;

public class BufferReaderFiltrado {
    public static void main(String[] args){
        System.out.println("Dame la ruta del archivo de origen: ");
        Scanner entrada = new Scanner(System.in);
        String rutaAbsoluta = entrada.nextLine();
        System.out.println("Dame el nombre del archivo origen: ");
        String nombreArchivo1 = entrada.nextLine();

        System.out.println("Dame el nombre del archivo para guardar los datos filtrados: ");
        String nombreArchivo2 = entrada.nextLine();
        
//        String rutaAbsoluta ="D:\\Documents\\POSGRADO\\Master\\Prog Av\\PROYECTO\\Proyecto\\Cryptocurrencies_to_USD_default_day_2021-01-09.csv";
//        String nombreArchivo1 = "Cryptocurrencies_to_USD_default_day_2021-01-09.csv";

        String linea;
        String[] campos;

        File f1 = new File(rutaAbsoluta,nombreArchivo1);
        File f2 = new File(rutaAbsoluta,nombreArchivo2);
        try {
            BufferedReader archivoOrigen = new BufferedReader(new FileReader(f1));
            BufferedWriter archivoDestino = new BufferedWriter(new FileWriter(f2));
            
            linea = archivoOrigen.readLine();
 //           System.out.println("Las columnas de tu archivo son las siguientes:\n"+linea);              
 //           System.out.println("Selecciona una columna para filtrar los datos\n"+linea);
            
            while((linea = archivoOrigen.readLine()) != null){
               campos = linea.split(",");  // 

                if(campos[7].equals("BTC")){
                    archivoDestino.write(campos[0] + " , " + campos[1]+ " , " + campos[2]+ " , " + campos[3]+"\n");
                }              
            }
            archivoOrigen.close();
            archivoDestino.close();
        }catch(FileNotFoundException e){
            e.getStackTrace(); 
            System.out.println("Error: archivo no encontrado. Revisa si el nombre y la ruta son correctos.");
        }catch(IOException e){
            e.getStackTrace();     
        }
    }
}
