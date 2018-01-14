package Decorator;


public class DecoratorTest {
    public static void main(String args[]) {
        Component decorator = new DetailComponent();
        Component a = new DecoratorA(decorator);
        Component b = new DecoratorB(decorator);
        a.function1();
        b.function1();
    }
}
