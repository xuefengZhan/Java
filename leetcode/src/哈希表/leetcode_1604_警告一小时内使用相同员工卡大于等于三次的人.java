package 哈希表;

import java.util.*;

/**
 * @ClassName leetcode_1604_警告一小时内使用相同员工卡大于等于三次的人
 * @Author zxf
 * @Date 2023/2/7 10:43
 **/
public class leetcode_1604_警告一小时内使用相同员工卡大于等于三次的人 {
    HashMap<String, Map<Integer,String>> map = new HashMap<>();

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];

            if(!map.containsKey(name)){
                Map<Integer,String> newMap = new HashMap<>();
                newMap.put(1,time);
                map.put(name,newMap);
            }else {
                Map<Integer,String> oldMap = map.get(name);

                //第一次打卡时间
                String firstTime = oldMap.get(1);
                //第二次打卡时间
                String secondTime = oldMap.get(2);

                //如果是第二次
                if(secondTime == null){
                    //如果大于1小时
                    if(lt1hour(time,firstTime)){
                        oldMap.put(1,time);
                    }else{
                        oldMap.put(2,time);
                    }
                }else{
                    //如果是第三次
                    if(lt1hour(secondTime,time)){
                        oldMap.clear();
                        oldMap.put(1,time);
                    }else if(lt1hour(firstTime,time) && !lt1hour(secondTime,time)){
                        oldMap.put(1,secondTime);
                        oldMap.put(2,time);
                    }else if(!lt1hour(firstTime,time) && !lt1hour(secondTime,time)){
                        list.add(name);
                    }
                }
            }
        }
        Collections.sort(list);
        return list;

    }



    private boolean lt1hour(String t1,String t2){
        int h1 = Integer.parseInt(t1.substring(0,2)) % 24;
        int h2 = Integer.parseInt(t2.substring(0,2)) % 24;

        int m1 = Integer.parseInt(t1.substring(3,5));
        int m2 = Integer.parseInt(t2.substring(3,5));

        if(h1 == h2 ||  (h2 == h1 + 1 && m2 <= m1)) return false;
        return true;
    }

    public static void main(String[] args) {
        leetcode_1604_警告一小时内使用相同员工卡大于等于三次的人 v = new leetcode_1604_警告一小时内使用相同员工卡大于等于三次的人();
        boolean b = v.lt1hour("23:27", "03:14");
        System.out.println(b);
    }


}
