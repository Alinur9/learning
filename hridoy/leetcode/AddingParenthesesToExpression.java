package leetcode.com.company;

public class AddingParenthesesToExpression {
    public String minimizeResult(String expression) {
            int left = -1 ;
            int right = -1;
            int minVal = Integer.MAX_VALUE;
            char[] arr = expression.toCharArray();
            int size = arr.length;
            int idx =0;
            for (int i =0; i < size; i++){
                if (arr[i] == '+'){
                    idx = i;
                    break;
                }
            }
            int l = idx -1;
            int r = idx +1;
            for (int i = l; i >= 0;i--){
                for (int j = r ; j < size ;j++){
                    int a = Integer.parseInt(expression.substring(i,idx));
                    int b = Integer.parseInt(expression.substring(idx+1,j+1));
                    int c = 1;
                    int d = 1;
                    if (i!= 0) c = Integer.parseInt(expression.substring(0,i));
                    if (j!= size-1) d = Integer.parseInt(expression.substring(j+1));

                    int val = (a+b)*c*d;
                  //  System.out.println(val);
                    if (val < minVal){
                        minVal = val;
                        left =i;
                        right =j;
                    }
                }
            }
            String strL = expression.substring(0,left);
            String strR = expression.substring(right+1);
            String strM = expression.substring(left,right+1);
            return (strL + '(' + strM + ')' + strR);


    }

    public static void main(String[] args) {
        String expression = "999+999";
        AddingParenthesesToExpression obj = new AddingParenthesesToExpression();
        System.out.println(obj.minimizeResult(expression));
    }

}
