public class test {
    public  int dupl(int[] elem) {
        int j =0;//0
      //int[] temp = new int[elem.length];
        for (int i = 0; i < elem.length - 1; i++) {
            if (elem[i] != elem[i + 1]) {
                elem[j] = elem[i];
                j++;
            }
        }
        elem[j] = elem[elem.length - 1];   // elem=temp.clone();
                                               // elem[0]++;
        return j+1;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,5};
       // int n = nums.length;
        int passGet;
        test t = new test();
       passGet=t.dupl(nums);
        for (int i = 0; i <passGet; i++) {

            System.out.print(" " + nums[i]);
        }
    }
}
