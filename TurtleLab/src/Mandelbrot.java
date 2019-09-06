

import org.apache.commons.math3.complex.Complex;

import java.awt.*;

/**
 * @author derek
 * @version 1.0
 * @date 9/6/2019
 * Generates a mandelbrot set and puts it into an array of colors for PaintingPrinter to print out
 */
public class Mandelbrot {
    //initialize values
    private int dimensionX = 600, dimensionY = 400, maxIter = 300;
    private double realStart = -2, realEnd = 1, imStart = -1, imEnd = 1;
    //used to update the center of the plot
    //constructors
    public Mandelbrot(){
    }
    public Mandelbrot(double factor, int maxI){
        dimensionX = (int)(Math.round((double)dimensionX * factor));
        dimensionY = (int)(Math.round((double)dimensionY * factor));
        maxIter = maxI;
    }
    //methods
    /**
     * moves the plot of the graph
     * @param dilate factor by which you would like to zoom the image (higher=closer zoom)
     * @param translateX real unit count by which you would like to move along the x-axis
     * @param translateY imaginary unit count by which you woule like to move along the y-axis
     */
    public void mandelTranslate(double dilate, double translateX, double translateY){
        double translateXd = translateX;
        double translateYd = translateY;
        realStart /= dilate;
        realEnd /= dilate;
        imStart /= dilate;
        imEnd /= dilate;
        realStart += translateXd;
        realEnd += translateXd;
        imStart -= translateYd;
        imEnd -= translateYd;

    }

    /**
     * increases or decreases resolution based on factor
     * @param factor factor by which you would like to change the resolution
     */
    public void resolutionChange(double factor){
        dimensionX = (int)Math.round((double)dimensionX * factor);
        dimensionY = (int)Math.round((double)dimensionY * factor);
    }

    /**
     * generates a complex number based on cartesian coordinates from an x and y coordinates based on java's system.
     * @param x x coordinate (java system)
     * @param y y coordinate (java system)
     * @return
     */
    public Complex complexMaker(int x, int y){
        return new Complex((realStart + (((double)x / (double)dimensionX) * (realEnd - realStart))), (imStart + (((double)y / (double)dimensionY) * (imEnd - imStart))));
    }
    /**
     * Checks if a complex number is part of the mandelbrot set.
     * @param c complex number to check
     * @return the amount of iterations until escape, or if it is bound
     * source for algorithm: https://www.codingame.com/playgrounds/2358/how-to-plot-the-mandelbrot-set/mandelbrot-set
     * source for my understanding of how the set is generated:https://www.youtube.com/watch?v=NGMRB4O922I&feature=youtu.be
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

    /**
     * generates a color based on the amount of iterations required to escape boundary
     * @param grade the amount of iterations
     * @return a color based on grade.
     */
    private Color colorGen(int grade){
        if (grade == maxIter) return Color.BLACK;
        else {
            float h = ((float)(grade) / (float)maxIter); //fraction used to determine hue
            Color out = Color.getHSBColor(h, 1, 1);
            return out;
        }
    }

    /**
     * generates a color matrix based on the parameters of the mandelbrot set from constructors
     * @return a matrix that represents every pixel's color
     */
    private Color[][] mandelGen(){
        //initialize output array
        Color[][] out = new Color[dimensionX][dimensionY];
        //fill output array
        for(int i = 0; i < dimensionX; i++){
            for(int j = 0; j < dimensionY; j++){
                out[i][j] = colorGen(mandelFunc(complexMaker(i, j)));
            }
        }
        return out;
    }

    /**
     * refreshes the display
     * @param in1 the Mandelbrot object to use
     * @param in2 the PaintingPrinter object to use
     */
    public static void mandelPrint(Mandelbrot in1, PaintingPrinter in2){
        in2.paint(in1.mandelGen());
    }
}