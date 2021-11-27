package proyecto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;
//import java.util.Scanner;
//import java.util.Scanner;
public class Excel //filtrado después de acomodar en arreglos
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
//        String rutaAbsoluta = Herramientas_BEFORE.entrada();
//        String nombreArchivo1 = Herramientas_BEFORE.nombre();
//        String nombreArchivo2 = Herramientas_BEFORE.salida();
        
        String rutaAbsoluta = Herramientas.directorioActual();
        String nombreArchivo1 = "Cryptocurrencies_to_USD_default_day_2021-01-09.csv";
        String nombreArchivo2 = "datos.csv";
        
        String linea;
        int ejex =0;
        int ejey;
       // int ejeyResultados;
        int numeroProcesadores;
        String lista[];
        int contador =0;
        int n;
        int division;


        n=0;

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
            Herramientas_BEFORE.utilidad(numeroProcesadores, ejey);
            division = ejey/(numeroProcesadores*2);
            //division son las particiones que tendrá el archivo, en mi caso fueron 1
            List<List<String>> listaGrupal = new ArrayList<List<String>>();
            List<List<List<String>>> listaDivision = new ArrayList<List<List<String>>>();
 //La primera lista de listas es para separar por renglon y juntar todos los conjuntos hasta la primera separacion
  //Las lista de listas de listas es para poner estos conjuntos y es lo que le vamos a mandar a los procesadores
  //Asi ya tenemos todo por renglon y en conjuntos grandes
       //System.out.println(ejey);
       //System.out.println(division);
  //          System.out.println(linea);
  //          System.out.println(ejex);
        
            
            while((linea = archivoOrigen.readLine()) != null)
            {
               lista = linea.split(",");
               campos = Arrays.asList(lista);  
               listaGrupal.add(campos);
            }
            for(int i=0; i<=ejey;i++)
            {
               //System.out.println(lista[0]);
               //System.out.println(Arrays.toString(lista));
               if(contador==division)
               {
                   listaDivision.add(listaGrupal.subList(Herramientas.inicio(division, n),Herramientas.fin(division, n))); 
                   //System.out.println(listaGrupal.size());
//                    listaGrupal.clear();
                  //System.out.println("Entro al if");
                  n++;
                    contador=0;
               }
               
//------------------------------.------------------------------------
//------------------------------------------------------------------
//------------------------------------------------------------------
///Escribir el resultadooo
//------------------------------------------------------------------
//------------------------------------------------------------------
//------------------------------------------------------------------
              
               /*
                for( int i=0; i<=ejex;i++)
                {
      //              System.out.println(listaDivision.get(i));
                    archivoDestino.write(campos.get(i)); 
                    archivoDestino.write(",");
                }

                archivoDestino.newLine(); */
                contador ++;
            }
            listaDivision.add(listaGrupal.subList(Herramientas.inicio(division, n),ejey-1)); 
            System.out.println(Herramientas.inicio(division, n));
            System.out.println(ejey);
            
                for(List<List<String>> hilo: listaDivision)
                { //Imprimo los contenidos de listaDivision
                    for(List<String> arre: hilo)
                    {
                       // System.out.println(arre.get(7));
                       for( int i=0; i<=ejex;i++)
                        {
      //              System.out.println(listaDivision.get(i));
                            archivoDestino.write(arre.get(i)); 
                            archivoDestino.write(",");
                        }
                        archivoDestino.newLine();
                    }
                  //  System.out.println("\n");
                }
            
            int columna = Herramientas.getColumna(ejex);
            String valor = Herramientas.getValor();
            
            for(List<List<String>> hilo: listaDivision){ //Imprimo los contenidos de listaDivision
                Herramientas.filtrarPorColumna(valor, hilo,columna);
            }
           
            //ejeyResultados= Herramientas_BEFORE.contarEnY(rutaAbsoluta, nombreArchivo2);
           // System.out.println(ejey+"      " +  ejeyResultados);
           
            archivoOrigen.close();
            archivoDestino.close();

            
//        for(List<List<String>> hilo: listaDivision)
//                { //Imprimo los contenidos de listaDivision
//                    for(List<String> arre: hilo)
//                    {
//                       System.out.println(arre.get(7));
//                       
//                    }
//                  //  System.out.println("\n");
//                }

        }catch(FileNotFoundException e)
        {
            e.getStackTrace(); 
            System.out.println("Error: archivo no encontrado. Revisa si el nombre y la ruta son correctos.");
        }catch(IOException e){
            e.getStackTrace();     
        }   
    }    

}