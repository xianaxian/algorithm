package test;

import java.util.Date;
import java.util.StringJoiner;

/**
 * @author xiana  2020-04-20 18:25
 */
public class TestSet {
    public static void main(String[] args) {
        User w=new User();
        w.setName("汪");
        w.setAge(10);
        String name = w.getName();
        Integer age = w.getAge();
        Date day = w.getDay();
        name="li";
        age=new Integer(20);
        double tenYear=10*365.25*24*60*60*1000;
        day.setTime((long) (day.getTime()-tenYear));
        System.out.println(w);
    }
}
class User{
    private String name;
    private Integer age;
    private Date day=new Date();
    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDay() {
        //由于Date方法提供setTime方法，实际上破坏了封装性，所以应该返回day的clone.
        return (Date) day.clone();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .add("day=" + day)
                .toString();
    }
}