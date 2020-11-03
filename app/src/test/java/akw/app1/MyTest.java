package akw.app1;

import org.junit.Test;

import akw.app1.blackjack.Card;

public class MyTest {

    @Test
    public void test1()  {
        Box2 b2 = new Box2(10, 10);
        Box b1 = new Box(10, 10);

        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);

        b2.setWidth(20);
        b1.setWidth(20);

        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);

        Card c1 = new Card(1,1);

    }
}
