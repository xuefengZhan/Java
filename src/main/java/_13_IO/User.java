package _13_IO;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private static int score = 20;          //static 属性也不会被序列化，类属性；反序列化构建对象的时候仍为类值
    private transient String height = "高"; //transient的属性不会被序列化，反序列化构建对象的时候按照默认值构建对象
    private String sex;

    public User(String name, int age, String height, String sex) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.sex = sex;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        User.score = score;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height='" + height + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}