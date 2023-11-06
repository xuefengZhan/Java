package dfs.欧拉回路;

import java.util.*;

/**
 * @ClassName leetcode_332_重新安排行程
 * @Author zxf
 * @Date 2023/9/26 18:39
 * @Questinon Describrition
 **/
public class leetcode_332_重新安排行程 {

    List<List<String>> paths = new ArrayList<>();
    Map<String,List<String>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        //初始化map
        for (List<String> ticket : tickets) {
            String key = ticket.get(0);
            String value = ticket.get(1);

            List<String> strings = map.get(key);
            if(strings == null){
                strings = new ArrayList<>();
            }

            strings.add(value);

            map.put(key,strings);
        }

        //System.out.println("map == " + map);


        ArrayList<String> path = new ArrayList<>();
        path.add("JFK");
        dfs("JFK",map,tickets.size(),path);
        System.out.println(paths);

        paths.sort(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                int size = o1.size();

                for (int i = 0; i < size; i++) {
                    int res = o1.get(i).compareTo(o2.get(i));

                    if(res == 0) continue;
                    return res;
                }
                return 0;
            }
        });

        return paths.get(0);

    }


    private void dfs(String airplane,Map<String,List<String>> map,int ticketNum,List<String> path){

        System.out.println("map == " + map);
        System.out.println("ticketNum == " + ticketNum);

        if(ticketNum == 0){

            System.out.println("path == " + path);
            System.out.println("----------------------------");
            paths.add(new ArrayList<>(path));
            return;
        }

        List<String> nextAirplanes = map.get(airplane);

        for (int i = 0; i < nextAirplanes.size(); i++) {
            String nextAirplane = nextAirplanes.get(i);
            if(Objects.equals(nextAirplane, "")) continue;

            path.add(nextAirplane);
            nextAirplanes.set(i,"");


            dfs(nextAirplane,map,ticketNum-1,path);

            //回溯
            path.remove(path.size() - 1);
            nextAirplanes.set(i,nextAirplane);
        }

    }


    public static void main(String[] args) {
        leetcode_332_重新安排行程 v = new leetcode_332_重新安排行程();

        String[][] arr =  {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};

        List<List<String>> tickets = new ArrayList<>();

        for (String[] strings : arr) {
            ArrayList<String> strings1 = new ArrayList<>(Arrays.asList(strings));
            tickets.add(strings1);
        }

        List<String> res = v.findItinerary(tickets);

        System.out.println(res);
    }
}
