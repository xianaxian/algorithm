package test;

/**
 * @author xiana  2020-04-29 13:46
 */
public class PrintABC {
    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreadPrint pa = new ThreadPrint("A", c, a);
        ThreadPrint pb = new ThreadPrint("B", a, b);
        ThreadPrint pc = new ThreadPrint("C", b, c);

        new Thread(pa).start();
        Thread.sleep(10);//保证初始ABC的启动顺序
        new Thread(pb).start();
        Thread.sleep(10);
        new Thread(pc).start();
        Thread.sleep(10);
    }
}
class ThreadPrint implements Runnable{
    private String printString;
    private Object preLock;
    private Object selfLock;

    public ThreadPrint(String printString, Object pre, Object selfLock) {
        this.printString = printString;
        this.preLock = pre;
        this.selfLock = selfLock;
    }

    @Override
    public void run() {
        int count=10;
        while (count>0){
            synchronized (preLock){
                synchronized (selfLock){
                    count--;
                    System.out.println(printString+count);
                    selfLock.notifyAll();
                }
                try {
                    preLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}