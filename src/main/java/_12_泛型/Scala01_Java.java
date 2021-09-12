package _12_泛型;

import java.util.ArrayList;
import java.util.List;

public class Scala01_Java {
    public static void main(String[] args) {
        List list = new ArrayList();

        //todo 1.
        list.add(new Emp());
        List<User> users = list;

//        List<User> list1 = new ArrayList();
//        list1.add(new Emp());


    }
}

class User{}
class Emp{}
