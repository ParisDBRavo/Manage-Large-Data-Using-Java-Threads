

import java.io.File;

public class BuscarArchivo  {
    
//SOFI: Esto es modificado a partir de la clase CSV de Isra
    
    
    private BuscarArchivo(){   }
   
    public static boolean Buscar(String ruta, String nombre) {
        File f = new File(ruta, nombre);
       
        if (f.exists()) {
            if (f.isFile()) {
                if (f.canRead()) {
                    return true;
                } else {
                    System.out.println("El archivo no tiene permisos de lectura, vuele a intentarlo..."); 
                }
            } else {
                System.out.println("El nombre que escribiste perteece a un directorio, vuele a intentarlo..."); 
            }
        } else {
            System.out.println("El archivo que buscas no existe, vuele a intentarlo..."); 
        }
        return false;
    }
}
