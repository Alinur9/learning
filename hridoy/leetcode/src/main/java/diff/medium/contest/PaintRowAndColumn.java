//package diff.medium.contest;
//
//import java.util.HashMap;
//
//public class PaintRowAndColumn {
//
//    public int firstCompleteIndex(int[] arr, int[][] mat) {
//HashMap<Integer,Integer> map = new HashMap<>();
//int n =0;
//for(int i =0;i<mat.length;i++) {
//
//    for (int j= 0; j < mat[i].length; j++) {
//
//        if(mat[i][j] == arr[n]){
//            map.put(j,map.get(j)+1);
//            if(map.get(j) == mat[i].length){
//                return n;
//            }
//        }
//
//    }
//
//}
//
//    }
//    public static void main(String[] args) {
//        int [] arr = {1,3,4,2};
//        int[] [] mat = {{1,2},{2,3}};
//        PaintRowAndColumn obj = new PaintRowAndColumn();
//        System.out.println(obj.firstCompleteIndex(arr,mat));
//    }
//}
