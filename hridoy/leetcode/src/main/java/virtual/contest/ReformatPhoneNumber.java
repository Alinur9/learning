package virtual.contest;

public class ReformatPhoneNumber {
    public String reformatNumber(String number) {


        String phoneNum = number.replaceAll("[\\s-]","");
        String phnNumFinal ="";
        String ans ="" ;
        int j =0;

       if (phoneNum.length() == 2){
           return phoneNum;
       }
       if (phoneNum.length() == 4){
           phnNumFinal = phoneNum.substring(0,2)+'-'+phoneNum.substring(2);
           return phnNumFinal;
       }

       for (int i =3 ; i <= phoneNum.length();i++){

           if (i+4 == phoneNum.length() && i% 3 ==0){
               phnNumFinal = phoneNum.substring(j,i)+'-'+phoneNum.substring(i,i+2)+'-'+phoneNum.substring(i+2);
               ans+= phnNumFinal;
               break;
           }
           if (i == phoneNum.length()){
               ans += phoneNum.substring(j,i);
               break;
           }
           if (i+3 <= phoneNum.length() && (i+3)%(3) == 0 || i % 3== 0){
               phnNumFinal = phoneNum.substring(j, i) + '-';
               j+=3;
               ans += phnNumFinal;
           }

           if ( i +2 == phoneNum.length() && i % 3 ==0 ){
               phnNumFinal =phoneNum.substring(i);
               ans += phnNumFinal;
               break;
           }
       }
        return ans;


    }
    public static void main(String[] args) {
        String number = "123 4566714536643634646645";

        ReformatPhoneNumber obj = new ReformatPhoneNumber();
        System.out.println(obj.reformatNumber(number));


    }
}
