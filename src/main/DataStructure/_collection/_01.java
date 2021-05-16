package _collection;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Vector;

public class _01 {

    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>();
        HashSet<String> h = new HashSet<>();


        //hashSet的add方法返回boolean值，添加成功为true
        System.out.println(h.add("john"));//true
        System.out.println(h.add("lucy"));//true
        System.out.println(h.add("john"));//false
        System.out.println(h.add("jack"));//true
        System.out.println(h.add("Rose"));//true

        h.remove("john");
        System.out.println("set=" + h);

        HashSet<Dog> d = new HashSet<>();
        System.out.println(d.add(new Dog("snoopy"))); //true
        System.out.println(d.add(new Dog("snoopy"))); //true
        System.out.println(d);

        //todo 非常经典的面试题
        h.add(new String("hmp"));//true
        h.add(new String("hmp"));//false
        System.out.println("set=" + h);//set=[Rose, hmp, lucy, jack]

    }

}
class Dog{
    private String name;
    public Dog(){}
    public Dog(String name){
        this.name = name;
    }
}