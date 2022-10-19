package diff.medium.contest;

public class RemoveStarsFromAString {
    public String removeStars(String s) {

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()){
            if (c == '*'){
                sb.setLength(sb.length()-1);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "leet***cod*e";
        RemoveStarsFromAString obj  = new RemoveStarsFromAString();
        System.out.println(obj.removeStars(s));

    }
}

//
//  if (s.charAt(i) == '*' && s.charAt(i+1) == '*') {
//          countStar++;
//          if (s.charAt(i) != '*' ) {
//          result += s.substring(totalSubtract + result.length(), i - countStar);
//          totalSubtract += countStar * 2;
//          countStar = 1;
//          }
//          }