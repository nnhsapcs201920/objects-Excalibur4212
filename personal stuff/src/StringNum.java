import java.util.List;
import java.util.ArrayList;
public class StringNum {
    private String integer;
    private List<Integer> reversedlist = new ArrayList<Integer>();
    public StringNum(){
        integer = "0";
        reversedlist = listgen(integer);
    }
    private List<Integer> listgen (String in){
        List<Integer> out = new ArrayList<Integer>();
        for(int i = in.length()-1; i >= 0; i--) out.add(Integer.parseInt("" + in.charAt(i)));
        return out;
    }
}
