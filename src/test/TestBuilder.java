package test;

import java.util.StringJoiner;

/**
 * @author xiana  2020-05-03 20:05
 */
public class TestBuilder {
    public static void main(String[] args) {
        Person person = new Person.Builder().builderA("A1").builderB("B2").builderC("C3").getPerson();
        System.out.println(person);
    }
}
class Person{
    private String testA;
    private String testB;
    private String testC;
    Person(){}
    Person(Builder builder){
        this.testA=builder.A;
        this.testB=builder.B;
        this.testC=builder.C;

    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("testA='" + testA + "'")
                .add("testB='" + testB + "'")
                .add("testC='" + testC + "'")
                .toString();
    }

    public static class Builder{
        private String A;
        private String B;
        private String C;

        public Builder builderA(String a){
            this.A=a;
            return this;
        }
        public Builder builderB(String b){
            this.B=b;
            return this;
        }
        public Builder builderC(String c){
            this.C=c;
            return this;
        }
        public Person getPerson(){
            return new Person(this);
        }
    }
}