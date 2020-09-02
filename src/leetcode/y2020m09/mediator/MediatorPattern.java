package leetcode.y2020m09.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author whx
 * 中介者模式
 */
public class MediatorPattern {
    public static void main(String[] args) {
        Mediator md = new ConcreteMediator();
        Colleague c1, c2, c3;
        c1 = new ConcreteColleague1();
        c2 = new ConcreteColleague2();
        c3 = new ConcreteColleague3();
        md.register(c1);
        md.register(c2);
        md.register(c3);
        c1.send();
        System.out.println("----------------------------");
        c2.send();
        System.out.println("----------------------------");
        c3.send();
    }
}

abstract class Mediator {
    /**
     * 同事对象注册
     *
     * @param colleague 同事对象
     */
    abstract void register(Colleague colleague);

    /**
     * 转发同事对象信息
     *
     * @param colleague
     */
    abstract void relay(Colleague colleague);
}

class ConcreteMediator extends Mediator {

    List<Colleague> colleagueList = new ArrayList<>();

    @Override
    void register(Colleague colleague) {
        if (!colleagueList.contains(colleague)) {
            colleagueList.add(colleague);
            colleague.setMediator(this);
        }
    }

    @Override
    void relay(Colleague colleague) {
        for (Colleague ob : colleagueList) {
            if (!ob.equals(colleague)) {
                ob.receive();
            }
        }
    }
}

abstract class Colleague {
    public Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 接受信息
     */
    abstract void receive();

    /**
     * 发送信息
     */
    abstract void send();
}

class ConcreteColleague1 extends Colleague {

    @Override
    void receive() {
        System.out.println("具体同事类1收到请求。");
    }

    @Override
    void send() {
        System.out.println("具体同事类1发送请求。");
        mediator.relay(this);
    }
}

class ConcreteColleague2 extends Colleague {

    @Override
    void receive() {
        System.out.println("具体同事类2收到请求。");
    }

    @Override
    void send() {
        System.out.println("具体同事类2发送请求。");
        mediator.relay(this);
    }
}

class ConcreteColleague3 extends Colleague {

    @Override
    void receive() {
        System.out.println("具体同事类3收到请求。");
    }

    @Override
    void send() {
        System.out.println("具体同事类3发送请求。");
        mediator.relay(this);
    }
}