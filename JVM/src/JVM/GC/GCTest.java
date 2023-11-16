package GC;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GCTest
 * @Author zxf
 * @Date 2023/6/1 16:22
 **/
public class GCTest {
    public static void main(String[] args) {
        int i = 0;

        try{
            List<String> list = new ArrayList<>();
            String a = "asdasd";

            while(true){
                list.add(a);
                a = a + a ;
                i++;
            }
        }catch(Throwable t){
            t.printStackTrace();
            System.out.println("遍历次数" + i);
        }
    }
}
