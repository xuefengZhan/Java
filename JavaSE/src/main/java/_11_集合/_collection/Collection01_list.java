package _11_集合._collection;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class Collection01_list {
    List<Integer> list=new ArrayList<Integer>();


    @Before
    public void test1(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);

    }


    //todo  错误方式
    @Test
    public void test2(){
        //1 2 3 3 4
        for(int i=0;i<list.size();i++){
            // i = 2的时候 删除了第一个3  [1 2 3 4]
            // 下一轮i = 4 直接跳过了第二个3
            if(list.get(i)==3) list.remove(i);
        }
        System.out.println(list);

    }


    //todo  正确方式   元素删除的同时，也调整指针
    @Test
    public void test3(){
        //1 2 3 3 4
        for(int i=0;i<list.size();i++){
            if(list.get(i)==3) list.remove(i--);
        }
        System.out.println(list);
    }

    //todo 正确方式 倒序遍历List删除元素
    @Test
    public void test4(){
        for(int i=list.size()-1;i>=0;i--){

            if(list.get(i)==3){
                list.remove(i);
            }
        }
        System.out.println(list);
    }


    //todo foreach遍历List删除元素--错误！！！
    @Test
    public void test5(){
        for(Integer i:list){
            if(i==3) list.remove(i);
        }
        System.out.println(list);
        //每次正常执行 remove 方法后，都会对执行expectedModCount = modCount赋值，保证两个值相等，那么问题基本上已经清晰了，
        // 在 foreach 循环中
        //执行 list.remove(item);，对 list 对象的 modCount 值进行了修改，
        // 而 list 对象的迭代器的 expectedModCount 值未进行修改，因此抛出了ConcurrentModificationException异常。

    }

    //todo 迭代删除List元素--正确！
    //java中所有的集合对象类型都实现了Iterator接口，遍历时都可以进行迭代：
    //Iterator.remove() 方法会在删除当前迭代对象的同时，会保留原来元素的索引。所以用迭代删除元素是最保险的方法，
    // 建议大家使用List过程中需要删除元素时，使用这种方式。
    @Test
    public void test6(){
        Iterator<Integer> it=list.iterator();
        while(it.hasNext()){
            if(it.next()==3){
                it.remove();
            }
        }
        System.out.println(list);

    }


    //todo 错误
    @Test
    public void test7(){
        Iterator<Integer> it=list.iterator();
        while(it.hasNext()){
            Integer value=it.next();
            if(value==3){
                list.remove(value);
            }
        }
        System.out.println(list);

    }


    //todo 7、List删除元素时，注意Integer类型和int类型的区别.
    @Test
    public void test8(){
        list.remove(2);  //[1, 2, 3, 4]
        System.out.println(list);

    }
    //可以看出,List删除元素时传入数字时，默认按索引删除。
    // 如果需要删除Integer对象，调用remove(object)方法，需要传入Integer类型，代码如下：
    // 底层调用equals方法
    @Test
    public void test9(){
        list.remove(new Integer(2)); //[1, 3, 3, 4]
        System.out.println(list);
    }


    //todo 总结
    //   1、用for循环遍历List删除元素时，需要注意索引会左移的问题。
    //   2、List删除元素时，为避免陷阱，建议使用迭代器iterator的remove方式。
    //   3、List删除元素时，默认按索引删除，而不是对象删除。
}
