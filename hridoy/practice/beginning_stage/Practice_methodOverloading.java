
     class MyEmployee {
         private  int salary;
         private String name;
         private  String jobTitle;
         private String department;


         public  MyEmployee(){

             salary = 30;
             name = "your_Name";
         }

         public MyEmployee(int salary, String name, String jobTitle, String department) {
             this.salary = salary;
             this.name = name;
             this.jobTitle = jobTitle;
             this.department = department;
         }

         public int getSalary() {
             return salary;
         }

         public void setSalary(int salary) {
             this.salary = salary;
         }

         public String getName() {
             return name;
         }

         public void setName(String name) {
             this.name = name;
         }
     }
     public class Practice_methodOverloading {



    public static void main(String[] args) {
        MyEmployee hridoy = new MyEmployee();
        MyEmployee employee = new MyEmployee(500, "ahsan" ,"Manager", "Hospitality");


        hridoy.setSalary(20);
        hridoy.setName("workWithXYZ") ;

       System.out.println(hridoy.getName());
        System.out.println(hridoy.getSalary());

        System.out.println(employee.getName());
        System.out.println(employee.getSalary());





    }

}
