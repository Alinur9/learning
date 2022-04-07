
abstract class Pen {
    abstract void write();

    abstract void refill();
}
    class FountainPen extends Pen{
        void changeNib(){
            System.out.println("Changing the Nib");

        }
        void write(){
            System.out.println("Write");
        }
        void refill(){
            System.out.println("Refill");
        }
    }

        class Monkey {
            public void jump() {
                System.out.println("Jumping");
            }
            public void bite() {
                System.out.println("Biting");
            }
        }
        interface BasicAnimal{
    void eat();
    void sleep();
        }
      class Human extends Monkey implements BasicAnimal{
    void speak(){
        System.out.println("Hello Xyz");
    }
         @Override
         public void eat() {
             System.out.println("Eating");
         }

         @Override
         public void sleep() {
             System.out.println("Sleeping");
         }
     }

public class QsolAbstractmNdInterfacem {
    public static void main(String[] args) {
        FountainPen pen = new FountainPen();
        pen.changeNib();

        Human ahsan = new Human();
        ahsan.speak();

        Monkey crazy = new Human();
        crazy.bite();

    }
}
