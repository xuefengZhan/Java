package 单例模式.Hungry;

public class hungry01 {
    public static void main(String[] args) {
        System.out.println(User.instance);
    }
}

class User{
    public static User instance = new User();
    private User(){}




}
