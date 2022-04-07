import java.util.Stack;

public class stackGames {
    public static void main (String[] args){
        Stack<String> games = new Stack<String>();
        //AoE
        //NfS
        //CoD
        //PUBG
        //index 2(NfS switch with GTA5)

        games.add("PUBG");
        games.add("Call of Duty");
        games.add("Need for Speed");
        games.add("Age of Empires");
      //  System.out.println(games.pop());
        System.out.println(games.set(2,"GTA5"));
        System.out.println(games);
    }

}
