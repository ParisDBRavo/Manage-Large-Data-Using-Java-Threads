package proyecto;

import java.util.Scanner;
import java.util.List;
import java.io.*;
public class Herramientas {
    public static String entrada()
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Dame la ruta del archivo de origen: ");
        String rutaAbsoluta = entrada.nextLine();
        return rutaAbsoluta;
    }
    public static String nombre()
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Dame el nombre del archivo origen: ");
        String archivoOrigen = entrada.nextLine();
        return archivoOrigen;
    }
    public static String salida()
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Dame el nombre del archivo para guardar los datos filtrados: ");
        String archivoSalida = entrada.nextLine();
        archivoSalida = archivoSalida + ".csv";
        return archivoSalida;
    }
    public static int contarPalabras(String palabra)
    {
        int contador;
        //String palabraSinComa;
        contador = 0;
        for(int i = 0; i<palabra.length(); i++)
        {   
     //       System.out.println(palabra.charAt(i));
       
    if(palabra.charAt(i)==',')
            {
                contador = contador+1;
            }
        }
        return contador;
    }
    public static int contarEnY(String rutaAbsoluta, String nombreArchivo1)
    {
        int contador =0;
        File f1 = new File(rutaAbsoluta,nombreArchivo1);
        try
        {
            BufferedReader archivoOrigen = new BufferedReader(new FileReader(f1));
            while(archivoOrigen.readLine() != null)
            {
                contador = contador+1;
            }
            archivoOrigen.close();
        }
        catch(Exception e)
        {
            e.getStackTrace(); 
        }
        return contador;
    }
    public static void utilidad(int numeroProcesadores, int ejey)
    {
        if(2*numeroProcesadores>ejey)
        {
            System.out.println("Tu problema no vale la pena ser resuelto por este método, son muy pocos datos");
            System.exit(0);
        }
    }
    
    public static int validarColumna(String[] lista){
        boolean seguirPreguntando = true;
        int columna=0;
          while(seguirPreguntando == true){
            Scanner entrada = new Scanner(System.in);
            System.out.println("Selecciona una columna para filtrar los datos:");
            columna = entrada.nextInt();
            try{
                String filtrarPor = lista[columna];
                seguirPreguntando = false;
            }catch(Exception e){
              System.out.println("ERROR: No existe la columna "+columna);
              seguirPreguntando = true;
          }
        }
        return columna;
    }
    
//    public static void validarColumna2(List<String> datos){
//        datos.size();
//        boolean seguirPreguntando = true;
//        int columna=0;
//          while(seguirPreguntando == true){
//            Scanner entrada = new Scanner(System.in);
//            System.out.println("Selecciona una columna para filtrar los datos:");
//            columna = entrada.nextInt();
//            try{
//                String filtrarPor = renglon[columna];
//                seguirPreguntando = false;
//            }catch(Exception e){
//              System.out.println("ERROR: No existe la columna "+columna);
//              seguirPreguntando = true;
//          }
//        }
//        return columna;
//    }
    
    public static boolean compararValor(String valor, List<String> renglon, int indice){
        return renglon.get(indice).equals(valor);
    }
    
    public static void filtrarPorColumna(List<String> datos){
        System.out.println(datos.size());
    }
}