import java.util.ArrayList;
import java.util.List;

public class StringAddition {
    //accepts two strings a
    public String StringAdd (String in1, String in2){
        //declare variables
        List<Integer> intarray1 = new ArrayList<Integer>();
        List<Integer> intarray2 = new ArrayList<Integer>();
        List<Integer> outarray = new ArrayList<Integer>();
        //populate intarray1
        for(int i = in1.length()-1; i >=0; i--) intarray1.add(Integer.parseInt(in1.charAt(i) + ""));
        //populate intarray2
        for(int i = in2.length()-1; i >=0; i--) intarray2.add(Integer.parseInt(in2.charAt(i) + ""));
        return null;
    }
}
