
/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
//no error, but doesn't follow convention (a)
public class test
{
    //logical error: commandline will not run this, nor will a normal ide. It no longer autodetects as a main method
    //public static void man(String[] args)
    public static void main(String[] args)
   {
      //logical error below
      //System.out.println("An emergency Broadcast");
      //compiletime error: Unclosed string literal
      //System.out.println(An Emergency Broadcast");
      //compiletime error: Unclosed string literal
      //System.out.println("An Emergency Broadcast);
      //compiletime error: cannot find symbol
      //System.out.bogus("An Emergency Broadcast");
      //compiletime error: ; expected
      //System.out.println("An Emergency Boradcast")
      //compiletime error: Reached end of file while parsing
    }
}
