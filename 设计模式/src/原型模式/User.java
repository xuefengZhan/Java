package 原型模式;

import java.io.Serializable;
import java.util.Date;

/**
 * 原型类：被克隆的类型
 * @author
 *
 * 浅克隆
 */

//todo 1.被克隆的对象必须Cloneable,Serializable这两个接口
public class User implements Cloneable,Serializable{

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
     */
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Date date =  new Date(1231231231231L);
        User user = new User();
        user.setName("波波烤鸭");
        user.setAge(18);
        user.setBirth(date);
        System.out.println("----输出原型对象的属性------");
        System.out.println(user);
        System.out.println(user.getName());
        System.out.println(user.getAge());
        System.out.println(user.getBirth());

        // 克隆对象
        User user1 =(User) user.clone();
        // 克隆后修改原型对象中的属性
        user.setName("波波烤兔");
        user.setAge(19);
        date.setTime(123231231231L);
        System.out.println("----输出原型对象修改后的属性------");
        System.out.println(user);
        System.out.println(user.getName());
        System.out.println(user.getAge());
        System.out.println(user.getBirth());

        // 修改参数

        System.out.println("----输出克隆对象的属性------");
        System.out.println(user1);
        System.out.println(user1.getName());
        System.out.println(user1.getAge());
        System.out.println(user1.getBirth());


        //todo 结论：浅克隆 是值克隆  说明两个对象的Date的引用是同一个
    }

}
