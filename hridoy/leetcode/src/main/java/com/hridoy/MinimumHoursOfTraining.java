package com.hridoy;

public class MinimumHoursOfTraining {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int engHour =0;
        int expHour =0;
        int totalEng =0;
        for (int i =0;i< energy.length;i++){
            totalEng += energy[i];
        }
        if (initialEnergy < totalEng){
            engHour = totalEng- initialEnergy +1;
        }
        if (initialEnergy == totalEng){
            engHour++;
        }
        for (int j =0; j < experience.length;j++){
            if (initialExperience > experience[j]){
                initialExperience += experience[j];
                continue;
            }
            if (initialExperience <= experience[j]){
                expHour += experience[j] - initialExperience +1;
               initialExperience += experience[j] - initialExperience+1;
            }
            initialExperience += experience[j];
        }
        return engHour + expHour;
    }
    public static void main(String[] args) {
        int initialEng = 1;
        int initialExp = 1;

        int [] energy = {1,1,1,1};
        int [] exp = {1,1,1,50,100};
        MinimumHoursOfTraining obj = new MinimumHoursOfTraining();
        System.out.println(obj.minNumberOfHours(initialEng,initialExp,energy,exp));
    }

}
