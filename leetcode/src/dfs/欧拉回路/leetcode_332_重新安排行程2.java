package dfs.欧拉回路;

import java.util.*;

/**
 * @ClassName leetcode_332_重新安排行程
 * @Author zxf
 * @Date 2023/9/26 18:39
 * @Questinon Describrition
 **/
public class leetcode_332_重新安排行程2 {

    List<String> path = new ArrayList<>();
    Map<String,List<String>> map = new HashMap<>();

    boolean is_continue = true;

    public List<String> findItinerary(List<List<String>> tickets) {

        tickets.sort(new Comparator<List<String>>() {
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

        System.out.println("map == " + map);

        path.add("JFK");
        dfs("JFK",tickets.size());
        return path;

    }

    private void dfs(String airplane,int ticketNum){

        if(! is_continue) return;

        if(ticketNum == 0){
            this.path = new ArrayList<>(path);
            is_continue = false;
            return;
        }

        List<String> nextAirplanes = map.get(airplane);
        if(nextAirplanes == null) return;
        for (int i = 0; i < nextAirplanes.size(); i++) {
            String nextAirplane = nextAirplanes.get(i);
            if(Objects.equals(nextAirplane, "")) continue;

            path.add(nextAirplane);
            nextAirplanes.set(i,"");
            dfs(nextAirplane,ticketNum-1);
            //回溯
            path.remove(path.size() - 1);
            nextAirplanes.set(i,nextAirplane);
        }
    }


    public static void main(String[] args) {
        leetcode_332_重新安排行程2 v = new leetcode_332_重新安排行程2();

        String[][] arr =  {{"JFK","SFO"},{"JFK","ATL"},{"SFO","JFK"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"}};

        List<List<String>> tickets = new ArrayList<>();

        for (String[] strings : arr) {
            ArrayList<String> strings1 = new ArrayList<>(Arrays.asList(strings));
            tickets.add(strings1);
        }

        List<String> res = v.findItinerary(tickets);

        System.out.println(res);
    }
}
