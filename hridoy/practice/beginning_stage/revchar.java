public class revchar {
    public void reverseC(char[] s){
       /* for(int i =0 ;i<4;i++) {
            char temp = s[s.length - 1-i];
            s[s.length - 1-i] = s[i];
            s[i] = temp;
        }*/
        for(int i=0;i<s.length/2;i++){
            char temp=s[i];
            s[i]=s[s.length-1-i];
            s[s.length-1-i]=temp;
        }
        System.out.print(s);

    }
    public static void main (String[] args){
        char[] s= {'t','a','b','a','s','s','u','m','H'};
        revchar c = new revchar();
        c.reverseC(s);
    }
}
