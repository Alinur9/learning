 class Single_Inheritance{
    public int a = 40;
    public void addition(){
        System.out.println("Hello The Number is " + a);
    }
}
class Multi_level_Inheritance extends Single_Inheritance{
    public int b = 10;
    public void subtraction(){
        System.out.println( "subtract of number is " + (a-b));
    }
}

class Multi_lv2_Inheritance extends Multi_level_Inheritance{
    public int c = 5;
    private Single_Inheritance si;
    public void sub2(){
        System.out.println("Total number of subtract is " + (a-b-c));
//        si.a = 40;
 //     si.addition();
    }
         }

         // Hierarchical Inheritance
         class Hierarchical_Inheritance extends Multi_lv2_Inheritance{
    public int d = 4 ;
    public void multiplication (){
        System.out.println("Multiplication with lv2of result is " + (d * c));
    }
         }
         class Hierarchical2_Inheritance extends Multi_lv2_Inheritance{
    public int e = 2;
    public void multi2(){
        System.out.println("Multiplication with lv2 " + (e * c));
    }
         }



public class Test_Types_Of_Inheritance {
    public static void main(String[] args) {
        //Hierarchical Multiplication
        Hierarchical2_Inheritance testHi = new  Hierarchical2_Inheritance();
        Hierarchical_Inheritance testHi2 = new Hierarchical_Inheritance();
    testHi.multi2();
    testHi2.multiplication();

        // Print sub2 for the only testing

       // testHi.sub2();
       // testHi2.sub2();

        Multi_lv2_Inheritance testMul = new Multi_lv2_Inheritance();
        testMul.addition();
        testMul.subtraction();
        testMul.sub2();





    }
}
