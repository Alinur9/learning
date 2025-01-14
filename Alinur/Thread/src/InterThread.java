class Chat {
    boolean flag = false;

    public synchronized void question(String msg) {
        if (flag == true) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(msg);
        flag = true;
        notify();
    }
    public synchronized void answer(String msg){
        if (flag == false){
            try {
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println(msg);
        flag = false;
        notify();
    }
}
class T1 implements Runnable{
    Chat m;
    String[] s1 = {"Hi!", "How are you?","I am also doing fine!"};
    public T1(Chat m1){
        this.m = m1;
        new Thread(this,"Question").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < s1.length; i++){
            m.question(s1[i]);
        }
    }
}
class T2 implements Runnable{
    Chat m;
    String[] s2 = {"Hi","I am Good, What about you?","Great"};
    public T2(Chat m2){
        this.m = m2;
       Thread t2 = new Thread(this,"Answer");
       t2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < s2.length; i++){
            m.answer(s2[i]);
        }
    }
}
public class InterThread {
    public static void main(String[] args){
        Chat m = new Chat();
        new T1(m);
        new T2(m);

    }
}
