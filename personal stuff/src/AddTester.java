import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.awt.Rectangle;
public class AddTester {
    public static void main(String[] args) {
        Rectangle box = new Rectangle(5, 10, 20, 30);
        box.add(0, 0);
        System.out.println("Your prediction was java.awt.Rectangle[x=0, y=0, width = 25, height = 40], but the actual value is ");
        System.out.print(box);
    }
}
