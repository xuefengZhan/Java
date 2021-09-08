package _10_常用类.字符串;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class join {
    public String join1(String gap, List list){
        if(list == null || list.size() == 0){
            throw new RuntimeException("empty list no join");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if(i == list.size()-1){
                sb.append(list.get(i).toString());
            }else{
                sb.append(list.get(i).toString()).append(gap);
            }
        }
        return sb.toString();
    }

    @Test
    public void test(){
        ArrayList<Integer> i = new ArrayList<>();
        i.add(1);
        i.add(2);
        i.add(3);

        String s = join1("-", i);
        System.out.println(s);
    }
}
