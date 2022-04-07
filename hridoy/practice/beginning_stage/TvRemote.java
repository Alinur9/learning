interface Remote{
    void switchOn();
    void switchOff();
    void nextButton();
    void previousButton();
}
interface RemoteUpdate extends Remote{
    void channelGroup1();
    void channelGroup2();
}
class  SmartTv implements  RemoteUpdate{
    @Override
    public void channelGroup1() {
        System.out.println("Btv, Independent, Jamuna Tv");
    }
    @Override
    public void channelGroup2() {
        System.out.println("SonyMax, StarGold, Mtv");
    }
    @Override
    public void switchOn() {
        System.out.println("Hello Buddy :)");
    }
    @Override
    public void switchOff() {
        System.out.println("Sony Tv ");
    }
    @Override
    public void nextButton() {
        System.out.println("Next channel");
    }
    @Override
    public void previousButton() {
        System.out.println("Previous Button");
    }
}
public class TvRemote {
    public static void main(String[] args) {
        RemoteUpdate user = new SmartTv();
        user.switchOn();
        user.channelGroup1();
        user.nextButton();

        Remote user2 = new SmartTv();
        user2.previousButton(); 


        SmartTv user3 = new SmartTv();
        user3.switchOff();
    }
}
