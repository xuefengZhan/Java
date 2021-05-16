package _12_泛型;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _03_泛型类型可以用的地方 {
    public static void main(String[] args) {
        List<?>[] arr = new List<?>[2];
        arr[0] = Arrays.asList("1","2");
        arr[1] = Arrays.asList("1","2");
        for (List<?> list : arr) {
            for (Object o : list) {
                System.out.println(o);
            }
        }

        // todo 编译错误
        // ArrayList<String>[] array = new ArrayList<String>[5];
    }
}


class MyClass<T> {
    //todo 泛型类的泛型可以当做一个类型用于类内部任何地方
    //todo 不能用于静态属性、静态方法、静态代码块中！！！
}
