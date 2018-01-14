package StaticProxy;

public class UserImpl implements IUser {
    @Override
    public void eat(String s) {
        System.out.println("正在吃" + s);
    }
}
