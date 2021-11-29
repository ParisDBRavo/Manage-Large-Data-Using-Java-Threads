
import java.io.File;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.util.Scanner;

public class ArchivoCSV {

    /**
     * Variables de Clase
     *
     * Modulo de variables globales tipo constantes
     */
    private static final String PCIC_HOME = "C://Users/Caronte/Documents/PCIC/";

    private static final char SEPARADOR_DEFAULT = ',';

    /**
     * Variables de Instancia *
     */
    private final File archivo;

    private String nombre;
    private String ruta;
    String[] nombreSegmentado;// = archivo.getNombre().split("\\.");
    private int ejex;
    private int ejey;
    private final Map<Integer, String> columnas;
    private char separador;
    private boolean lectura;
    private boolean escritura;
    private Date ultimaFecha;
    
    

    public ArchivoCSV(String nombre) {
        archivo= new File(ruta, nombre);
        separador = SEPARADOR_DEFAULT;
    }

    public ArchivoCSV(String nombre, char separador) {
        this(nombre);
        this.separador = separador;
        this.setAtributos();
    }
    
    public ArchivoCSV(String nombre, String ruta) {
        this(nombre);
        this.ruta = ruta;
        this.setAtributos();
    }
    
//    public static void pedirArchivoCSV(){
//        boolean archivoEncontrado = false;
//        while(archivoEncontrado = false){
//            Scanner entrada = new Scanner(System.in);
//            System.out.println("Ingresa la ruta del archivo: ");
//            String ruta = entrada.nextLine();
//            System.out.println("Ingresa el nombre del archivo: ");
//            String nombre = entrada.nextLine();
//            archivoEncontrado = BuscarArchivo.Buscar(ruta, nombre);   
//        }
//    }

    public File getArchivoCSV() {
        return archivo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public char getSeparadorCampo() {
        return separador;
    }

    public void setEjey(int ejey) {
        this.ejey = ejey;
    }

    public int getEjey() {
        return ejey;
    }

    public void setEjex(int ejex) {
        this.ejex = ejex;
    }

    public int getEjex() {
        return ejex;
    }

    private void setAtributos() {
        nombre = archivo.getName();
        lectura = archivo.canRead();
        escritura = archivo.canWrite();
    }

    public void imprimirAtributos() {
        System.out.println("###############################");
        System.out.println("# Propiedades del archivo CSV #");
        System.out.println("#-----------------------------#");
        System.out.println("\t Archivo origen: \t\t " + nombre);
        System.out.println("\t Separador de campo: \t\t " + separador);        
        System.out.println("\t Total de registros: \t\t " + ejey);
        System.out.println("\t Total de columnas: \t\t " + ejex);
    }

    public void setCabecera(String[] arregloCampos) {
        int indice = 0;
        for (String campoActual : arregloCampos) {
            ++indice;
            this.columnas.put(indice, campoActual);
        }
    }

    public void getCabecera() {
        // Imprimie la cabecera del archivo CSV             
        System.out.println("#---------- Cabecera del archivo CSV ----------#");
        for (int indice : columnas.keySet()) {
            System.out.println("\t[" + indice + "] " + columnas.get(indice) + ", "); 
        }
        System.out.println("#----------Fin de la cabecera ---------------#\n");
    }

    {
        this.columnas = new HashMap<>();
    }

}
