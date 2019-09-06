import java.awt.Color;

/**
 * @author derek zhang
 * @version 1.0
 */
public class PaintingPrinter{
    Turtle hsb = null;
    Turtle k = null;
    World w = null;
    //constructors
    public PaintingPrinter(){
        w = new World(600, 400);
        hsb = new Turtle(w);
        hsb.setVisible(false);
        hsb.setPenWidth(1);
        k = new Turtle(w);
        k.setVisible(false);
        k.setPenWidth(1);
    }
    public PaintingPrinter(double factor){
        w = new World((int)(Math.round(600*factor)), (int)(Math.round(400*factor)));
        hsb = new Turtle(w);
        hsb.setVisible(false);
        hsb.setPenWidth(1);
        k = new Turtle(w);
        k.setVisible(false);
        k.setPenWidth(1);
    }
    public PaintingPrinter(World x){
        w = x;
        hsb = new Turtle(w);
        hsb.setVisible(false);
        hsb.setPenWidth(1);
        k = new Turtle(w);
        k.setVisible(false);
        k.setPenWidth(1);
    }
    //accessors

    public Turtle getHsb() {
        return hsb;
    }
    public Turtle getK() {
        return k;
    }
    public World getW() {
        return w;
    }
    public void newW(int x, int y) {
        w = new World(x, y);
        hsb = new Turtle(w);
        hsb.setVisible(false);
        hsb.setPenWidth(1);
        k = new Turtle(w);
        k.setVisible(false);
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
        int x1 = obj.getXPos(); //get positions
        int y1 = obj.getYPos();
        obj.penUp(); //just in case
        obj.setHeading(0); //reset heading
        int dx = x - x1; //change in x required
        int dy = y1 - y; //change in y required
        //translate along x
        obj.turnRight();
        if (dx>0) obj.forward(dx);
        else obj.backward(-dx);
        //translate along y
        obj.turnLeft();
        if(dy>0) obj.forward(dy);
        else obj.forward(dy);
    }

    /**
     * paints a picture using a black and color turtle, based on the input matrix.
     * @param in array of all pixels and the color that they are supposed to be
     */
    public void paint(Color[][] in){
        hsb.clearPath();
        k.clearPath();
        for(int i = 0; i < in.length; i++){
            for(int j = 0; j<in[i].length; j++){
                if(in[i][j] == Color.BLACK){
                    k.setPenColor(Color.BLACK);
                    goTo(k, i, j);
                    k.backward(1);
                    k.penDown();
                    k.forward(1);
                    k.penUp();
                } else{
                    hsb.setPenColor(in[i][j]);
                    goTo(hsb, i, j);
                    hsb.backward(1);
                    hsb.penDown();
                    hsb.forward(1);
                    hsb.penUp();
                }
            }
        }
    }
}