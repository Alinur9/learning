public class recursion {
    static void printline(int n){
        for(int i = 0; i < n; i++){
            System.out.print("*");
        }
        System.out.println();
        if (n > 0){
            printline(n-1);
        }
    }
    public static void main(String[] args){
        printline(5);
    }
}
