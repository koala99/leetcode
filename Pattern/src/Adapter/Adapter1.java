package Adapter;


public class Adapter1 {
    public Adaptee adaptee;
    public Adapter1(Adaptee adaptee){
        this.adaptee = adaptee;
    }
    /**
     * 源类Adaptee有方法sampleOperation1
     * 因此适配器类直接委派即可
     */
    public void function1(){
        this.adaptee.function1();
    }
    /**
     * 源类Adaptee没有方法sampleOperation2
     * 因此由适配器类需要补充此方法
     */
    public void function2(){
        //写相关的代码
    }
}
