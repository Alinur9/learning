public class task2 {
    public static void main(String[] args){
        int[][] a ={{1,3}};
        int total = 0;
        for(int i =0; i<a.length; i++){

            for(int j =-0; j < a[i].length;j++){
                total = total + a[i][j];
            }
            System.out.println(+total);
        }
    }
}

