package leetcode.com.company;

import java.util.Arrays;

public class FllipingAnImage {
    public int[][] flipAndInvertImage(int[][] image) {



        for (int i = 0; i < image.length ; i++) {
            int trav =0;
            int lastIdx = image[0].length-1;
            int mid = image[i].length/2;

            if (image[i].length%2 != 0){
                if (image[i][mid] == 1){
                    image[i][mid] = 0;
                }else {
                    image[i][mid] = 1;
                }
            }
            for (int j = 0; j < image[i].length/2; j++) {
                int last = image[i][lastIdx];
                int first = image[i][trav];
                image[i][lastIdx] = first;
                image[i][trav] =last;


                if (image[i][lastIdx] == 1){
                    image[i][lastIdx] =0;
                    lastIdx--;
                    if (image[i][trav] == 0){
                        image[i][trav] = 1;
                        trav++;

                    }else {
                        image[i][trav]= 0;
                        trav++;

                    }
                }else if (image[i][lastIdx] == 0){
                    image[i][lastIdx] =1;
                    lastIdx--;
                    if (image[i][trav] == 0){
                        image[i][trav] = 1;
                        trav++;
                    }else {
                        image[i][trav]= 0;
                        trav++;
                    }
                }

            }
        }
        return image;
    }

    public static void main(String[] args) {
        int [][] image  = {{1,1,0},{1,0,1},{0,0,0}};

        FllipingAnImage obj = new FllipingAnImage();
        System.out.println(Arrays.deepToString(obj.flipAndInvertImage(image)));


    }
}
