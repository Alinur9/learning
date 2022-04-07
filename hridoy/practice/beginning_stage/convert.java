
        import java.util.*;

class convert {
    public static void main(String[] args){
        int[][] x={{1,2,3,4},{5,6,7,8,}};
      arr (x);
    }

    private static void arr(int[][] arr) {

        List<Integer> Ist= new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++){

            for(int j = 0; j < arr[i].length; j++){
                Ist.add(arr[i][j]);
            }
        }
        int[] str = new int[Ist.size()];
        for(int i = 0; i < str.length; i++){
            str[i] = Ist.get(i);
            System.out.println(str[i]+" ");
        }
    }

}
