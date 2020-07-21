package test;

import java.util.UUID;

public class Test {
        public static String getId(){
            return UUID.randomUUID().toString().replace("-","").substring(0,20).toUpperCase();
        }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getId());
        }
    }
}
