class PrintDemo{
    public void printCount(){
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Counter " + i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class WorkThread extends Thread{
    public Thread t;
    public String threadName;
    PrintDemo pd;
   WorkThread(String name, PrintDemo pd){
       this.threadName = name;
       this.pd = pd;
   }

    @Override
    public void run() {
       synchronized (pd) {
           pd.printCount();
       }
        System.out.println("Thread "+threadName+ " Exiting");
    }

    @Override
    public void start() {
        System.out.println("starting "+threadName);
        if (t == null){
            t = new Thread(this,threadName);
            t.start();
        }
    }
}
public class ThreadSync {
    public static void main(String args[]){
        PrintDemo pd = new PrintDemo();
        WorkThread t1 = new WorkThread("Thread-1",pd);
        WorkThread t2 = new WorkThread("Thread-2",pd);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (Exception e){
            System.out.println("Thread interrupted");
        }
    }
}
