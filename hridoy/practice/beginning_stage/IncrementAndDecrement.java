import java.util.HashMap;
import java.util.Map;

public class IncrementAndDecrement {
    public int incADec(String[] operators){
       // String x = "x" ;
        int x = 0;
        Map<String,Integer> point = new HashMap<>();
        point.put("--x",-1);
        point.put("++x",1);
        point.put("x++",1);
        point.put("x--",-1);
       // point.put("x",0);
        for(int i = 0; i < operators.length;i++) {
            x = x + point.get(operators[i]);
        }
        return x;


    }
    public  static void main (String[] args){
        String[] op = {"--x","x++","x++"};
        IncrementAndDecrement c = new IncrementAndDecrement();
        c.incADec(op);
        System.out.println(c.incADec(op));
        }
    }
