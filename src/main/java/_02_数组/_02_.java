package _02_数组;

public class _02_ {
    public static void main(String[] args) {
        //todo 1.声明
        int[][] a;
        int b[][];
        //todo 2.静态初始化
        int[][] c = new int[][]{
                                {1,2,3,4},
                                {1,2}
                                };

        int[][] d = {
                        {1,2,3,4},
                        {1,2}
                    };

        //todo 动态初始化
        // 动态初始化二维数组，一维的个数必须确定，二维可确定可以不确定
        int[][] e = new int[5][];
        int[][] f = new int[3][1];


        //todo 遍历
        // 1.双层for循环
        // 2.增强for循环
        for(int[] g : f){
            for(int h : g){
                System.out.println(h);
            }
        }


    }
    public int[] s(int[] a){
        return a;
    }
    public int[][] ss(int[][] b){
        return b;
    }
}
