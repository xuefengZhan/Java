package _11_集合._collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Collection01_collection {
    @Test
    public void test1(){
        Collection coll = new ArrayList();//ArrayList是Collection的子接口List的实现类
        coll.add("张三");
        coll.add("李四");
        coll.add("王五");
        coll.add("张三");

        System.out.println("coll集合元素的个数：" + coll.size());
    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(1);
        coll.add(2);

        System.out.println("coll集合元素的个数：" + coll.size());

        Collection other = new ArrayList();
        other.add(1);
        other.add(2);
        other.add(3);

       // coll.addAll(other);
        coll.add(other);
        System.out.println("coll集合元素的个数：" + coll.size());

        System.out.println(Arrays.toString(coll.toArray()));   //[1, 2, [1, 2, 3]]

    }
}
