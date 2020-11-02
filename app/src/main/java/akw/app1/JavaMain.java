package akw.app1;

public class JavaMain {
    public static void main(String[] args) {
        Box2 b2 = new Box2(10,10);
        Box b1 = new Box(10,10);

        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);

        b2.setWidth(20);
        b1.setWidth(20);

        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);
    }
}
