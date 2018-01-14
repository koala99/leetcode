package Observer;


public class DetailObserver implements Observer {
    private String observerState;

    @Override
    public void update(String state) {
        observerState = state;
        System.out.println("当前观察到的状态："+observerState);
    }
}
