package proyecto;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.*;
public class Proyecto {

    public static void main(String[] args) throws IOException {
        String nombreArchivo=null;//S
        String ruta=null;//S

        /* ---------Directorio y nombre fijos (mientras trabajamos)--------*/
        /* //----------------------------------------------------------------
        ruta = System.getProperty("user.dir");//S
        nombreArchivo = "Cryptocurrencies_to_USD_default_day_2021-01-09.csv";//S
        //-------------------------------------------------------------------*/
        
        //S: PARA PEDIR ARCHIVO:
        //----------------------------------------------------------------
        boolean archivoEncontrado = false;
        Scanner entrada = new Scanner(System.in);

        while(archivoEncontrado == false){ //hasta que encuentre el archivo
            System.out.println("Ingresa la ruta del archivo: "); //pregunta por ´la ruta
            ruta = entrada.nextLine();
            System.out.println("Ingresa el nombre del archivo: "); //pregunta por el nombre del archivo
            nombreArchivo = entrada.nextLine();
            archivoEncontrado = BuscarArchivo.Buscar(ruta, nombreArchivo); //valida que el nombre sea correcto 
        }
        //-------------------------------------------------------------------*/
        
        //S: Para crear el objeto archivo:
        
        LeeryCrear.leer(nombreArchivo, ruta);
        
        ExecutorService hilos = Executors.newFixedThreadPool(Particion.numeroDeDivisiones());
        
        Herramientas.pedirColumna(LeeryCrear.ejexSinArchivo());
        Herramientas.pedirValor();
     //   System.out.println("-------------------");
     //   System.out.println(LeeryCrear.ejexSinArchivo());
     //   System.out.println("-------------------");
      //  String nombreTemporal = "Cryptocurrencies_to_USD_default_day_2021-01-09.csv";
     //   String rutaTemporal = Herramientas.directorioActual();
        //System.out.println(Herramientas.directorioActual());
        //ArchivoCSV archivoTemporal = new ArchivoCSV(nombreTemporal, rutaTemporal);
        long tiempoInicial = System.currentTimeMillis();

        for(int i= 0; i<Particion.numeroDeDivisiones(); i++)
        {
            hilos.execute( new Filtrado(new ArchivoCSV(Particion.nombresTemporales(i), Particion.obtenerRutaTemp()), nombreArchivo));
            
        }
        hilos.shutdown();
        while(!hilos.isTerminated())
        {

        }
        long tiempoFinal = System.currentTimeMillis();
        long tiempoTotal = tiempoFinal - tiempoInicial;
        System.out.println((double)tiempoTotal/1000 +" segundos.");
        for(int i= 0; i<Particion.numeroDeDivisiones(); i++)
        {
            File archivo = new File(Particion.obtenerRutaTemp(),Particion.nombresTemporales(i));
            archivo.delete();
        }
        Particion.eliminarDirectorio();
        //Filtrado.filtrarArchivoTemporal(archivoTemporal);
       
    }


}