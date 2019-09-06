

import org.apache.commons.math3.complex.Complex;

import java.awt.*;

/*
@author = Excalibur4212

usage - used to define the bounds of a mandelbrot set plot, and generate a matrix of colors for a Turtle to print.
 */
public class MandelUtils {
    //initialize values that can be changed
    private int centerX=640, centerY=360, dimensionX=1280, dimensionY=720, maxIter = 80;
    //initialize constants (axes on imaginary axis must stay fixed in order for the image to be the same no matter the screen resolution)
    private final double REAL_START = -2, REAL_END = 1, IM_START = -1, IM_END = 1;
    //used to update the center of the plot
    private void setC(){
        centerX = (int)Math.floor((double)dimensionX*2.0/3.0);
        centerY = (int)Math.floor(dimensionY/2);
    }
    //constructors
    public MandelUtils(){
    }
    public MandelUtils(int maxI, int dimX, int dimY){
        dimensionX = dimX;
        dimensionY = dimY;
        setC();
        maxIter = maxI;
    }
    //methods
    /*
    generates complex number from position on plane
     */
    public Complex complexMaker(int x, int y){
        x = x-centerX;
        y = centerY-y;
        double real;
        double imaginary;
        if(x<0) real = (((double)-x)/(centerX))*REAL_START;
        else real = (((double)x)/(centerX))*REAL_END;
        if(y<0) imaginary = (((double)-y)/(centerY))*IM_START;
        else imaginary = (((double)y)/(centerY))*IM_END;
        Complex out = new Complex(real, imaginary);
        return out;//new Complex((REAL_START + (((double)x/(double)dimensionX)*(REAL_END - REAL_START))), (IM_START + (((double)y/(double)dimensionY)*(IM_END-IM_START))));
    }
    /*function that determines whether number is within set or not (this is the only section that isn't my code originally)
    source for algorithm: https://www.codingame.com/playgrounds/2358/how-to-plot-the-mandelbrot-set/mandelbrot-set
    source for my understanding of how the set is generated:https://www.youtube.com/watch?v=NGMRB4O922I&feature=youtu.be
     */
    private int mandelFunc(Complex c){
        //complex c is a complex number that is constantly added to the square of 0
        Complex z = new Complex(0); //0 as a complex number
        int i = 0; //iterator
        while(z.abs() <= 2 && i < maxIter){ //define the parameters of the recursive. This will see if the function is bounded within maxIter iterations under two.
            z = (z.multiply(z)).add(c); //this is the function: z(n) = z(n-1)^2+c
            i++;
        }
        return i; //return result
    }
    /*
    creates a color based max iterations
     */
    private Color colorGen(int grade){
        if (grade == maxIter) return Color.BLACK;
        else {
            float h = ((float)(maxIter-grade) / (float)maxIter); //fraction used to determine hue
            Color out = Color.getHSBColor(h, 1, 1);
            return out;
        }
    }
    /*
    Generates an array of colors and positions for the turtles to paint
     */
    private Color[][] mandelGen(){
        //intiialize output array
        Color[][] out = new Color[dimensionX][dimensionY];
        //initialize complex number array
        Complex[][] c = new Complex[dimensionX][dimensionY];
        //initialize int array
        int[][] grade = new int[dimensionX][dimensionY];
        //fill complex number array
        for(int i = 0; i < dimensionX; i++){
            for(int j = 0; j < dimensionY; j++){
                c[i][j] = complexMaker(i, j);
                grade[i][j] = mandelFunc(c[i][j]); //apply escape time algorithm to complex number
                System.out.println(grade[i][j]);
                out[i][j] = colorGen(grade[i][j]);
            }
        }
        return out;
    }
    /*
    Sends result from mandelGen to PaintingPrinter
     */
    public static void mandelPrint(int maxI, int dimX, int dimY){
        World z = new World(dimX, dimY);
        PaintingPrinter y = new PaintingPrinter(z);
        MandelUtils x = new MandelUtils(maxI, dimX, dimY);
        y.paint(x.mandelGen());
    }
    public static void mandelPrint(){
        World z = new World(1280, 720);
        PaintingPrinter y = new PaintingPrinter(z);
        MandelUtils x = new MandelUtils();
        y.paint(x.mandelGen());
    }
}