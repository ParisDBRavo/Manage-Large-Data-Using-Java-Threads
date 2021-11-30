package proyecto;

import java.io.File;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;


public class ArchivoCSV {

    //private static final String PCIC_HOME = "C://Users/Caronte/Documents/PCIC/";

    private static char SEPARADOR_DEFAULT = ',';
    
    protected File archivo;

    protected String nombre;
    protected String ruta;
    String[] nombreSegmentado;// = archivo.getNombre().split("\\.");
    protected int ejex;
    protected int ejey;
    private final Map<Integer, String> columnas;
    protected char separador;
    private boolean lectura;
    private boolean escritura;
    private Date ultimaFecha;
    
    

    public ArchivoCSV(String nombre) {
        archivo = new File(ruta, nombre);
        separador = SEPARADOR_DEFAULT;
    }

    public ArchivoCSV(String nombre, char separador) {
        this(nombre);
        this.separador = separador;
        this.setAtributos();
    }
    
    public ArchivoCSV(String nombre, String ruta) {
        this.archivo= new File(ruta, nombre);
        this.separador = SEPARADOR_DEFAULT;
        this.nombre = nombre;
        this.ruta = ruta;
        this.setAtributos();
    }

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
        System.out.println("Leyendo archivo...");
        System.out.println("_________________________________________________");
        System.out.println("\t Archivo origen: \t\t " + nombre);
        System.out.println("\t Separador de campo: \t\t " + separador);        
        System.out.println("\t Total de registros: \t\t " + ejey);
        System.out.println("\t Total de columnas: \t\t " + ejex);
        System.out.println("_________________________________________________\n");
        
    }

    public void setCabecera(String[] arregloCampos) {
        int indice = 0;
        for (String campoActual : arregloCampos) {
            ++indice;
            this.columnas.put(indice, campoActual);
        }
    }

    public void getHeader() {//Imprime header           
        System.out.println("Campos del archivo:");
        System.out.println("_________________________________________________\n");
        for (int indice : columnas.keySet()) {
            System.out.println("\t[" + indice + "| " + columnas.get(indice) + ", "); 
        }
        System.out.println("_________________________________________________\n");
    }

    {
        this.columnas = new HashMap<>();
    }

}
