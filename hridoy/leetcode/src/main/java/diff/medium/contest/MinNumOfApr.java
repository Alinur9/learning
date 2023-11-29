package diff.medium.contest;

import java.util.Arrays;

public class MinNumOfApr {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int temp=nums[0];
        int sum=0;
        int count =1;

        for(int i=1;i< nums.length;i++){
            if(temp == nums[i]){
                count++;
            }
            if(temp != nums[i]){
                if(temp % 3 ==0){
                    sum += count / 3;
                } else if (temp % 2 ==0) {
                    if((count -4) % 3 == 0){
                        int num= count -4;
                        sum += num /3;
                        sum += 2;
                    }else if((count -2) % 3 == 0){
                       int num1 = count -2;
                        sum += num1 /2;
                        sum += 1;
                    }else {
                        sum += count / 2;
                    }

                }else {
                  return  -1;
                }
                    temp = nums[i];
                count =1;
            }

        }
        if(count > 1){
            if (count % 3 == 0){
                sum += count /3;
            }else if(count % 2 ==0){
                if((count -4) % 3 == 0){
                    int num= count -4;
                    sum += num /3;
                    sum += 2;
                }else if((count -2) % 3 == 0){
                    int num1 = count -2;
                    sum += num1 /2;
                    sum += 1;
                }else {
                    sum += count / 2;
                }
            }else {
                return -1;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {14,12,14,14,12,14,14,12,12,12,12,14,14,12,14,14,14,12,12};
        MinNumOfApr obj = new MinNumOfApr();
        System.out.println(obj.minOperations(nums));
    }
}
