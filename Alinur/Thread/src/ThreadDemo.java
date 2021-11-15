public class ThreadDemo extends Thread{
    public Thread t;
    public String threadName;

    public ThreadDemo(String name){
        threadName = name;
        System.out.println("creating "+threadName);
    }
    @Override
    public void run() {
        System.out.println("running "+threadName);
        try {
            for (int i = 4; i > 0; i--)
                System.out.println(threadName+ ": " + i);
            Thread.sleep(50);
        }
        catch (InterruptedException e){
            System.out.println("thread "+threadName+" interrupted");
        }
        System.out.println("thread "+threadName+" exiting");
    }
    public void start(){
        System.out.println("starting "+threadName);
        if (t == null){
            t = new Thread(this,threadName);
            t.start();
        }
    }
}

