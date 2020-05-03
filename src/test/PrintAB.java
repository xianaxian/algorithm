package test;

/**
 * @author xiana  2020-04-29 16:32
 */
public class PrintAB {
    public static void main(String[] args) throws InterruptedException {
        Object a=new Object();
        Object b=new Object();
        Object c=new Object();
        Print printA=new Print("A",c,a);
        Print printB=new Print("B",a,b);
        Print printC=new Print("C",b,c);
        new Thread(printA).start();
        Thread.sleep(10);//保证初始ABC的启动顺序
        new Thread(printB).start();
        Thread.sleep(10);//保证初始ABC的启动顺序
        new Thread(printC).start();
        Thread.sleep(10);//保证初始ABC的启动顺序
    }
}
class Print implements Runnable{
    private String printString;
    private Object other;
    private Object self;

    public Print(String printString, Object other, Object self) {
        this.printString = printString;
        this.other = other;
        this.self = self;
    }

    @Override
    public void run() {
        int count=10;
        while (count>0) {
            synchronized (other) {
                synchronized (self) {
                    System.out.println(printString+count);
                    count--;
                    //唤醒
                    self.notify();
                }
                try {
                    other.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}