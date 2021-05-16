package _02_数组;

public class _01_ {
    public static void main(String[] args) {
        //todo 0.两种声明方式
        int[] arr;
        int brr[];

        //todo 1.静态初始化   初始化指定元素是什么
        int[] b = new int[]{1,2,3}; //标准写法
        int[] a = {1,2,3};  // 声明并初始化可以简写

        //todo 2.动态初始化   初始化不指定元素是什么，只指定元素个数
        int[] c = new int[5];
        //后面给c动态赋值

        //todo 3.数组长度
        // 数组是一个类，因此一个数组可以看做一个对象
        // 数组的长度就是该数组实例的属性
        int len = c.length;

        //todo 4.数组遍历
        // 1.普通for循环
        // 2.增强for循环
        for(int i : a){
            System.out.println(i);
        }
    }

}
