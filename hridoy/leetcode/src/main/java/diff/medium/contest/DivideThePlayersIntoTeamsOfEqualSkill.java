package diff.medium.contest;

import java.util.Arrays;

public class DivideThePlayersIntoTeamsOfEqualSkill {
    public long dividePlayers(int[] skill) {



        Arrays.sort(skill);
        int j = skill.length-1;
       int sum = skill[0] + skill[j];
        long chemistry = 0;
        for (int i = 0; i < skill.length/2;i++,j--) {
                if (skill[i] + skill[j] == sum) {
                    chemistry += (long) skill[j] *skill[i];
                } else {
                    return -1;
                }
        }
        return chemistry;

    }


    public static void main(String[] args) {
        int [] skill = {3,2,5,1,3,4};
        DivideThePlayersIntoTeamsOfEqualSkill obj = new DivideThePlayersIntoTeamsOfEqualSkill();
        System.out.println(obj.dividePlayers(skill));
    }
}
