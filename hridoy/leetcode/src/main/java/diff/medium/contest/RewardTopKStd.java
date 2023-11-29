package diff.medium.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RewardTopKStd {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        List<Integer> list= new ArrayList<>(k);
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i =0; i< student_id.length;i++){
            if (i < positive_feedback.length){
                map.put(student_id[i],3);
            }
            String[] splited = report[i].split("\\s+");
            for (int j =0 ; j < splited.length;j++){
                if(i < negative_feedback.length  &&  splited[j] ==  negative_feedback[i]){
                    map.put(student_id[i], map.get(student_id[i])-1);
                }
            }
        }
        int max =0;
        for (int i=0;i< map.size();i++){

            if (map.get(student_id[i]) >= max){
                max = map.get(student_id[i]);
                list.add(student_id[i]);
            }
        }
        return list;

    }
    public static void main(String[] args) {

        String[] pstv ={"smart","brilliant","studious"};
        String[] ngtv ={"not"};
        String[] reports ={"this student is studious","the student is smart"};
        int[] sId= {1,2};
        int k =2;

        RewardTopKStd obj = new RewardTopKStd();
        System.out.println(obj.topStudents(pstv,ngtv,reports,sId,k));

    }
}
