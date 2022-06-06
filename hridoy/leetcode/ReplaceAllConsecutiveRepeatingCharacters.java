package leetcode.com.company;

public class ReplaceAllConsecutiveRepeatingCharacters {
    public String modifyString(String s) {
        char[] ch = s.toCharArray();
        char[] chart= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for (int i =0; i < s.length(); i++){
            if (ch[i] == '?')
            for (int j =0 ; j <= chart.length; j++){

                if((i == 0 || chart[j] != ch[i-1]) && (i == s.length()-1 || chart[j] != ch[i+1])){
                    ch[i] = chart[j];
                    break;
                }
            }


            }
        s = String.valueOf(ch);
        return s ;
        }

    public static void main(String[] args) {

        String s = "j?qg??b";
        ReplaceAllConsecutiveRepeatingCharacters obj = new ReplaceAllConsecutiveRepeatingCharacters();
        System.out.println(obj.modifyString(s));

    }
}
