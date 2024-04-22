package dfs;

/**
 * @ClassName leetcode_2397_被列覆盖的最多行数
 * @Author zxf
 * @Date 2024/1/4 15:25
 * @Questinon Describrition
 **/
public class leetcode_2397_被列覆盖的最多行数 {
    //从cols列中 选numSelect列出来，然后剩下的列中有1则不计入
    int n ;
    int m ;
    int[] arr;
    int res = 0;

    public int maximumRows(int[][] matrix, int numSelect) {

        m = matrix.length;
        n = matrix[0].length;

        //声明一个数组 每个元素代表一行 换算成十进制的值
        arr = new int[m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i] = (arr[i] << 1) + matrix[i][j];
            }
        }

        //System.out.println("arr = " + Arrays.toString(arr));

        dfs(0,0,numSelect);
        return res;
    }

    /**
     *
     * @param choosed      目前的数字
     * @param numSelect     还有几位要选
     */
    private void dfs(int choosed,int len ,int numSelect){

        //当长度大于n 意味着结束了
        if(len > n) return;

        //当长度等于n且可选1的次数选完了 意味着正好
        if(len == n && numSelect == 0){
            //System.out.println("================================");
            int curRes = 0;
            for (int i : arr) {
               // System.out.println("choosed == " + choosed);
               // System.out.println("i == " + i);
               // System.out.println((i & choosed) == i);
                if((i & choosed) == i) curRes ++;
            }
            res = Math.max(res,curRes);

            return;
        }

        int a = (choosed << 1) + 1;
        int b = choosed << 1;

        //选择
        if(numSelect > 0){
            dfs( a ,len+1,numSelect-1);
            dfs(b,len+1,numSelect);
        }else{
            dfs(b,len+1,numSelect);
        }


    }

    public static void main(String[] args) {
        leetcode_2397_被列覆盖的最多行数 v = new leetcode_2397_被列覆盖的最多行数();
        int[][] matrix = {{0,0,0},{1,0,1},{0,1,1},{0,0,1}};

        int i = v.maximumRows(matrix, 2);

        System.out.println(i);
    }
}
