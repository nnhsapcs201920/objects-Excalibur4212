import java.awt.Color;

public class TurtleDemo
{
    public static void makeAwesomeTurtlePattern()
    {
        World ocean = new World();
        Turtle crush = new Turtle(ocean);
        crush.turn(180);
        crush.turn(18);
        for(int i = 0; i < 5; i++){
            Color x = new Color(186, 218, 85);
            crush.setPenColor(x);
            crush.setPenDown(true);
            crush.forward(10);
            crush.turn(36);
        }
    }
}
