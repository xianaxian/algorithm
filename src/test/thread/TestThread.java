package test.thread;

/**
 * @author xiana  2020-05-14 22:43
 */
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("MyThread.run()"+i);
        }
    }
}
class RunThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("RunThread.run()"+i);
        }
    }
}
public class TestThread {

    public static void main(String[] args) {
//        MyThread a=new MyThread();
//        a.start();
        RunThread a=new RunThread();
        Thread t1=new Thread(a,"");
        Thread t2=new Thread(a);
        Thread t3=new Thread(a);
        t1.start();
        t2.start();
        t3.start();
        for (int i = 0; i < 50 ; i++) {
            System.out.println("test1.main()---"+i);
        }
    }
}
