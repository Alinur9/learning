package leetcode.com.company;

public class MinimumBitFlips {

        public static int countFlips(int start, int goal){
            int flips = 0;

            while(start>0 || goal>0){
                int t1 = (start & 1);
                int t2 = (goal & 1);
                if(t1!=t2){
                    flips++;
                }
                // right shifting a and b
                start = (start / 2);
                goal = (goal / 2) ;
            }

            return flips;
        }

        public static void main (String[] args) {
            int a = 10;
            int b = 7;
            System.out.println(countFlips(a, b));
        }

    }

