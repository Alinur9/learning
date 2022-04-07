class returntwosum{
    static int numbers(int a,int b,int c){
        int d = a + b; //2#execute code
        if(  d == c) {
            return c;//3#throw value
        }
        else{
            return 0;

        }

    }
    public static void main (String[] args){
       /* int a=5;
        //int b=5;
       int c=10;*/
        int ans1;
        int answer; //4# get return value

        answer=numbers(5,3,10);//1#passing data
        System.out.println(answer);
        ans1=numbers(10,20,30);//passing data
        System.out.println(ans1);
        answer=numbers(5,5,10);//using return several times for object answer
        System.out.println(answer);

    }
}