package test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiana  2020-05-15 10:43
 */

class UserTest{
    private String name;
    private String id;

    public UserTest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
public class TestStream {
    public static void main(String[] args) {
        List<UserTest> test=new ArrayList<>();
        test.stream().map(t->t.getId().toString()).collect(Collectors.toList());
    }
}
