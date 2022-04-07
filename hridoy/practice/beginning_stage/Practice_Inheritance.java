class animal{
    String typeOfAnimal;
    String color;
    public String getTypeOfAnimal() {
        return typeOfAnimal;
    }
    public void setTypeOfAnimal(String typeOfAnimal) {
        this.typeOfAnimal = typeOfAnimal;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
class updateAnimal extends animal{
    String behavior;
    public String getBehavior() {
        return behavior;
    }
    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }
}


public class Practice_Inheritance {
    public static void main(String[] args) {

        animal myAnimal = new animal();
        myAnimal.setTypeOfAnimal("dog");
        myAnimal.setColor("white");

        updateAnimal uB = new updateAnimal();
        uB.setBehavior("Bucks The Tongue");
        uB.setColor("red");

        System.out.println(uB.getBehavior());
        System.out.println(uB.color);
    }
}
//hello world how are you? i am a good boy how are you? amar naam alinu8r tomar naaam ki