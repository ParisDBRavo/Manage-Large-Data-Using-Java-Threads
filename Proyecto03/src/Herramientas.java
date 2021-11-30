package proyecto;


public class Herramientas {
    public static String directorioActual()
    {
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir:" + currentDir);
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
}