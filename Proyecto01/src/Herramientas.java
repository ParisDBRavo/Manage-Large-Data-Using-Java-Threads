import java.util.Scanner;
import java.io.*;
public class Herramientas {
    public static String directorioActual()
    {
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir:" + currentDir);
        return currentDir;
    }
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
    public static int inicio(int i, int n)
    {
        return n*i;
    }
    public static int fin(int i, int n)
    {
        int z= (n+1)*i;
        return z;
    }


}
