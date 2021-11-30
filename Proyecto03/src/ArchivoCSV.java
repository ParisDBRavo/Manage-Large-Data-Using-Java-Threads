package proyecto;

import java.io.File;

public class ArchivoCSV {
    private static char SEPARADOR_DEFAULT = ',';
    
    protected File archivo;

    protected String nombre;
    protected String ruta;
    
    protected int ejex;
    protected int ejey;
    protected char separador;
    private boolean lectura;
    private boolean escritura;

    
    
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
        System.out.println("\t Nombre del archivo: \t\t " + nombre);
        System.out.println("\t Separador de campo: \t\t " + separador);        
        System.out.println("\t Número de renglones: \t\t " + ejey);
        System.out.println("\t Número de columnas: \t\t " + ejex);
        System.out.println("_________________________________________________\n");
        
    }   

}
