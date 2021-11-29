import java.util.Scanner;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
public class Herramientas extends Thread{
    private String valor;
    private int columna;
    List<List<String>> hilo;
    private int ejex;
    public static List<List<String>> resultado= new ArrayList<List<String>>();;
    public Herramientas(String valor, List<List<String>> hilo,int columna, int ejex )
    {
        this.valor = valor;
        this.columna = columna;
        this.hilo = hilo;
        this.ejex=ejex;
       
    }


    public static String directorioActual()
    {
        String currentDir = System.getProperty("user.dir");
        //System.out.println("Current dir:" + currentDir);
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
        String[] s = palabra.split(",");
        return s.length -1;
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
        catch(IOException e)
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
    
    public static String getValor()
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escribe el valor que debe tener el dato a filtrar: ");
        String valor = entrada.nextLine();
        return valor;
    }
    
    public static boolean compararValor(String valor, List<String> renglon, int indice)
    {
        return renglon.get(indice).equals(valor);
    }
    
//      public static void validarColumna(int columna,int ejex){
//          
//      }
      
    public static void filtrarPorColumna(String valor,List<List<String>> hilo, int columna)
    {
        for(List<String> arre: hilo){
            if(Herramientas.compararValor(valor, arre, columna)){
                System.out.println(arre);
            }
        }
    }
    public void run()
    {

            for(List<String> arre: this.hilo)
            {
                if(Herramientas.compararValor(this.valor, arre, this.columna)){
                    agregar(arre);
                  
                  //  System.out.println(arre);
                    //for( int i=0; i<=ejex;i++)
                  //  {
                //System.out.println(arre.get(i));
                      //  archivoDestino.write(arre.get(i)); 
                        //archivoDestino.write(",");
                    //}
                    //archivoDestino.newLine();
                }
            }
            //archivoDestino.close();
    }
    public synchronized void agregar(List<String> palabra)
    {
        resultado.add(palabra);
    }
    public List<List<String>>regresar()
    {
        return resultado;
    }
    
    public static int getColumna(int ejex){
        boolean seguirPreguntando = true;
        int columna=0;
          while(seguirPreguntando == true){
            Scanner entrada = new Scanner(System.in);
            System.out.println("Selecciona el número de la columna para filtrar los datos:");
            try{
                columna = entrada.nextInt();
                seguirPreguntando = false;
            }catch(Exception e){
              System.out.println("ERROR: No has escrito un número entero. Inténtalo de nuevo.");
              seguirPreguntando = true;
          }
            if(columna>ejex){
                System.out.println("ERROR: No existe la columna que elegiste. Inténtalo de nuevo.");
                columna = getColumna(ejex);
            }
        }
        return columna;
    }
}