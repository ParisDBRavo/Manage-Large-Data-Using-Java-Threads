import java.util.Scanner;
import java.io.*;

public class Filtrado extends Thread{
    private ArchivoCSV f;
    BufferedWriter datos;
    public Filtrado(ArchivoCSV f)
    {
        this.f = f;
    }
    public static String nombreFiltrado(String nombreArchivoOriginal, String valor)
    {
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
    
   
    
      public void run() 
      {
        if(BuscarArchivo.Buscar(f.ruta, f.nombre)){
        try{f.setEjex(CalcularDimensiones.calcularX(f));
            f.setEjey(CalcularDimensiones.calcularY(f));}
        catch(IOException e){

        }
        File pathFinal;
        int columna = Herramientas.columna;
        String valor = Herramientas.valor;
        //System.out.println(Herramientas.columna);
        String linea;
        String ruta = f.ruta.replaceAll("Temporales", "") + "/Resultado";
        //System.out.println(ruta);
        pathFinal = new File(ruta);
        pathFinal.mkdir();
        BufferedReader archivoTemp;
        //File datosFiltrados = new File(ruta,nombreFiltrado(f.nombre,valor));
        File datosFiltrados = new File(ruta,"Resultado.csv");
        try {
            archivoTemp = new BufferedReader(new FileReader(f.archivo));
            try{
            while((linea = archivoTemp.readLine()) != null){

               datos = new BufferedWriter(new FileWriter(datosFiltrados,true));
               
               String[] campos = linea.split(",");
               //System.out.println(linea);
               if(compararValor(valor, campos, columna)){
                   //System.out.println(linea);
                   agregar(linea);
               } 
              datos.close();
            }
            archivoTemp.close();
            }
            catch (IOException ex) 
            {
                System.out.println("Archivo para escribir no encontrado.");
            } 
        }
        catch (FileNotFoundException ex) {
            System.out.println("Archivo para escribir no encontrado.");
        }  
        finally{

        }}
    }
    public synchronized void agregar(String linea)
    {
        try
        {
            datos.append(linea+"\n");
        }
        catch(Exception E)
        {

        }
    }
}
