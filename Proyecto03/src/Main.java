package proyecto;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String nombreArchivo;//S
        String ruta;//S
        
        /* ---------Directorio y nombre fijos (mientras trabajamos)--------*/
         //----------------------------------------------------------------
        ruta = System.getProperty("user.dir");//S
        nombreArchivo = "Cryptocurrencies_to_USD_default_day_2021-01-09.csv";//S
        //-------------------------------------------------------------------*/
        
        //S: PARA PEDIR ARCHIVO:
        /*//----------------------------------------------------------------
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
        
        LeeryCrear.leer(nombreArchivo, ruta);
//        ArchivoCSV f = new ArchivoCSV(nombreArchivo, ruta);//crea un objeto tipo ArchivoCSV
//        
//        f.setEjex(CalcularDimensiones.calcularX(f));
//        f.setEjey(CalcularDimensiones.calcularY(f));
//        System.out.println("Después de calcular las dimensiones, tenemos:");
//        f.imprimirAtributos();
//        
//        Particion particion = new Particion(f);
        
        String nombreTemporal = "Cryptocurrencies_to_USD_default_day_2021-01-09_11.csv";
        String rutaTemporal = "D:\\Documents\\POSGRADO\\Master\\Prog Av\\PROYECTO\\Proyecto\\Temporales";
        
        ArchivoCSV archivoTemporal = new ArchivoCSV(nombreTemporal, rutaTemporal);
        Filtrado.filtrarArchivoTemporal(archivoTemporal);
       
    }

}
