import java.util.ArrayList;
import java.util.Random;

class Wrk{
    boolean flag = false;
    public int[] arr2 = new int[40];
    public ArrayList<Integer> arr3 = new ArrayList<>();
    public int a = 0;
    public int prCount;
    public int crCount;
    public synchronized int getPrCount()
    {
        return prCount;
    }
    public synchronized int getCrCount(){
        return crCount;
    }

    public synchronized void produce(int num){
        arr2[a] = num;
        prCount++;
    //    arr3.add(a,num);
        System.out.println("Produced num: "+num);
        flag = true;
        notify();
    }
    public synchronized void consume(int num){
        crCount++;
        System.out.println("Consumed num: "+num);
        flag = false;
        notify();
    }
}
class Produce implements Runnable {
    Wrk w;
    Random r = new Random();
    long sleep = (long) (Math.random()*1000);


    public Produce(Wrk w) {
        this.w = w;
        Thread p = new Thread(this, "Producer");
        p.start();
    }
    @Override
    public void run() {
        for (int num = 0; num < 40; num++) {
            while (w.getCrCount() +2 < w.getPrCount()){
                try {
                    Thread.sleep((long) Math.random());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            w.produce(num);
            w.a++;

         //   w.a++;
            try {
             //  System.out.println(sleep);
                Thread.sleep((long) Math.random()*1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
class Consume implements Runnable{
    Random r = new Random();
    long sleep = r.nextLong() / 1000;
    Wrk w;
    public int[] arr2;
    public ArrayList<Integer> arr3;
    public Consume(Wrk w){
        this.w = w;
        this.arr2 = w.arr2;
        this.arr3 = w.arr3;
        Thread c = new Thread(this,"Consumer");
        c.start();
    }

    @Override
    public void run() {
    //    for (int x : arr3){
    //        w.consume(x);
        for (int x = 0; x < arr2.length;x++){
            while (w.getCrCount() >= w.getPrCount()){
                if (w.getCrCount() == arr2.length)
                    break;
                try {
                    Thread.sleep((long) Math.random());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
                w.consume(arr2[x]);

            try {
                Thread.sleep((long) (Math.random()*1000));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
public class ProduceConsumer {

    public static void main(String[] args){
        Wrk w = new Wrk();
        Produce a = new Produce(w);
        Consume b = new Consume(w);

    }
}
