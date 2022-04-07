public class User_Point {

    public static void main(String[] args) {
        MyLL acs = new MyLL();

        acs.add("hello");
        acs.add("Ahsan");
        acs.add("Hridoy");
        acs.add(9);
        acs.add(10);




        acs.insert("Ul Haque" , 2);
        acs.remove(9);
        acs.remove(10);

        System.out.println(acs.remove(9));
        acs.printList();
        System.out.println(acs.reverseLs());








    }
}
