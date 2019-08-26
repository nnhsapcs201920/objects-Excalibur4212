import java.awt.Color;

public class TurtleDemo
{
    public static void makeAwesomeTurtlePattern()
    {
        World ocean = new World();
        Turtle crush = new Turtle(ocean);
        crush.turn(18); //makes a star
        for(int i = 0; i < 5; i++){
            Color x = new Color(186, 218, 85);
            crush.setPenColor(x);
            crush.setPenDown(true);
            crush.forward(50);
            crush.turn(36+180);
        }
    }
    public static void drawLine(){
        /*
         * objects are entities in a program
         * objects have properties (attributes)
         * objects are manipulated by invoking methods.
         * 
         * ocean and crush are variables that reference objects
         * 
         * Classes describe a collection of objects
         *  all objects of a class have the smae behavior (methods)
         *  and they have the same types of properties (but they may have different values)
         *  
         *  world and turtle are classes
         */
        World ocean = new World();
        /*
         * we use the new operator to construct, instantiate an object 
         * 
         * the class of the object is specified immediately after the new operator, like turtle.
         * 
         * if we have to pass additional information to construct the object, arguments are specified in parentheses after the class.
         * 
         * 
         */
        Turtle crush = new Turtle(ocean);
        /*
         * variable store values to be used later.
         * variables have a type, like int, they have a name, like width, and they have a value, like 20.
         * 
         *
         */
        int width; //declaring a variable
        width = 20; //assigning a value to a variable
        //order matters
        /*
         * java has several primitive data types
         * 
         * boolean holds a value of true or false
         * int holds an integer number
         * double holds a real number (double-precision floating point)
         * char hold s as single character
         */
        //here is a  boolean
        boolean isSummer = true;
        //here is a double
        double salesTaxRate = 0.075;
        //here is a char
        char letter = 'c';
    }
}
