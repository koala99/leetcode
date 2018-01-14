package Adapter;

public class Adapter extends Adaptee implements Target {

    @Override
    public void function2() {
        System.out.println("快速实现方法2");
    }

}
