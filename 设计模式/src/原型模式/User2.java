package 原型模式;



import java.io.Serializable;
import java.util.Date;

/**
 * 原型类：被克隆的类型
 * 深度克隆测试
 * @author dengp
 *
 */
public class User2 implements Cloneable,Serializable{

    private String name;

    private Date birth;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 实现克隆的方法
     * 深度克隆(deep clone)
     */
    public Object clone() throws CloneNotSupportedException{
        Object object = super.clone();
        // 实现深度克隆(deep clone)
        User2 user = (User2)object;
        user.birth = (Date) this.birth.clone();
        return object;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Date date =  new Date(1231231231231L);
        User2 user = new User2();
        user.setName("波波烤鸭");
        user.setAge(18);
        user.setBirth(date);
        System.out.println("----输出原型对象的属性------");
        System.out.println(user);
        System.out.println(user.getName());
        System.out.println(user.getBirth());
        // 克隆对象
        User2 user1 =(User2) user.clone();
        // 修改原型对象中的属性
        date.setTime(123231231231L);
        System.out.println(user.getBirth());

        // 修改参数
        user1.setName("dpb");
        System.out.println("-------克隆对象的属性-----");
        System.out.println(user1);
        System.out.println(user1.getName());
        System.out.println(user1.getBirth());
    }
}
