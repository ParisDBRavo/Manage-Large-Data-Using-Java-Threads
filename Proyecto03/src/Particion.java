package proyecto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Particion
{

    private BufferedReader archivoOrigen;
    private static final int division = 1000;
    private int archivosTemporales;
    private static int ejey;
    private static final String ruta = Herramientas.directorioActual()+ "/Temporales";
    private String[] particionesdeNombre;
    private static String[] archivosDivididos;
//aqui invoco los demás metodos para hacer la partición es como mi main
    public static String obtenerRutaTemp()
    {
        return ruta;
    }
    public Particion(ArchivoCSV archivoCSV)
    {
        particionesdeNombre = archivoCSV.getNombre().split("\\.");
        try {
            this.archivoOrigen = new BufferedReader(new FileReader(archivoCSV.getArchivoCSV()));
            
            this.numeroDeParticiones(archivoCSV);
            this.divisionDeArchivos(archivoCSV);
            this.archivoOrigen.close();
        } catch (IOException e) 
        {
            System.out.println("Particion");
            System.out.println(e);
        }
    }
    public static int numeroDeDivisiones()
    {
        int numero=ejey/division;
        if(ejey%division != 0)
        {
            numero = numero+1;
        }
        return numero;
    }




    public void numeroDeParticiones(ArchivoCSV archivoCSV)
    {
        //aqui calculo el numero de particiones a realizar
        
       // int[] cocienteResiduo;
        String fila;
        String columnas[] = {};
        try{
            int ejex=CalcularDimensiones.calcularX(archivoCSV);
            fila = archivoOrigen.readLine();
            columnas = fila.split("" + archivoCSV.getSeparadorCampo() + "");
            archivoOrigen.close();

            ejey = CalcularDimensiones.calcularY(archivoCSV);
            int[] cocienteResiduo = {ejey/division, ejey%division};
         //   System.out.println(".---------------------------------");
         //   System.out.println(ejey/division +"    " +ejey%division);
            if (cocienteResiduo[1] > 0) {           
                setArchivosTemporales(cocienteResiduo[0] + 1);
            } else {            
                setArchivosTemporales(cocienteResiduo[0]);
            }
        }
        catch(Exception e)
        {
            System.out.println("numeroDeParticiones");
            System.out.println(e);
        }

    }


    public void divisionDeArchivos(ArchivoCSV archivoCSV)
    { 
        //aqui hago las particiones en el archivo donde se ejecuta el programa abro una nueva carpeta
        int indiceArchivo=0;
        int numFila = 1;
        String fila;
        
        File pathProvisorio; 

        BufferedWriter[] archivosParticionados;

        archivosDivididos = new String[archivosTemporales];
        archivosParticionados = new BufferedWriter[archivosTemporales];
       // System.out.println(archivosTemporales);
        pathProvisorio = new File(ruta);
        try
        {
            pathProvisorio.mkdir();
            archivoOrigen = new BufferedReader(new FileReader(archivoCSV.getArchivoCSV()));
            for(int i=0; i<archivosTemporales; i++)
            {
                //creo el nombre para después crear los archivos
                archivosDivididos[i]= particionesdeNombre[0] + "_"+ i+1+"."+particionesdeNombre[1];
                archivosParticionados[i]= new BufferedWriter(new FileWriter(new File(ruta, archivosDivididos[i])));
                //System.out.println(archivosParticionados[i]);
            }
            while ((fila = archivoOrigen.readLine()) != null) 
            {
                if (numFila != 1) 
                {
                    archivosParticionados[indiceArchivo].write(fila + "\n");
                    if ((numFila % division) == 0) 
                    {
                        indiceArchivo++;
                    }
                }
                numFila++;
            }
            archivoOrigen.close();
            for (int i = 0; i < archivosTemporales; i++) {
                archivosParticionados[i].close();
            }
        }
        catch(IOException e)
        {
            System.out.println("division de Archivos");
            System.out.println(e);
        }

    }



    public void setArchivosTemporales(int archivosTemporales) 
    {
        this.archivosTemporales = archivosTemporales;
    }
    public static String nombresTemporales(int i)
    {
        return archivosDivididos[i];
    }
    public static void eliminarDirectorio()
    {
        File borrar = new File(ruta);
        borrar.delete();
    }
}
