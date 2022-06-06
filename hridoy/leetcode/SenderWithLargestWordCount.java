package leetcode.com.company;
import java.util.HashMap;

public class SenderWithLargestWordCount {
    public String largestWordCount(String[] messages, String[] senders) {
        int sum ;
        int max =0;
        String ans = "";
        HashMap<String,Integer> map = new HashMap<>();
        for (int i =0 ; i < messages.length; i++){
                String [] s = messages[i].split(" ");
                sum = s.length;
                if (map.containsKey(senders[i])){
                  sum +=  map.get(senders[i]);
                }
                map.put(senders[i],sum );
                if (map.get(senders[i]) == max ){
                if (ans.compareTo(senders[i]) < 0  ) {
                    ans = senders[i];
                }
            }
                if (map.get(senders[i]) > max){
                    max = map.get(senders[i]);
                    ans = senders[i];
            }
        }
            return ans;
    }


    public static void main(String[] args) {

        String[] msg = {"tP x M VC h lmD","D X XF w V","sh m Pgl","pN pa","C SL m G Pn v","K z UL B W ee","Yf yo n V U Za f np","j J sk f qr e v t","L Q cJ c J Z jp E","Be a aO","nI c Gb k Y C QS N","Yi Bts","gp No g s VR","py A S sNf","ZS H Bi De dj dsh","ep MA KI Q Ou"};
        String[] sender ={"OXlq","IFGaW","XQPeWJRszU","Gb","HArIr","Gb","FnZd","FnZd","HArIr","OXlq","IFGaW","XQPeWJRszU","EMoUs","Gb","EMoUs","EMoUs"};
        SenderWithLargestWordCount obj = new SenderWithLargestWordCount();
        System.out.println(obj.largestWordCount(msg,sender));
    }
}
