package virtual.contest;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {

        int maxWealth =0;
        int sum =0;
        for (int i =0; i < accounts.length; i++){
            for (int j =0; j < accounts[i].length; j++){
                 sum += accounts[i][j];
            }
            maxWealth = Math.max(maxWealth,sum);
            sum =0;
        }
        return maxWealth;

    }

    public static void main(String[] args) {
        int[][] accounts = {{1,2,3},{3,2,1},{7,8,9}};

        RichestCustomerWealth obj = new RichestCustomerWealth();
        System.out.println(obj.maximumWealth(accounts));

    }
}
