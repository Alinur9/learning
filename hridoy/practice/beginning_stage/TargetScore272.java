public class TargetScore272 {
    public int minMoves(int target, int maxDoubles){
        if (maxDoubles == 0 ) return target -1;
        int moves = 0;
        while (target >1 ){
            if (maxDoubles != 0 && target % 2 == 0){
                 moves += 1;
                target /= 2;
                maxDoubles--;
            }else {
                moves+=1;
                target-=1;
            }
        }
        return moves;
    }

    public static void main(String[] args) {

        int target = 19;
        int maxD = 2;
        TargetScore272 value = new TargetScore272();
       int res = value.minMoves(target,maxD);
        System.out.println(res);
    }
}
