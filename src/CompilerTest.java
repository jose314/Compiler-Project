public class CompilerTest
    {
    static String operation = "compile" ;
    static String localDir = System.getProperty("user.dir") ;
    static String filePath = localDir + "/scannertest.txt" ;
    static String flags = "ix" ;
    public static void main (String[] args)
        {
        Python python = new Python (operation , filePath , flags) ;
        Pascal pascal = new Pascal (operation , filePath , flags) ;
        }
    }
