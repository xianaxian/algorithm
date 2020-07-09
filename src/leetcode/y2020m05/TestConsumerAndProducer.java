package leetcode.y2020m05;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiana  2020-05-16 10:19
 */

/**
 * 消费者
 */
class Consumer extends Thread {
    private AtomicInteger productSize;
    private String name;
    private Object object;
    public Consumer(Object obj,AtomicInteger productSize, String name) {
        this.productSize = productSize;
        this.name = name;
        this.object=obj;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (object) {
                if (productSize.get() > 0) {
                    System.out.println(name + " consumer 消费了一个产品,还剩" + productSize.addAndGet(-1) + "个产品");
                }else {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                object.notifyAll();
            }
        }
    }
}

class Producter extends Thread {
    private AtomicInteger productSize;
    private String name;
    private Object object;
    private static final Integer productMaxSize = 10;

    public Producter(Object obj,AtomicInteger productSize, String name) {
        this.productSize = productSize;
        this.name = name;
        this.object=obj;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (object) {
                if (productSize.get() < productMaxSize) {
                    System.out.println(name + " producer 生产了一个产品，一共有" + productSize.addAndGet(1) + "个产品");
                }else {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                object.notifyAll();
            }
        }
    }
}

public class TestConsumerAndProducer {
    public static void main(String[] args) {
        AtomicInteger produceSize = new AtomicInteger(5);
        final Object lock=new Object();
        Thread product1 = new Producter(lock,produceSize, "生产者1");
        Thread consumer1 = new Consumer(lock,produceSize, "消费者1");
        product1.start();
        consumer1.start();
    }
}
