package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author whx
 * @dare 2020/4/19 19:27
 */
public class TestDeleteFromList {
    public static void main(String[] args) {
        Integer[]a=new Integer[]{1,2,3,4,5,6};
        List<Integer> list= new ArrayList<>(Arrays.asList(a));
        //        List<Integer> list= Arrays.asList(a);
        //          ↑这种写法得到的是一个不可变的list
        TestDeleteFromList test=new TestDeleteFromList();
        test.deleteByForEach(list);
        //for-each循环不可以循环删除元素
        test.deleteByFor(list);
        //for循环删除要注意下标的问题
        test.deleteByIterator(list);
        //iterator可以循环删除，由于使用的是迭代器，所以并不需要注意下标
    }
    public void deleteByForEach(List<Integer> list){
        //for-each循环删除
        for (Integer integer : list) {
            System.out.println(integer+"将要被删除了");
//            list.remove(integer);
        }
        System.out.println("删除后的长度"+list.size());
    }
    public void deleteByFor(List<Integer> list){
        //for-each循环删除
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i)+"将要被删除了");
            list.remove(list.get(i));
            i--;
        }
        System.out.println("删除后的长度"+list.size());
    }
    public void deleteByIterator(List<Integer> list){
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println(next+"将要被删除了");
            iterator.remove();
        }
        System.out.println("删除后的长度"+list.size());
    }
}
