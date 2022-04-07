import java.util.ArrayList;
import java.util.List;

public class FindCommonCharPart2 {
    public List<String> findCommonCharT(String[] words) {
        List<String> result = new ArrayList<>();
        //Go through each char in the first string
        for (int i=0; i<words[0].length(); i++) {
            int flag = 0;
            char c = words[0].charAt(i);
            //Go through each string in words starting from the second string
            for (int j=1; j<words.length; j++){
                int index = words[j].indexOf(c);
                //if char is not in the string then break and set flag to 1
                if (index==-1) {
                    flag = 1;
                    break;
                }
                else {
                    words[j]= words[j].substring(0, index) + words[j].substring(index+1); //delete the char the is already compared
                }
            }
            //if flag is 0 that means char is in all the string thus add to result
            if (flag==0) {
                result.add(String.valueOf(c));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] word = {"bella", "label", "roller"};
        FindCommonCharPart2 c = new FindCommonCharPart2();
         c.findCommonCharT(word);
        System.out.println();

    }
}


  /**  List<String> res = new ArrayList<>();
        for (int i = 0; i < words[0].length();i++){
        int access = 0;
        char c = words[0].charAt(i);


        for (int j = 1 ; j < words.length;j++){
        int index = words[j].indexOf(c);
        if (index == -1){
        access =1 ;
        break;
        }
        else{
        words[j] = words[j].substring(0,index) + words[j].substring(index+1);
        }
        }
        if(access == 0 ){
        res.add(Character.toString(c));
        }
        }
        return res **/