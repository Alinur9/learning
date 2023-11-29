package diff.medium.contest;

public class LexicographicallySmallestString {
    public String smallestString(String s) {

        int startIdx =0;

        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        boolean sbFlag = false;
        boolean sbFlag2 = false;
        boolean sbFlag3 = false;
        if(s.length()<2){
            char currentChar = s.charAt(0);
            char previousChar = (char) (currentChar - 1);
            if (currentChar == 'a') {
                previousChar = 'z';
            }
return String.valueOf(previousChar);
        }
        if( s.charAt(0) =='a' && s.charAt(1)=='a') {
            result.append(s.charAt(0));
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'a'){
                if( s.charAt(i-1) == s.charAt(i)){
                    char currentChar1 = s.charAt(i+1);
                    char previousChar1 = (char) (currentChar1 - 1);
                    if (currentChar1 == 'a') {
                        previousChar1 = 'z';
                        result.append(previousChar1);
                        sbFlag3 = true;
                }
                }
                startIdx = i+1;
                if(sbFlag){
                    sbFlag2=true;
                    for (int  k= 0; k < sb.length(); k++) {
                        char currentChar = sb.charAt(k);
                        char previousChar = (char) (currentChar - 1);
                        result.append(previousChar);
                    }
                    String s1 =s.substring(sb.length());
                    result.append(s1);
                    break;
                }
            }else {
                if(startIdx> 0 && !sbFlag3){
                    String s2 =s.substring(0,i);
                    result.append(s2);
                    startIdx =0;
                    sbFlag3 = true;
                }
                sb.append(s.charAt(i));
                    sbFlag = true;
            }
        }
        if(!sbFlag2){
            for (int  k= 0; k < sb.length(); k++) {
                char currentChar = sb.charAt(k);
                char previousChar = (char) (currentChar - 1);
                result.append(previousChar);
            }
        }

    return result.toString();

    }
    public static void main(String[] args) {
        LexicographicallySmallestString obj = new LexicographicallySmallestString();
        String s = "aaa";
        System.out.println(obj.smallestString(s));
    }
}
