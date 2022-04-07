public class NumberOfString {
    public int numberOfStringAppears(String [] total , String target){
        int count = 0;
        for ( String total1 : total){
            if (target.indexOf(total1) > -1){
                count ++;
            }
        }
        return  count;

    }
    public static void main (String[] args){
        String[] numbers = {"dgvyb","j","rc","b","gve","rkbzd","i","ial","tws","c","z"};
        int result = numbers.length;
        String target = "zcobp";
        NumberOfString c = new NumberOfString();
        result=c.numberOfStringAppears(numbers,target);
        System.out.println(" " + result);

    }
}
