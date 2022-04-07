
abstract class CellPhone2{
    abstract void ring();
    abstract void camera();
    abstract void games();
}
class SmartPhone extends CellPhone2{
    public  void mail(){
        System.out.println("You have a official mail ");
    }
    public void ring(){
        System.out.println("xyz calling");

    } public void camera(){
        System.out.println("its a nice shot");

    } public void games(){
        System.out.println("playing PUBG game ");

    }
}

public class QsolAbNintfc {
    public static void main(String[] args) {

        CellPhone2 c1 = new SmartPhone();
        c1.ring();

        SmartPhone s1 = new SmartPhone();
        s1.mail();

    }
}
