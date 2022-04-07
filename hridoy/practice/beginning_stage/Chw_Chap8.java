class  Employee{
    String department;
    String name;
    String position;
    int salary;
    public void setDepartment(String d ){
        department = d;
    }
    public String getDepartment(){
        return department;
    }
    public void  setName (String n){
        name = n;
    }
    public  String getName(){
        return name;
    }
    public  int getSalary(){
        return salary;
    }
    //constructors
    public Employee (String name){ this.name = name ;}
    public Employee(int salary){this.salary = salary; }

    public void setSalary(int salary) {
    }
}
class CellPhone{
    long number;
    public  void ring(){
        System.out.println("Ringing The Phone");
    }
    public void vibrate(){
        System.out.println("Vibrating Mood");
    }
    public void game(){
        System.out.println("PUBG Mobile ");
    }
    public long dialing(){
        return number;
    }

}
class Square{
    int side;
    public int area (){
        return side*side;

    }
    public int perimeter(){
        return 4*side;
    }
}
class Rectangle{
    int length;
    int width;
    public int perameterOfRect(){
        return 2*(length+width);
    }
    public int areaOfReact(){
        return length*width;
    }
}

public class Chw_Chap8 {
    public static void main(String[] args) {
       /* Employee emp = new Employee();
        emp.setDepartment("F&B");
        System.out.println(emp.getDepartment());
        emp.name= "Ahsan";
        emp.position="Outlet Incharge";
        emp.salary=2000;
        System.out.println(emp.getSalary());


        CellPhone c = new CellPhone();
        c.game();
        c.vibrate();
        c.ring();
        c.number= 905545689;
        System.out.println(c.number);

        Square sq = new Square();
        sq.side= 5;
        System.out.println(sq.area());
        System.out.println(sq.perimeter());

        Rectangle rect = new Rectangle();
        rect.width = 3;
        rect.length= 3;
        System.out.println(rect.perameterOfRect());
        System.out.println(rect.areaOfReact());*/
        Employee cons = new Employee(10000);
        Employee cons1 = new Employee("Ahsan");
    }
}
