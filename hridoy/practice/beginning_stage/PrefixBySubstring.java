import java.util.ArrayList;

public class PrefixBySubstring {
    public String prefixName (String []names){
        ArrayList<String> al = new ArrayList<>();
        String target = "Rahman";
        int targLeng = target.length();
        for(int i = 0 ; i < names.length; i++ ){
            int size = names[i].length();
            String subStr = names[i].substring(size - targLeng);
            if (target.equals(subStr)){
                al.add(names[i]);
            }
            }
        return String.valueOf(al);
        }
    public static void main ( String [] args ){
        String [] name ={"Moshiur Rahman","Abdur Rahman","Mahmud Rahman","Alinur","Ibrahim Khalilullah","Masud Rahman","Mehdi Rahman","Abdullah Mamun"};
        PrefixBySubstring c = new PrefixBySubstring();
        c.prefixName(name);
        System.out.println(c.prefixName(name));
    }
}
