package Decorator;


public class DecoratorB extends Decorator {
    public DecoratorB(Component component) {
        super(component);
    }

    @Override
    public void function1() {
        super.function1();
    System.out.println("B正在委派");
    }
}
