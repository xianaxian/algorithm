package leetcode.y2020m05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xiana  2020-05-25 22:19
 */
public class TestConsumer1 {
    public static void main(String[] args) {
        final Product product=new Product();
//        Thread t1=new Thread(new Consumer1(product));
//        Thread t2=new Thread(new Producer1(product));
//        Thread t3=new Thread(new Producer1(product));
//        t1.start();
//        t2.start();
//        t3.start();
        ExecutorService service= Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            if (i%2==0){
                service.submit(new Consumer1(product));
            }else {
                service.submit(new Producer1(product));
            }
        }
    }
}
class Consumer1 implements Runnable{
    private  Product product;
    Consumer1(Product product){
        this.product=product;
    }

    @Override
    public void run() {
//        for (int i = 0; i < 10; i++) {
//            product.productOne(i);
//            System.out.println("生产了第"+i+"个产品");
//        }
        Integer i=0;
        while (true){
            product.productOne(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
class Producer1 implements Runnable{
    private  Product product;
    Producer1(Product product){
        this.product=product;
    }
    @Override
    public void run() {
//        for (int i = 0; i < 10; i++) {
//            product.consumerOne();
//            System.out.println("消费了第"+i+"个产品");
//        }
        while (true){
            product.consumerOne();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
class Product{
    private volatile Queue<Integer> product=new LinkedList<>();
    private static Integer size=5;
    public synchronized void productOne(Integer val){
        while (product.size()>=size){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product.add(val);
        System.out.println("此时仓库还有"+product.size()+"个产品，生产了一个");
        notifyAll();
    }
    public synchronized Integer consumerOne(){
        while (product.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Integer poll = product.poll();
        System.out.println("此时仓库还有"+product.size()+"个产品，消费了一个");
        notifyAll();
        return poll;
    }
}