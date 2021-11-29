
import java.io.IOException;
import java.util.Scanner;


import java.util.concurrent.*;


/* Esto es lo de Isra
import proyectofinal12.Consultar;
import proyectofinal12.Estadistica;
import proyectofinal12.ParticionarTarea;
import proyectofinal12.RegistroLogs;*/


public class Main {
    
    private static Scanner entrada;
   
    public static void main(String[] args) throws IOException {
        //int i, tareasPendientes, cantidadBuscadores;//Is
        //ParticionarTarea p;//Is
        
        String nombreArchivo = null;//S
        String ruta = null;//S
        
        /* ---------Directorio y nombre fijos (mientras trabajamos)--------*/
        /* //----------------------------------------------------------------
        ruta = System.getProperty("user.dir");//S
        nombreArchivo = "Cryptocurrencies_to_USD_default_day_2021-01-09.csv";//S
        //-------------------------------------------------------------------*/
        
        //S: PARA PEDIR ARCHIVO:
         //----------------------------------------------------------------
         System.out.println(System.getProperty("user.dir"));
        boolean archivoEncontrado = false;
        entrada = new Scanner(System.in);
        while(archivoEncontrado == false){ //hasta que encuentre el archivo
            System.out.println("Ingresa la ruta del archivo: "); //pregunta por ´la ruta
            ruta = entrada.nextLine();
            System.out.println("Ingresa el nombre del archivo: "); //pregunta por el nombre del archivo
            nombreArchivo = entrada.nextLine();
            archivoEncontrado = BuscarArchivo.Buscar(ruta, nombreArchivo); //valida que el nombre sea correcto 
        }
        //-------------------------------------------------------------------*/
        
        //S: Para crear el objeto archivo:
        ArchivoCSV f = new ArchivoCSV(nombreArchivo, ruta);//crea un objeto tipo ArchivoCSV
        f.imprimirAtributos();
        f.setEjex(CalcularDimensiones.CalcularX(f));
        f.setEjey(CalcularDimensiones.CalcularY(f));
        System.out.println("Después de calcular las dimensiones, tenemos:");
        f.imprimirAtributos();
        
       //ArchivoCSV file = new ArchivoCSV(f,',');
        Particion particion = new Particion(f);
       /*Lo siguiente es todo lo de Isra
//        if (ValidarArchivo.validar(archivo)) {           
//            CSV f = new CSV(archivo, ',');
        
            p = new ParticionarTarea(f);

            tareasPendientes = p.getArchivosTemporales();

            //ExecutorService buscadores = Executors.newFixedThreadPool(tareasPendientes);
            ExecutorService buscadores = Executors.newCachedThreadPool();
            // Activamos el pool de hilos enviandoles tareas
            for (i = 1; i <= tareasPendientes; i++) {
                buscadores.execute(new Consultar(f,i));
            }
            cantidadBuscadores = Thread.activeCount() - 1;

            // Se debe detener el pool
            buscadores.shutdown();
            while (!buscadores.isTerminated()) {
            }// Trampa de espera
            f.imprimirAtributos();
            System.out.println("\t Archivos temporales: \t\t " + Estadistica.imprimirValor(p.getArchivosTemporales()));
            System.out.println("\t Resgistros x archivo: \t\t " + Estadistica.imprimirValor(p.getPaginacion()));
            //f.getCabecera();
            System.out.println("#################################################################");
            
            System.out.println("# Hilos (Buscadores trabajando): \t" + cantidadBuscadores);

            Consultar.imprimirCoincidencias();
            RegistroLogs.obtenerLogsExclusionConsulta();
        } else {
            RegistroLogs.obtenerLogsValidarArchivo();
        }
        */
    }

}
