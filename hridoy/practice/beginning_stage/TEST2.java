class Test2{
    public boolean PalinDrm(int x){
        if ( x < 0){
            return false;
        }
        int rev =0 , rem;
        int onum = x;
        while ( x > 0){
            rem= x % 10;
            rev = rev * 10 + rem;
            x = x/10;
        }
        return onum==rev;

    }
    public static void main (String[] args){
        int x = 121;
        Test2 c= new Test2();
        boolean pass= c.PalinDrm(x);
        System.out.println(pass);
    }

}

