package dfs;

public class leetcode_207_课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        int[] map = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int[] kv = prerequisites[i];
            map[kv[1]] = kv[0];
        }

        return dfs(prerequisites[0][0],visited,map,numCourses);
    }

    private boolean dfs(int start,int[] visited,int[] map,int nonVisitedNum){
        if(visited[start] == 1) return false;
        if(nonVisitedNum == 0) return true;
        visited[start] = 1;
        int next = map[start];

        return dfs(next,visited,map,nonVisitedNum - 1);

    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1,0},{0,1}};

        leetcode_207_课程表 v = new leetcode_207_课程表();
        System.out.println(v.canFinish(numCourses,prerequisites));
    }
}
