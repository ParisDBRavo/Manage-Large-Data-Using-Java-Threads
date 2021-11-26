import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;
//import java.util.Scanner;
public class Excel 
{
    /*private static String obtenerDirectorio()
    {
        //String direccion;
        //direccion = System.getProperty("user.dir");
        String directorio= System.getProperty("user.dir");
        return directorio;
    }*/
    public static void abrirExcel()
    {
        String rutaAbsoluta = Herramientas.entrada();
        String nombreArchivo1 = Herramientas.nombre();
        String nombreArchivo2 = Herramientas.salida();
        String linea;
        int ejex =0;
        int ejey;
        int numeroProcesadores;
        String lista[];
        int contador =0;
        int division;


        List<String> campos = new ArrayList<String>();
        

        File f1 = new File(rutaAbsoluta,nombreArchivo1);
        File f2 = new File(rutaAbsoluta,nombreArchivo2);
        numeroProcesadores = Num_Procesadores.numPros();
        try {
            BufferedReader archivoOrigen = new BufferedReader(new FileReader(f1));
            BufferedWriter archivoDestino = new BufferedWriter(new FileWriter(f2));
            
 //           System.out.println("Las columnas de tu archivo son las siguientes:\n"+linea);              
 //           System.out.println("Selecciona una columna para filtrar los datos\n"+linea);
           // System.out.println(linea);
/*----------------------------------------------------------------------------------------
Voy a empezar la división del un archivo grande y genérico para poder poder hacerlo, 
para esto supongo que los datos vienen de la forma m*n es decir en un rectángulo. Evitando así un
dato que se encuentre fuera de la primera fila y así dividir el rectángulo
El número de hilos debe de ser por lo menos 4 veces de los CPUS que detecte la virtual machine
------------------------------------------------------------------------------------------
*/
            linea = archivoOrigen.readLine();
            ejex = Herramientas.contarPalabras(linea);
            ejey= Herramientas.contarEnY(rutaAbsoluta, nombreArchivo1);
//Veo si el problema vale la pena resolverse de esta manera
            Herramientas.utilidad(numeroProcesadores, ejey);
            division = ejey/(numeroProcesadores*2);
            //division son las particiones que tendrá el archivo, en mi caso fueron 1
            List<List<String>> listaGrupal = new ArrayList<List<String>>();
            List<List<List<String>>> listaDivision = new ArrayList<List<List<String>>>();
 //La primera lista de listas es para separar por renglon y juntar todos los conjuntos hasta la primera separacion
  //Las lista de listas de listas es para poner estos conjuntos y es lo que le vamos a mandar a los procesadores
  //Asi ya tenemos todo por renglon y en conjuntos grandes
//        System.out.println(ejey);
  //          System.out.println(linea);
  //          System.out.println(ejex);
            while((linea = archivoOrigen.readLine()) != null)
            {
               
               lista = linea.split(",");
               campos = Arrays.asList(lista);  
               listaGrupal.add(campos);
               if(contador==division)
               {
                    listaDivision.add(listaGrupal);    
                    listaGrupal.clear();
                    System.out.println("Entro al if");
                    contador=0;
               }
//------------------------------.------------------------------------
//------------------------------------------------------------------
//------------------------------------------------------------------
///Escribir el resultadooo
//------------------------------------------------------------------
//------------------------------------------------------------------
//------------------------------------------------------------------
              

                for( int i=0; i<=ejex;i++)
                {
      //              System.out.println(listaDivision.get(i));
                    archivoDestino.write(campos.get(i)); 
                    archivoDestino.write(",");
                }

                archivoDestino.newLine(); 
                contador =contador+1;
            }
            /*for(List<String> l1: listaGrupal)
            {
                 for(String s: l1)
                 {
                     System.out.print(s + " ");
                 }
                 System.out.println();
            }*/
            archivoOrigen.close();
            archivoDestino.close();


        }catch(FileNotFoundException e)
        {
            e.getStackTrace(); 
            System.out.println("Error: archivo no encontrado. Revisa si el nombre y la ruta son correctos.");
        }catch(IOException e){
            e.getStackTrace();     
        }   
    }    

}
