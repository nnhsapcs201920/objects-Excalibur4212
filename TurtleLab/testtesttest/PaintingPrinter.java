import java.awt.Color;

/**
 * @author derek zhang
 * @version 1.0
 */
public class PaintingPrinter{
    Turtle hsb = null;
    Turtle k = null;
    //constructors
    public PaintingPrinter(){
        World x = new World(1600, 1200);
        hsb = new Turtle(x);
        hsb.setWidth(0);
        hsb.setHeight(0);
        hsb.setVisible(false);
        hsb.setPenWidth(1);
        k = new Turtle(x);
        k.setVisible(false);
        k.setPenWidth(1);
        k.setWidth(0);
        k.setHeight(0);
    }
    public PaintingPrinter(World x){
        hsb = new Turtle(x);
        hsb.setWidth(0);
        hsb.setHeight(0);
        hsb.setVisible(false);
        hsb.setPenWidth(1);
        k = new Turtle(x);
        k.setVisible(false);
        k.setWidth(0);
        k.setHeight(0);
        k.setPenWidth(1);
    }
    //methods
    /**
     * moves turtle object to a point
     * @param obj target turtle object to move
     * @param x x-coordinate of desired point
     * @param y y-coordinate of desired point
     */
    public void goTo(Turtle obj, int x, int y){
        int x1 = obj.getXPos();
        int y1 = obj.getYPos();
        obj.penUp();
        obj.setHeading(0);
        int dx = x-x1;
        int dy = y-y1;
        //translate along x
        obj.turnRight();
        if (dx>0) obj.forward(dx);
        else obj.backward(dx);
        //translate along y
        obj.turnLeft();
        if(dy>0) obj.forward(dy);
        else obj.backward(dy);
    }

    /**
     * paints a picture using a black and color turtle, based on the input matrix.
     * @param in array of all pixels and the color that they are supposed to be
     */
    public void paint(Color[][] in){
        for(int i = 0; i < in.length; i++){
            for(int j = 0; j<in[i].length; j++){
                if(in[i][j] == Color.BLACK){
                    goTo(k, i, j);
                    k.penDown();
                    k.penUp();
                } else{
                    hsb.setPenColor(in[i][j]);
                    goTo(hsb, i, j);
                    hsb.penDown();
                    hsb.penUp();
                }
            }
        }
    }
}