package Observer;


public class DetailSubject extends Subject {
    private String state;
    public String getState(){
        return state;
    }

    public void change(String newState){
        state = newState;
        System.out.println("主角的状态："+state);
        this.notifyObserver(state);
    }
}
