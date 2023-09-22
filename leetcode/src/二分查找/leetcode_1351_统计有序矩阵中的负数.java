package 二分查找;

/**
 * @ClassName leetcode_1351_统计有序矩阵中的负数
 * @Author zxf
 * @Date 2023/4/18 10:43
 **/
public class leetcode_1351_统计有序矩阵中的负数 {
    int  res = 0;

    public int countNegatives(int[][] grid) {
        dfs(grid,0,grid[0].length - 1);

        return res;
    }

    //在[0,right]范围中找nums第一个负数的位置
    private void dfs(int[][] grid,int line,int right){
        if(line == grid.length) return;


        int index = findIndex(grid[line], right);
        //如果当前列没有，有两种可能，一种right = len - 1 , 此时res不动
        //right < len - 1 , res是要加的，由于right是>= 0的因此要 - (right + 1)
        if(index == -1){
            if(right < grid[0].length - 1){
                res += grid[0].length - (right + 1);
            }
            dfs(grid,line+1,right);
        }else{
            //如果当前列有
            res += grid[0].length - index;
            dfs(grid,line+1,index-1);
        }

    }


    //找nums [0,right]范围内第一个负数索引
    private int findIndex(int[] nums,int right){
        if(right == -1) return 0;
        if(nums[right] >= 0) return -1;
        int res = -1;
        int left = 0;
        while(right >= left ){
            int mid = (right - left) / 2 + left;

            if(nums[mid] < 0){
                res = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        leetcode_1351_统计有序矩阵中的负数 v = new leetcode_1351_统计有序矩阵中的负数();
        int[][] grid = {{3,2}, {-3,-3}, {-3,-3}, {-3,-3}};

        int i = v.countNegatives(grid);
        System.out.println(i);
    }
}
