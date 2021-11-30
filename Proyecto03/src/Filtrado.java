package proyecto;

import java.util.Scanner;
import java.io.*;

public class Filtrado {

    public static String nombreFiltrado(String nombreArchivoOriginal, String valor){
        return nombreArchivoOriginal +"_"+valor+".csv";
    }
    
    public static String pedirValor(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escribe el valor que debe tener el dato a filtrar: ");
        String valor = entrada.nextLine();
        return valor;
    }
    
    public static boolean compararValor(String valor, String[] renglon, int indice){
        return renglon[indice].equals(valor);  
    }
    
    public static int pedirColumna(int ejex){
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
                columna = pedirColumna(ejex);
            }
        }
        return columna;
    }
    
    public static void filtrarArchivoTemporal(String nombre, String ruta) throws IOException{
        if(BuscarArchivo.Buscar(ruta, nombre)){
        ArchivoCSV f = new ArchivoCSV(nombre, ruta);
        f.setEjex(CalcularDimensiones.calcularX(f));
        
        int columna = pedirColumna(f.ejex);
        String valor = pedirValor();
        String linea;

        BufferedReader archivoTemp;
        try {
            archivoTemp = new BufferedReader(new FileReader(f.archivo));
            while((linea = archivoTemp.readLine()) != null){
               BufferedWriter datosFiltrados = new BufferedWriter(new FileWriter(nombreFiltrado(nombre, ruta),true));
               
               String[] campos = linea.split(",");
               
               if(compararValor(valor, campos, columna)){
                   datosFiltrados.append(linea);
               } 
               datosFiltrados.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo para escribir no encontrado.");
        }  
    }
    }   
    
      public static void filtrarArchivoTemporal(ArchivoCSV f) throws IOException{
        if(BuscarArchivo.Buscar(f.ruta, f.nombre)){
        
        f.setEjex(CalcularDimensiones.calcularX(f));
        f.setEjey(CalcularDimensiones.calcularY(f));
        
        int columna = pedirColumna(f.ejex);
        String valor = pedirValor();
        String linea;

        BufferedReader archivoTemp;
        File datosFiltrados = new File(f.ruta,nombreFiltrado(f.nombre,valor));
        try {
            archivoTemp = new BufferedReader(new FileReader(f.archivo));
           
            while((linea = archivoTemp.readLine()) != null){
               BufferedWriter datos = new BufferedWriter(new FileWriter(datosFiltrados,true));
               
               String[] campos = linea.split(",");
               //System.out.println(linea);
               if(compararValor(valor, campos, columna)){
                   //System.out.println(linea);
                   datos.append(linea+"\n");
               } 
               datos.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo para escribir no encontrado.");
        }  
    }
    }  
}