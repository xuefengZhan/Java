import java.util.Arrays;

public class No807_城市天际线 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {

        int[] maxRows = new int[grid.length];
        int[] maxCols = new int[grid[0].length];

        for(int i = 0;i<grid.length;i++){
            int[] row = grid[i];
            int lineMax =  row[0];
            for(int j = 1;j < row.length;j++){
                if(row[j] > lineMax) lineMax = row[j];
            }
            maxRows[i] = lineMax;
        }

        System.out.println(Arrays.toString(maxRows));

        for(int j = 0;j<grid[0].length;j++){
            int colMax = grid[0][j];
            for(int i = 1;i<grid.length;i++){
                if(grid[i][j] > colMax) colMax = grid[i][j];
            }
            maxCols[j] = colMax;
        }

        System.out.println(Arrays.toString(maxCols));

        int diff =  0;
        for(int i = 0;i < grid.length;i++){
            for(int j  = 0;j<grid[0].length;j++){
                int aft = Math.min(maxRows[i],maxCols[j]);
                int pre = grid[i][j];

                diff = diff + aft - pre;
            }
        }


        return diff;
    }


    public static void main(String[] args) {
        No807_城市天际线 v = new No807_城市天际线();
        int[][] grid = {
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}
        };

        int i = v.maxIncreaseKeepingSkyline(grid);

        System.out.println(i);
    }
}

