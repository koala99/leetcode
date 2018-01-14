package Observer;

import java.util.ArrayList;
import java.util.List;


public class Subject {
    //保存观察者对象
    private List<Observer> list = new ArrayList<>();

    public void add(Observer observer){
        list.add(observer);
    }
//
//    public void  delete(Observer observer){
//        list.remove(observer);
//    }

    public void notifyObserver(String code){
        for(Observer observer:list){
           observer.update(code);
        }
    }
}
