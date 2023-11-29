package diff.medium.contest;

public class ContructLongestNewStr {
    public int longestString(int x, int y, int z) {

        int size=0;
        if(z== y || z == x){
            size = 2*z;
            if(y > x){
                size += 2*(x+1);

                size += (z+x)*2;
            }else {
                size += 2*(y+1);
                size += (z+y)*2;
            }
            return size;
        }
       if(y > x){
           size = 2*(x+1);
           size += (z+x)*2;
       }else {
           size = 2*(y+1);
           size += (z+y)*2;
       }
return size;
    }

    public static void main(String[] args) {
        ContructLongestNewStr obj = new ContructLongestNewStr();
        int x=1;
        int y = 34;
        int z= 1;
        System.out.println(obj.longestString(x,y,z));
    }
}
