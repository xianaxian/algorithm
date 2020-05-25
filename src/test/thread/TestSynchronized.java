package test.thread;

/**
 * @author xiana  2020-05-14 23:55
 */
//锁静态方法和普通方法的区别
class TestThread1 {

    public static synchronized void run() {

        try {
            System.out.println( "test");
            Thread.sleep(1000000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class TestSynchronized {
    public static void main(String[] args) {
        Thread thread1 = new Thread(TestThread1::run);
        thread1.start();
        Thread thread2 = new Thread(TestThread1::run);
        thread2.start();
    }
}
