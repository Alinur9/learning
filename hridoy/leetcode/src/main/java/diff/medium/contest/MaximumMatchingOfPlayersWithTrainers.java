package diff.medium.contest;

import java.util.Arrays;

public class MaximumMatchingOfPlayersWithTrainers {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int numOfMatching = 0 ;
        int k =0;
        for (int i =0 ; i < players.length;i++){
            for (int j =k; j < trainers.length;j++){
                if (players[i] <= trainers[j]){
                    k = j + 1;
                    numOfMatching++;
                    break;

                }
            }
        }
        return numOfMatching;

    }

    public static void main(String[] args) {

        int [] players = {1,1,1};
        int [] trainers = {10};

        MaximumMatchingOfPlayersWithTrainers obj = new MaximumMatchingOfPlayersWithTrainers();
        System.out.println(obj.matchPlayersAndTrainers(players,trainers));

    }
}
