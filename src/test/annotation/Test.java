package test.annotation;

/**
 * @author xiana  2020-05-15 01:19
 */
class F{
    public void call(){
        System.out.println("F call");
    }
}
class S1 extends F{
    @Override
    public void call(){
        System.out.println("S1 CALL");
    }
}
class S2 extends F{
    @Override
    public void call(){
        System.out.println("S2 CALL");

    }
    public void call(String name){
        System.out.println(name+" CALL");
    }
}
public class Test {
    public static void main(String[] args) {
        F []fs=new F[3];
        fs[0]=new F();
        fs[1]=new S1();
        fs[2]=new S2();
        for (int i = 0; i < fs.length; i++) {
            fs[i].call();
        }
    }
}
