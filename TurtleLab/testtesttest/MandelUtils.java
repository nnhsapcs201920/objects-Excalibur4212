

import org.apache.commons.math3.complex.Complex;

import java.awt.*;

/*
@author = Excalibur4212

usage - used to define the bounds of a mandelbrot set plot, and generate a matrix of colors for a Turtle to print.
 */
public class MandelUtils {
    //initialize values that can be changed
    private int centerX=800, centerY=600, dimensionX=1600, dimensionY=800, maxIter = 100;
    //initialize constants (axes on imaginary axis must stay fixed in order for the image to be the same no matter the screen resolution)
    private final int REAL_START = -2, REAL_END = 1, IM_START = -1, IM_END = 1;
    //used to update the center of the plot
    private void setC(){
        centerX = (int)Math.floor(dimensionX/2);
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
    //accessor methods
    public void setMaxIter(int maxIter) {
        this.maxIter = maxIter;
    }
    public int getMaxIter() {
        return maxIter;
    }
    //methods
    /*
    generates complex number from position on plane
     */
    private Complex complexMaker(int x, int y){
        x = x-centerX;
        y = centerY-y;
        double real;
        double imaginary;
        if(x<0) real = ((-x)/(centerX))*REAL_START;
        else real = ((x)/(centerX))*REAL_END;
        if(y<0) imaginary = ((-y)/(centerY))*IM_START;
        else imaginary = ((y)/(centerY))*IM_END;
        Complex out = new Complex(real, imaginary);
        return out;
    }
    /*function that determines whether number is within set or not
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
        float h = (grade/maxIter); //fraction used to determine hue
        Color out = Color.getHSBColor(h, 1, 1);
        return out;
    }
    /*
    Generates an array of colors and positions for the turtles to paint
     */
    public Color[][] mandelGen(){
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
            }
        }
        //fill int array
        for(int i = 0; i < dimensionX; i++){
            for(int j = 0; j < dimensionY; j++){
                grade[i][j] = mandelFunc(c[i][j]); //apply escape time algorithm to complex number
            }
        }
        //fill output array
        for(int i = 0; i < dimensionX; i++){
            for(int j = 0; j < dimensionY; j++){
                out[i][j] = colorGen(grade[i][j]);
            }
        }
        return out;
    }
}