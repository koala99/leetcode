package Decorator;


public class DecoratorA extends Decorator {
    public DecoratorA(Component component) {
        super(component);
    }

    @Override
    public void function1() {
        super.function1();
        System.out.println("A在做这个事");
    }
}
