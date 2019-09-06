public class MovementUtils {
    private Mandelbrot mandel = null;
    private PaintingPrinter printer = null;
    //constructor
    public MovementUtils(Mandelbrot x, PaintingPrinter y){
        mandel = x;
        printer = y;
    }
    //methods
    /**
     * changes resolution by user-specified factor
     * @param factor factor by which you would like to increase/decrease resolution
     */
    public void scale(double factor){
        mandel.resolutionChange(factor);
        printer.newW((int)((double)printer.getW().getWidth()*factor), (int)((double)printer.getW().getHeight()*factor));
        Mandelbrot.mandelPrint(mandel, printer);
    }
    /**
     * translates the given mandelbrot right
     * @param amt amount of real units you would like to translate by
     */
    public void x(double amt){
        mandel.mandelTranslate(1, amt, 0);
        Mandelbrot.mandelPrint(mandel, printer);
    }
    /**
     * translates the given mandelbrot up
     * @param amt amount of real units you would like to translate by
     */
    public void y(double amt){
        mandel.mandelTranslate(1, 0, amt);
        Mandelbrot.mandelPrint(mandel, printer);
    }
    /**
     * zooms the mandelbrot
     * @param factor factor by which you would like to zoom in
     */
    public void zoom(double factor){
        mandel.mandelTranslate(factor, 0, 0);
        Mandelbrot.mandelPrint(mandel, printer);
    }
}
