package _11_集合._collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Objects;

public class _03_map {
    @Test
    public void test01(){
        HashMap<student, String> hashMap = new HashMap<>();
        hashMap.put(new student(19,"张三"),"1");
        hashMap.put(new student(19,"李四"),"2");
        hashMap.put(new student(19,"王五"),"3");
        hashMap.put(new student(19,"赵六"),"4");
        hashMap.put(new student(19,"前妻"),"5");
        hashMap.put(new student(19,"虎妈"),"6");
        hashMap.put(new student(19,"拼接"),"7");
        hashMap.put(new student(19,"阿萨德"),"8");
        hashMap.put(new student(19,"玩儿"),"9");
        hashMap.put(new student(19,"是的"),"10");
        hashMap.put(new student(19,"爱给网"),"11");
        hashMap.put(new student(19,"返回"),"12");
        hashMap.put(new student(19,"地方"),"13");
        hashMap.put(new student(19,"而"),"14");

//        HashMap<Integer,String> hashMap = new HashMap<>();
//
//        hashMap.put(1,"1");
//        hashMap.put(1,"2");
//        hashMap.put(1,"3");


    }
}

//构造一个对象，其hashCode根据age来，equals根据age和name来
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
