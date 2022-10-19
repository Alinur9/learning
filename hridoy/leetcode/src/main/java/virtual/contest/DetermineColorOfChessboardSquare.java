package virtual.contest;

public class DetermineColorOfChessboardSquare {
    public boolean squareIsWhite(String coordinates) {
            int[][] chessboard = {{1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1}};
        char c ;
        int idx = 0;
            for (int i =0; i < 8;i++){
               c = (char) ('a'+i);
               if (c == coordinates.charAt(0)){
                 idx =i;
                 break;
               }
            }
        char num = coordinates.charAt(1);
        int numb = Integer.parseInt(String.valueOf(num));
        if (chessboard[numb-1][idx] == 1){
            return false;
                           }


            return true;
    }



    public static void main(String[] args) {
        String coordinates = "c7";
        DetermineColorOfChessboardSquare obj = new DetermineColorOfChessboardSquare();
        System.out.println( obj.squareIsWhite(coordinates));

    }
}
