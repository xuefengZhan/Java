package _collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class _03_map {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("asd","催化");
        map.put("刘姥姥","大观园");
        map.put("电饭给","大观园");
        map.put("任天野","大观园");
        map.put("刘姥姥","观园");


        Set set = map.entrySet();
        for (Object o : set) {
            System.out.println(o);
        }


        Properties properties = System.getProperties();
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry);
        }
    }
}
