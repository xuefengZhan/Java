package 图;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName leetcode_207_课程表
 * @Author zxf
 * @Date 2023/3/3 16:18
 *
 *
 * 62.5%
 **/
public class leetcode_207_课程表 {
    //key 是课程id
    //value 是该课程的下游列表
    HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    boolean valid = true;
    int[] visited;


    public boolean canFinish(int numCourses, int[][] prerequisites) {


        visited = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int[] line = prerequisites[i];

            int to = line[1];
            int from = line[0];
            List<Integer> froms = map.getOrDefault(to, new ArrayList<Integer>());
            froms.add(from);
            map.put(to,froms);
        }

        for (int i = 0; i < numCourses; i++) {
            if(!valid) break;
            if(visited[i] == 0){
                dfs(i);
            }
        }
        return valid;


    }


    private void dfs(int node){
        if(visited[node] == 1){
            valid = false;
            return;
        }
        // 置为1 表示当前节点正在访问中 前正在从i节点往下游搜 如果搜的过程中存在节点状态为1 说明有环
        visited[node] = 1;

        List<Integer> tos = map.get(node);

        if(tos != null && ! tos.isEmpty()){
            for (Integer to : tos) {
                //只有为0的时候再往下遍历  为2不用遍历了 为1 就出错
                if(visited[to] == 0){
                    dfs(to);
                    //下游有环后 不需要遍历当前层了
                    if(!valid){
                        break;
                    }
                }else if(visited[to] == 1){
                    valid = false;
                    break;
                }

            }
        }
        //如果该节点及其所有下游节点都遍历完了 则将状态置为2
        visited[node] = 2;
    }
}
