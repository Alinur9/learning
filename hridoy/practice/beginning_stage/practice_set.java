
class Employee1{
    int salary;
    String name;
    public int getSalary (){ // method
         return salary;
    }
    public String getName(){
        return name;
    }
    public void  setName(String n){
        name = n ;
    }

}
class cellPhone1 {
     public void ring(){
         System.out.println("ringing . . .");
     }
     public void friend (){
         System.out.println("calling to Abir");
     }
}
class square1{
    int side;
    public int area (){
        return side*side;
    }
    public int perimeter(){
        return 4*side;
    }
}

class game{
    public void firing (){
        System.out.println("firing on the enemy");
    }
    public void running (){
        System.out.println("running to the enemy");
    }
}

public class practice_set{
    public static void main(String[] args) {
//problem 1
        Employee1 hridoy = new Employee1();
        hridoy.setName("CodeWithHridoy ");
        hridoy.salary = 20;
        System.out.println(hridoy.getName());
        System.out.println(hridoy.getSalary());
//problem 2
        cellPhone1 iphone = new cellPhone1();
        iphone.ring();
        iphone.friend();

        // problem 3
        square1 sq = new square1();
        sq.side = 3;
        System.out.println(sq.perimeter());
        System.out.println(sq.area());

        //problem 4

        game tommy = new game();
        tommy.firing();
        tommy.running();

    }
}