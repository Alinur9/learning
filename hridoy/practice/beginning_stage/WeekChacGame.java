
class WeekCharGame {
    public int numberOfWeekCharacterGame(int[][] properties){
         int[] maxH = new int [100002];
         int count = 0;
         for (int [] point : properties){
             maxH[point [0]] = Math.max(point[1],maxH[point [0]]);
         }
         for (int i =10000 ; i > 0; i--){
             maxH[i] = Math.max(maxH[i+1],maxH[i]);
         }
         for (int[] point : properties){
             if (point[1]<maxH[0]+1)
                 count++;
         }
         return count ;
    }
    public static void main (String[] args){
        int[][] power = {{5,5},
                {6,3},
                {2,3}};

        int week;
        WeekCharGame c = new WeekCharGame();
        week= c.numberOfWeekCharacterGame(power);
        System.out.println(week);
    }
}
