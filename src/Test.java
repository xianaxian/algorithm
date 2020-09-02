import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;

class TestMap{
    String k;
    String v;

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public TestMap(String k, String v) {
        this.k = k;
        this.v = v;
    }
}
public class Test {
    public static void main(String[] args) {
        System.out.println("我是一个测试");
        List<Long> list = new ArrayList<>();
        list.add(123L);
        list.add(223L);
        Iterator<Long> iterator = list.iterator();
        ConcurrentHashMap map = new ConcurrentHashMap();
        HashMap map1 = new HashMap();
        LinkedList linkedList = new LinkedList();
        TestMap t1 = new TestMap("1","2");
        TestMap t2 = new TestMap("1","2");
        List<TestMap> test=new ArrayList<>();
        test.add(t1);
        test.add(t2);
        Map<String, String> collect = test.stream().collect(Collectors.toMap(TestMap::getK, TestMap::getV,(o1, o2) -> o1));
    }
}