package _11_集合._collection;

import org.junit.Test;

import java.util.HashMap;

public class _03_map {
    @Test
    public void test01(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(null,"null");
        hashMap.put("aa","AA");
    }
}
