package _11_集合._collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Objects;

public class _03_map {
    @Test
    public void test01(){
        HashMap<student, String> hashMap = new HashMap<>();
        hashMap.put(new student(19,"张三"),"a");
        hashMap.put(new student(19,"李四"),"a");
        hashMap.put(new student(19,"王五"),"a");
        hashMap.put(new student(19,"赵六"),"a");
        hashMap.put(new student(19,"前妻"),"a");
        hashMap.put(new student(19,"虎妈"),"a");
        hashMap.put(new student(19,"拼接"),"a");
        hashMap.put(new student(19,"阿萨德"),"a");
        hashMap.put(new student(19,"玩儿"),"a");
        hashMap.put(new student(19,"是的"),"a");


    }
}

class student{
    int age;
    String name;

    public student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        student student = (student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(age);
    }
}
