import java.util.Scanner;

public class restart {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(" your time is start at 11;00 clock ");
        System.out.println(" You have one hour for physical exercise ");
        int hour = scan.nextInt();
        int i = 0;
        while (i <= hour) {
            i--;
            if (hour == 1) {
                System.out.println(" congratulation, completed your 1st task ");
                System.out.println(" lets start with next step  ");
                //use break statement for reduce infinite iteration
                break;
            } else if (hour > 1) {
                System.out.println("you have to manage other things, keep focus on your time");
                hour = scan.nextInt();
            } else if (hour < 1) {
                System.out.println("wake up men,u have to complete it");
                hour = scan.nextInt();
            }
        }
        /* shower 15 minutes
        salah time 15 minutes
        lunch time 15 minutes
        self grooming 20 minutes
        calculate total time of above
        then calculate 11 clock to exercise time with sum , and let us know your rest time until get the bus.
        bus time 2:35 clock = 11 to 215 minutes

        note :rest time should be 90 minutes
        then explain by scanner nextLine

        20 minutes gonna take  for go to my office
        work start 3:00 pm clock
         */
        for(int j = 0; j <= 4 ; j++){
            int sum =0;
            if (j==1) {
                System.out.println("take 15 minutes for shower");
                int shower = scan.nextInt();

                if (j== 2);
                System.out.println("make pray");
                int pray = scan.nextInt();

                if (j == 3);
                    System.out.println("take your lunch");
                    int lunch = scan.nextInt();

                    if (j == 4);
                    System.out.println(" prepare yourself");
                    int grooming = scan.nextInt();

                    sum+= shower+pray+lunch+grooming;
                System.out.println("total minutes is taken after complete exercise until reach the office bus : " + sum +" minutes ");
                int total = 0 ;
                int conv=60;
                hour = conv;
                total+= sum+hour; // 125 minutes
                System.out.println("11:00 clock to exercise time + sum = total timeing is : " + total + " minutes ");

                int bustime =215; // 1 hour = 60 minutes , 11 clock to 2:35 = 3 hours 35 minutes ,in total minutes 215 minutes
                int resttime=0;
                resttime+= bustime - total; //215 -125 minutes
                if ( resttime ==90) {
                    //String describe = scan.nextLine();
                    System.out.println("rest time is : " + resttime + " minutes");
                }
                else{
                    System.out.println("check line 71 ");
                }
               // String describe = scan.nextLine();



                }
                }
            }
            }



