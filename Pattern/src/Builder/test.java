package Builder;

public class test {
    public static void mian(String args[]) {
        new User.UserBuilder("王", "小二")
                .age(20)
                .phone("123456789")
                .address("亚特兰蒂斯大陆")
                .build();
    }
}
