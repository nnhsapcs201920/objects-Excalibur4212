
/**
 * Write a description of class HelloPrinter here (e.g., helloPrinter).
 * in general, every source file (e.g. Helloprinter.java) contains one class (e.g., HelloPrinter)
 * @author dereickius zhanganius
 * the source filename much match the class name
 * by convention, class names start with an uppercase letter.
 * @version 08/21/2019
 */
public class HelloPrinter
{
    /*
     * a class contains methods.
     * methods are similar to functions in python
     * most java applications contain a class with a main method.
     * the main method is executed when the application starts
     */
    public static void main (String[] args){
        /*
         * a method contains statements
         * statements may invoke other methods (e.g. println)
         * in general, methods are invoked on objects (e.g. System.out)
         * when invoking a method, arguments are passed in parentheses (e.g., "Hello, World!")
         */
        //this is a single-line comment
        System.out.println("hello world"); //comment at the end of a line
        /*
         * Identifiers are any combination of: 
         *      digits(but not as the first character)
         *      dollar signs
         * these are various identifiers:
         */
        int y, x2, x_y, x$;
        
        // this is not a valid identifier:
        //int 2y;
        /*
         * identifiers are case sensitive, meaning case matters.
         * 
         * these are three different identifiers:
         */
        String box, BOX, bOx;
        
        /*
         * By convention, constants are all uppercase.
         *      Use an underscore to separate words.
         */
        final int SPEED_OF_LIGHT = 300000000;
        
        /*
         * by convention, most other identifiers start with a lowercase letter. Subsequent words start with an uppercase letter. (CamalCase)
         * 
         */
        String firstName;
    }
}
