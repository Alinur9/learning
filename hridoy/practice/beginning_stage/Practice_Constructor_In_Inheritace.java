class xyz{
   public xyz(){
       System.out.println("Xyz Is a Best Cloud Company");
   }
   public xyz(String ceo){
       System.out.println("Mr.Moshiur Rahman is CEO of Xyz Cloud " + ceo);
   }

    }

class xyzStudents extends xyz{
    xyzStudents(){
        //super (ok);
      System.out.println("we are junior java developer programmer of Xyz");
    }
    xyzStudents(String ceo , int numbers){
        super(ceo);
        System.out.println("total numbers of students is " + numbers);

    }
}
class xyzOnWay extends xyzStudents{
    xyzOnWay(){
        System.out.println("we are already officially open our Xyz");
    }
    xyzOnWay(String ceo , int numbers , String date){
        super(ceo,numbers);
        System.out.println("opening date is " + date);
    }
}


public class Practice_Constructor_In_Inheritace {
    public static void main(String[] args) {
       xyzOnWay run = new xyzOnWay("ok",10,"01.01.2021");

    }
}
