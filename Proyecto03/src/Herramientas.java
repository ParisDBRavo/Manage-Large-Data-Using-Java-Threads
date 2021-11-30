import java.util.Scanner;
public class Herramientas {
    public static String valor;
    public static int columna;
    public static String directorioActual()
    {
        String currentDir = System.getProperty("user.dir");
        //System.out.println("Current dir:" + currentDir);
        return currentDir;
    }
    
    public static int contarPalabras(String palabra)
    {
        String[] s = palabra.split(",");
        return s.length -1;
    }
    
    public static void utilidad(int numeroProcesadores, int ejey)
    {
        if(2*numeroProcesadores>ejey)
        {
            System.out.println("Tu problema no vale la pena ser resuelto por este método, son muy pocos datos");
            System.exit(0);
        }
    }
    public static int inicio(int i, int n)
    {
        return n*i;
    }
    public static int fin(int i, int n)
    {
        int z= (n+1)*i;
        return z;
    }
    public static String pedirValor(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escribe el valor que debe tener el dato a filtrar: ");
        valor = entrada.nextLine();
        return valor;
    }
    public static int pedirColumna(int ejex){
        boolean seguirPreguntando = true;
        columna=0;
          while(seguirPreguntando == true)
          {
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
}