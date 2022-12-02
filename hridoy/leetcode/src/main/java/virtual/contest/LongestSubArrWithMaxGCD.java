package virtual.contest;

public class LongestSubArrWithMaxGCD {
    static int findLength(int []arr, int n)
    {
        int x = 0;
        for (int i = 0; i < n; i++)
            x = Math.max(x, arr[i]);
        int ans = 0;


        for (int i = 0; i < n; i++) {
            if (arr[i] != x)
                continue;
            int j = i;
            while (arr[j] == x) {
                j++;
                if (j >= n )
                     break;
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
    }

    // Driver code
    public static void main (String[] args)
    {
        int[] arr = { 1, 2, 2 };
        int n = arr.length;

        System.out.println(findLength(arr, n));
    }
}

