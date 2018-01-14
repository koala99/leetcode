package Decorator;


public class Decorator implements Component {
   private  Component component;

    public Decorator(Component component){
        this.component = component;
    }
    @Override
    public void function1() {
        //委派
        component.function1();
    }
}
