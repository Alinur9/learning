package com.hridoy;
import java.util.Arrays;
public class SuccessfulPairsOfSpellsNPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int count =0;
        for(int i =0;i<spells.length;i++){
            for (int j=0;j<potions.length;j++){
                long temp = (long)spells[i] *potions[j];
                if (temp >= success ){
                    count++;
                }
            }
            spells[i] = count;
            count =0;
        }
        return spells;
    }
    public static void main(String[] args) {
        int[] spells = {5,1,3};
        int[] potions = {1,2,3,4,5};
        int success = 7;
        SuccessfulPairsOfSpellsNPotions obj = new SuccessfulPairsOfSpellsNPotions();
    System.out.println(Arrays.toString(obj.successfulPairs(spells, potions, success)));

    }
}

