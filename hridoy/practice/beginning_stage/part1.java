class part1{
    public static void main(String[] args){
        int i;
        int j=0;
        int[] ar={1,2,2,4,4,4};
        int[] temp=new int [ar.length];
        for(i=0; i< ar.length - 1;i++) {

        if(ar[i] != ar[i+1] ) {
            temp[j] = ar[i];
            j++;
        }
        }
        temp[j]=ar[ar.length-1];
        for(int k=0;k< temp.length;k++) {

            System.out.print(temp[k] + " ");
        }
    }
}