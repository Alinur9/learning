package diff.medium.contest;

public class PartitionStrIntoSubStr {

    public int minimumPartition(String s, int k) {
        String temp ="";

        int i=0,c=0,j=0;
        // i - left pointer
        // j - right pointer
        while(j<s.length())
        {
            while(j<s.length() && Long.parseLong(s.substring(i,j+1))<=k)
                j++;
            c++;
            if(i==j)
                return -1;
            i=j;
        }
        return c;

    }


    public static void main(String[] args) {

        String str = "165462";
        int k =60;
        PartitionStrIntoSubStr obj = new PartitionStrIntoSubStr();
        System.out.println(obj.minimumPartition(str,k));

    }
}
