package Bean;

import java.sql.Time;

public class student{
    private int id;
    private String name;
    private int age;
    private int gender;
    private String movie;
    private Time create_time;

    public student(int id, String name, int age, int gender, String movie, Time create_time) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.movie=movie;
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", movie='" + movie + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}