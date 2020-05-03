package test;

import java.util.ArrayList;

/**
 * @author xiana  2020-04-27 15:44
 */
public class TestArrayListAdd {
    public static void main(String[] args) {
        ArrayList<Integer> test=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            test.add(i);
        }
        test.add(1);
    }
}
