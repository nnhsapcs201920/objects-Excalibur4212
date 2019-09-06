

import org.apache.commons.math3.complex.Complex;

import java.awt.*;

/*
@author = Excalibur4212

usage - used to define the bounds of a mandelbrot set plot, and generate a matrix of colors for a Turtle to print.
 */
public class Mandelbrot {
    //initialize values
    private int centerX=300, centerY=200, dimensionX=600, dimensionY=400, maxIter = 200;
    private double realStart = -2, realEnd = 1, imStart = -1, imEnd = 1;
    //used to update the center of the plot
    private void setC(){
        centerX = (int)Math.floor((double)dimensionX*2.0/3.0);
        centerY = (int)Math.floor(dimensionY/2);
    }
    //constructors
    public Mandelbrot(){
    }
    public Mandelbrot(int maxI, int dimX, int dimY){
        dimensionX = dimX;
        dimensionY = dimY;
        setC();
        maxIter = maxI;
    }
    public Mandelbrot(int maxI, int factor){
        dimensionX = dimensionX*factor;
        dimensionY = dimensionY*factor;
        setC();
        maxIter = maxI;
    }
    public Mandelbrot(int maxI, int dimX, int dimY, double reStart, double reEnd, double imaginaryStart, double imaginaryEnd){
        dimensionX = dimX;
        dimensionY = dimY;
        setC();
        maxIter = maxI;
        realStart = reStart;
        realEnd = reEnd;
        imStart = imaginaryStart;
        imEnd = imaginaryEnd;
    }
    //accessors
    public int getDimensionX() {
        return dimensionX;
    }
    public int getDimensionY() {
        return dimensionY;
    }
    public int getMaxIter() {
        return maxIter;
    }
    public void setMaxIter(int maxIter) {
        this.maxIter = maxIter;
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
        dimensionX = (int)Math.round((double)dimensionX*factor);
        dimensionY = (int)Math.round((double)dimensionY*factor);
    }
    /*
    generates complex number from position on plane
    */
    public Complex complexMaker(int x, int y){
        //x = x-centerX;
        //y = centerY-y;
        double real;
        double imaginary;
        if(x<0) real = (((double)-x)/(centerX))* realStart;
        else real = (((double)x)/(centerX))* realEnd;
        if(y<0) imaginary = (((double)-y)/(centerY))* imStart;
        else imaginary = (((double)y)/(centerY))* imEnd;
        Complex out = new Complex(real, imaginary);
        return new Complex((realStart + (((double)x/(double)dimensionX)*(realEnd - realStart))), (imStart + (((double)y/(double)dimensionY)*(imEnd - imStart))));
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
        //intiialize output array
        Color[][] out = new Color[dimensionX][dimensionY];
        //initialize complex number array
        Complex[][] c = new Complex[dimensionX][dimensionY];
        //initialize int array
        int[][] grade = new int[dimensionX][dimensionY];
        //fill complex number array
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
    public static void mandelPrint(int maxI, int dimX, int dimY){
        World z = new World(dimX, dimY);
        PaintingPrinter y = new PaintingPrinter(z);
        Mandelbrot x = new Mandelbrot(maxI, dimX, dimY);
        y.paint(x.mandelGen());
    }
    public static void mandelPrint(Mandelbrot in){
        World z = new World(in.getDimensionX(), in.getDimensionY());
        PaintingPrinter y = new PaintingPrinter(z);
        y.paint(in.mandelGen());
    }
    public static void mandelPrint(Mandelbrot in1, PaintingPrinter in2){
        in2.paint(in1.mandelGen());
    }
    public static void mandelPrint(){
        World z = new World(600, 400);
        PaintingPrinter y = new PaintingPrinter(z);
        Mandelbrot x = new Mandelbrot();
        y.paint(x.mandelGen());
    }
}