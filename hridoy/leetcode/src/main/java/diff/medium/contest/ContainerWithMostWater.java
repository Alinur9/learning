package diff.medium.contest;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max =0;
        while (left<right){
            int area = right-left ;
            int h = Math.min(height[left],height[right]);
           int temp = area*h;
           if (temp > max){
               max = temp;
           }
           if (height[left] < height[right]){
               left++;
               area = right - left;
               h = Math.min(height[right],height[left] );
               temp = area*h;
               if (temp > max){
                   max = temp;
               }
           }
            else if (height[right] < height[left]){
                right--;
                area = right - left;
                h = Math.min(height[left],height[right] );
                temp = area*h;
                if (temp > max){
                    max = temp;
                }
            }else {
                right--;
                left++;
           }

        }
return max;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater obj = new ContainerWithMostWater();
        System.out.println(obj.maxArea(height));
    }
}
