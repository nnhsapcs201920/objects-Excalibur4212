import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        //declare variables
        String documentation = "-help- \nUsage: type in the phrase excluding the colon  \n  exit: exits the program \n  scale: scales the resolution of the canvas \n   x: moves the fractal along x axis (real units so small numbers)\n    y: moves the fractal along y axis (imaginary units so small numbers) \n zoom: zooms the fractal in or out \n   maxIterations: changes the amount of maximum iterations before bound status is decided. Higher is more accurate, but is slower, and may not look as good, and it is simply up to taste to choose a value."; //what the help command prints
        int intIn = 0; //handles integer inputs
        double doubleIn = 0; //handles double inputs
        Scanner kbReader = new Scanner(System.in); //keyboard scanner
        String in = ""; //handles raw inputs
        String in1 = ""; //handles raw inputs nested within other sections involving raw inputs as to not accidentally overwrite something.
        boolean defaultOrNot = true; //decides whether to use default constructors or not
        Mandelbrot x = new Mandelbrot(); //creates new object of class Mandelbrot
        PaintingPrinter y = new PaintingPrinter();  //creates new object of class PaintingPrinter
        MovementUtils z = new MovementUtils(x, y); //creates new object of type MovementUtils
        System.out.println("Welcome to Derek's mandelbrot set application. We suggest that you set the screen up to show multiple windows if you wish to make changes to the plot. Press enter to start");
        kbReader.nextLine(); //allow for user to wait to start
        //default or not
        while(true){
            System.out.println("Would you like to use default values or specify some your own? (y for default/n)");
            in = kbReader.nextLine();
            if (in.equalsIgnoreCase("Y")) break;
            else if (in.equalsIgnoreCase("N")){
                defaultOrNot = false;
                break;
            } else System.out.println("Invalid input registered. Please try again.");
        }
        if (defaultOrNot); //objects already declared as default
        else{
            //ask for user input on constructors
            while(true){ //factor of resolution increase
                System.out.println("By what factor would you like to change the default resolution (600x400) by (insert positive double)");
                in = kbReader.nextLine();
                try{
                    doubleIn = Double.parseDouble(in);
                    if(doubleIn>0)break;
                }catch(Exception e){
                }
                System.out.println("Improper input detected. please try again, making sure to check your signs. If this doesn't work and you inputted a positive integer, please try again as (your integer).0");
            }
            while(true){ //max number of iterations
                System.out.println("To how far shall we calculate our Mandelbrot set (higher integers are slower but more accurate, input a positive integer)");
                in = kbReader.nextLine();
                try{
                    intIn = Integer.parseInt(in);
                    if (intIn > 0) break;
                }catch(Exception e){
                }
                System.out.println("Improper input detected. please try again. Please double check signs if input seems valid");
            }
            x = new Mandelbrot(doubleIn, intIn);
            y = new PaintingPrinter(doubleIn);
            Mandelbrot.mandelPrint(x, y);
        }
        //start the editing mode
        System.out.println("Type exit after a \">\" to terminate the program. Entering editing mode, type help for a list of commands, it is suggested to scale the resolution down first to reduce lag, then rescale it afterwards:");
        while(true){
            System.out.println(">");
            in = kbReader.nextLine();
            if(in.equalsIgnoreCase("exit")) break;
            else if(in.equalsIgnoreCase("help")) System.out.println(documentation);
            else if(in.equalsIgnoreCase("scale")){
                //asks for required bits of scale command.
                while(true){
                    System.out.println("Please input the factor by which you would like to change the resolution. (positive double)");
                    in1 = kbReader.nextLine();
                    try{
                        doubleIn = Double.parseDouble(in1);
                        if(doubleIn>0)break;
                    }catch(Exception e){
                    }
                    System.out.println("Improper input detected. please try again, making sure to check your signs. If this doesn't work and you inputted a positive integer, please try again as (your integer).0");
                }
                z.scale(doubleIn);
            }
            else if (in.equalsIgnoreCase("x")) {
                //asks for required bits of x command
                while (true) {
                    System.out.println("Type in the number of REAL units (not pixels) that you wish to translate the x-axis by (any double)");
                    in1 = kbReader.nextLine();
                    try {
                        doubleIn = Double.parseDouble(in1);
                        break;
                    } catch (Exception e) {
                        System.out.println("Improper input detected; please try again.");
                    }
                }
                z.x(doubleIn);
            }
            else if (in.equalsIgnoreCase("y")) {
                //asks for required bits of y command
                while (true) {
                    System.out.println("Type in the number of REAL units (not pixels) that you wish to translate the y-axis by (any double)");
                    in1 = kbReader.nextLine();
                    try {
                        doubleIn = Double.parseDouble(in1);
                        break;
                    } catch (Exception e) {
                        System.out.println("Improper input detected; please try again.");
                    }
                }
                z.y(doubleIn);
            }
            else if(in.equalsIgnoreCase("zoom")){
                //asks for required bits of zoom command.
                while(true){
                    System.out.println("Please input the factor by which you would like to zoom in or out. (positive double)");
                    in1 = kbReader.nextLine();
                    try{
                        doubleIn = Double.parseDouble(in1);
                        if(doubleIn>0)break;
                    }catch(Exception e){
                    }
                    System.out.println("Improper input detected. please try again, making sure to check your signs. If this doesn't work and you inputted a positive integer, please try again as (your integer).0");
                }
                z.zoom(doubleIn);
            }
            else if(in.equalsIgnoreCase("maxiterations")){
                //asks for required bits of maxiterations command.
                while(true){
                    System.out.println("Input the new number of maximum iterations (positive integer)");
                    in1 = kbReader.nextLine();
                    try{
                        intIn = Integer.parseInt(in1);
                        if(intIn>0) break;
                    }catch(Exception e){}
                    System.out.println("Invalid input detected, please try again.");
                }
                x.setMaxIter(intIn);
            }
            else System.out.println(in+" is not a recognizable command. Press help for commands or try again.");
        }
        kbReader.close();
        System.exit(0);
    }
}
