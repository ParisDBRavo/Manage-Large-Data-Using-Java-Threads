public class Num_Procesadores 
{
    public static int numPros()
    {
        
        int CPUs = Runtime.getRuntime().availableProcessors();
	    System.out.println("\n Numero de CPUs: \t " + CPUs );
        return CPUs;
    }   
}
