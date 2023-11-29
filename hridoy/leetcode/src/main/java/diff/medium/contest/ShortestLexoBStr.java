package diff.medium.contest;

public class ShortestLexoBStr {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int left = 0;
        int countOnes = 0;
        int minLength = Integer.MAX_VALUE;
        String smallestSubstring = "";

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                countOnes++;
            }

            while (countOnes == k) {
                if (right - (left + 1) <= minLength) {
                    String currentSubstring = s.substring(left, right + 1);
                    if (smallestSubstring.isEmpty() || currentSubstring.compareTo(smallestSubstring) < 0|| currentSubstring.length() < smallestSubstring.length()) {
                        smallestSubstring = currentSubstring;
                    }
                    minLength = right - (left + 1);
                }

                if (s.charAt(left) == '1') {
                    countOnes--;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : smallestSubstring;
    }
    public static void main(String[] args) {
        ShortestLexoBStr obj = new ShortestLexoBStr();
        String s = "001110101101101111";
        int k =10;
        System.out.println(obj.shortestBeautifulSubstring(s,k));
    }
}
