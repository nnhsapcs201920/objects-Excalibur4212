

import org.apache.commons.math3.complex.Complex;

import java.awt.*;

/*
author Excalibur4212
date 9/6/2019
usage: a bunch of utilities to print out mandelbrot sets
 */
public class Mandelbrot {
    //initialize values
    private int centerX = 300, centerY = 200, dimensionX = 600, dimensionY = 400, maxIter = 300;
    private double realStart = -2, realEnd = 1, imStart = -1, imEnd = 1;
    //used to update the center of the plot
    private void setC(){
        centerX = (int)Math.floor((double)dimensionX * 2.0/3.0);
        centerY = (int)Math.floor((double)dimensionY / 2.0);
    }
    //constructors
    public Mandelbrot(){
    }
    public Mandelbrot(double factor, int maxI){
        dimensionX = (int)(Math.round((double)dimensionX * factor));
        dimensionY = (int)(Math.round((double)dimensionY * factor));
        setC();
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
        setC();
    }
    /*
    generates complex number from position on plane
    */
    public Complex complexMaker(int x, int y){
        return new Complex((realStart + (((double)x / (double)dimensionX) * (realEnd - realStart))), (imStart + (((double)y / (double)dimensionY) * (imEnd - imStart))));
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
            float h = ((float)(grade) / (float)maxIter); //fraction used to determine hue
            Color out = Color.getHSBColor(h, 1, 1);
            return out;
        }
    }
    /*
    Generates an array of colors and positions for the turtles to paint
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
    /*
    Sends result from mandelGen to PaintingPrinter
     */
    public static void mandelPrint(Mandelbrot in1, PaintingPrinter in2){
        in2.paint(in1.mandelGen());
    }
}