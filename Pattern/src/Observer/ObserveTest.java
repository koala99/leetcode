package Observer;


public class ObserveTest {
    public static void main(String args[]){
        DetailSubject subject = new DetailSubject();
        Observer observer = new DetailObserver();
        subject.add(observer);
        subject.change("改变状态");
    }
}
